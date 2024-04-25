/**
 * Command Line Hub
 * Essentials Core Library
 * 
 * By Sam Wilcox <sam@cmdlinehub.org>
 * https://www.cmdlinehub.org
 * 
 * View the user-end license agreement at:
 * https://license.cmdlinehub.org
 */

package essentials.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The ThreadManager class manages threads within our applications.
 * @package essentials.threads
 */
public class ThreadManager {
    /**
     * Thread pool holding all our running threads.
     * @var ExecutorService
     */
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    /**
     * List of all of our completed threads.
     * @var List<String>
     */
    private static final List<String> completedThreads = new ArrayList<>();

    /**
     * Thread locking mechanism.
     * @var Object
     */
    private static final Object lock = new Object();

    /**
     * Executes a task in the thread pool.
     * @param task the task to execute
     */
    public static void execute(Runnable task) {
        synchronized(lock) {
            threadPool.execute(task);
        }
    }

    /**
     * Shuts down the thread pool.
     */
    public static void shutdown() {
        synchronized (lock) {
            threadPool.shutdown();
        }
    }

    /**
     * Waits for all threads in the pool to terminate.
     * @throws InterruptedException if any thread interrupts the current thread while waiting
     */
    public static void awaitTermination() throws InterruptedException {
        synchronized (lock) {
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }
    }

    /**
     * Adds the name of the completed thread to the list.
     * @param threadName the name of the completed thread
     */
    public static void addCompletedThread(String threadName) {
        synchronized (lock) {
            completedThreads.add(threadName);
        }
    }

    /**
     * Retrieves the list of completed thread names.
     * @return the list of completed thread names
     */
    public static List<String> getCompletedThreads() {
        synchronized (lock) {
            return completedThreads;
        }
    }
}
