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

import essentials.debug.LogType;
import essentials.debug.Logger;

/**
 * Moving bar progress indication thread operations class.
 * @package essentials.threads
 */
public class MovingBar implements Runnable {
    /**
     * Instance of our debug logger.
     * @var Logger
     */
    private static final Logger logger = Logger.createInstance(MovingBar.class.getName());

    /**
     * The total width (total character) for the moving progress bar.
     * @var int
     */
    private static final int MAX_WIDTH = 80;

    /**
     * The current position of the characeter.
     * @var int
     */
    private int position = 0;

    /**
     * The direction of the moving bar.
     * 1 = RIGHT, -1 = LEFT
     * @var int
     */
    private int direction = 1;

    /**
     * Holds the current output string to the console.
     * @var string
     */
    private String currentOutput = "";

    /**
     * Main thread operations take place here.
     */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (int i = 0; i < MAX_WIDTH; i++) {
                System.out.print("\b \b");
            }

            this.currentOutput += "=";

            System.out.print("\r" + this.currentOutput + ">");
            System.out.flush();

            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                logger.log(LogType.WARNING, "Thread sleep was interrupted during the progress bar thread execution. Exception => %s", e.getMessage());
            }

            this.position += this.direction;

            if (this.position <= 0 || this.position >= MAX_WIDTH) {
                this.direction *= -1;
            }
        }
    }    
}
