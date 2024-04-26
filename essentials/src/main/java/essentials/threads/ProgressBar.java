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
  * Our nifty progress bar thread class.
  * This displays a progress bar for the user so they are aware that
  * we are working on the action they asked us to perform.
  * @package filefusion.lib.progress
  */
 public class ProgressBar implements Runnable {
    /**
     * Instance of our debug logger.
     * @var Logger
     */
    private static final Logger logger = Logger.createInstance(ProgressBar.class.getName());    

    /**
     * The total percentage represented by each # sybmol.
    * @var int
    */
    private static final int PERCENTAGE_PER_BAR = 5;

    /**
     * The total items we are processing.
    * @var int
    */
    private int total;

    /**
     * The current items we have completed.
    * @var int
    */
    private int current;

    /**
     * Constructor that sets up this class properties.
    * @param total the total items to process
    */
    public ProgressBar(int total) {
        this.total = total;
        this.current = 0;
    }
 
    /**
     * Main thread operation takes place here.
    */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            int percent = (int) ((double) this.current / this.total * 100);
            int numberOfBars = percent / PERCENTAGE_PER_BAR;

            StringBuilder progressBar = new StringBuilder("[");

            for (int i = 0; i < numberOfBars; i++) {
                progressBar.append("#");
            }

            for (int i = numberOfBars; i < 20; i++) {
                progressBar.append(" ");
            }

            progressBar.append("] ");
            progressBar.append(percent).append("%");

            System.out.print("\r" + progressBar.toString());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.log(LogType.WARNING, "Thread sleep was interrupted during the progress bar thread execution. Exception => %s", e.getMessage());
            }
        }
    }

    /**
     * Sets the current progress value.
     * @param current the current progress value
     */
    public void setCurrentProgress(int current) {
        this.current = current;
    }
 }
 