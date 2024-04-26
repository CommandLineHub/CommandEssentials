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

package essentials.handlers;

import essentials.debug.LogType;
import essentials.debug.Logger;
import essentials.threads.ThreadManager;

/**
 * This class manages any errors that our apps encounter.
 * @package essentials.handlers
 */
public class ErrorHandler {
    /**
     * Throws a new error that was encountered.
     * @param className the name for the calling class
     * @param exception the exception that was thrown
     * @param exit are we exiting the app execution? true = yes, false = no
     * @param message the message regarding this error
     * @param params optional parameters list
     */
    public static void throwError(String className, Throwable exception, boolean exit, String message, Object... params) {
        Logger logger = Logger.createInstance(className);
        logger.log(LogType.ERROR, message + exception != null ? " Exception => " + exception.getMessage() : "", params);
        ThreadManager.shutdown();
        System.exit(1);
    }

    /**
     * Throws a new error that was encountered.
     * @param className the name for the calling class
     * @param exception the exception that was thrown
     * @param message the message regarding this error
     * @param params optional parameters list
     */
    public static void throwError(String className, Throwable exception, String message, Object... params) {
        throwError(className, exception, true, message, params);
    }

    /**
     * Throws a new error that was encountered.
     * @param className the name for the calling class
     * @param exception the exception that was thrown
     */
    public static void throwError(String className, Throwable exception) {
        throwError(className, exception, true, null, Object[].class);
    }

    /**
     * Throws a new error that was encountered.
     * @param className the name for the calling class
     * @param message the message regarding this error
     * @param params optional parameters list
     */
    public static void throwError(String className, String message, Object... params) {
        throwError(className, null, true, message, params);
    }
}
