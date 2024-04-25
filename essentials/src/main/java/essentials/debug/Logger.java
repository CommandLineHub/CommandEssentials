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

package essentials.debug;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import essentials.io.FileManager;

/**
 * Debugging logger class package.
 * @package essentials.debug
 */
public class Logger {
    /**
     * File holder for the debug log file.
     * @var File
     */
    private File logFile;

    /**
     * The name of the calling class.
     * @var String
     */
    private String className;

    /**
     * Constructor that sets up this class' properties.
     * @param className name of the calling class
     */
    public Logger(String className) {
        this.className = className;
        this.logFile = new File(System.getProperty("java.io.tmpdir") + "/CmdLineHub/logs/" + this.className + "-debug.log");
        this.checkLogFile();
    }

    /**
     * Returns a new instance of the Logger class.
     * @param className name of the calling class
     * @return new Logger instance
     */
    public static Logger createInstance(String className) {
        return new Logger(className);
    }

    /**
     * Logs the given message to the debug log file.
     * @param logType type of log we are logging
     * @param message the message we are writing into the log
     * @param params optional parameters
     */
    public void log(LogType logType, String message, Object... params) {
        writeLog(createMessage(logType, message, params));
    }

    /**
     * Writes the log contents to the log file.
     * @param contents contents to write to log file
     */
    private void writeLog(String contents) {
        FileManager.write(this.logFile, contents);
    }

    /**
     * Creates the formatting for the log message.
     * @param logType the log type
     * @param message the message to log
     * @param params optional parameters
     * @return formatted message string
     */
    private String createMessage(LogType logType, String message, Object... params) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return String.format("[%s][%s][%s]: %s",
            this.className, logType.toString(), currentDateTime.toString(), String.format(message, params)
        );
    }

    /**
     * Checks whether the log file and/or directories exist.
     * If not, they are created.
     */
    private void checkLogFile() {
        if (!this.logFile.exists()) {
            try {
                this.logFile.getParentFile().mkdirs();
                this.logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
