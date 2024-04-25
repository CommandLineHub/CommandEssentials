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

import java.util.HashMap;
import java.util.Map;

/**
 * The Thread Manager manages all of the threeds that are spawned within
 * our applications.
 * @package essentials.threads
 */
public class ThreadManager {
    /**
     * Holds all current running threads.
     * @var Map<Integer, Thread>
     */
    private static Map<Integer, Thread> registry = new HashMap<>();

    /**
     * Gracefully shuts down all running threads before the application exits,
     * or all threads need to be shutdown.
     */
    public static void threadShutdown() {
        
    }
}
