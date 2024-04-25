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
     * Instance of our debug logger.
     * @var Logger
     */
    private static final Logger logger = Logger.createInstance(ErrorHandler.class.getName());

    /**
     * Throws a new error that was encountered.
     * @param exception the exception that was thrown
     * @param exit are we exiting the app execution? true = yes, false = no
     * @param message the message regarding this error
     * @param params optional parameters list
     */
    public static void throwError(Throwable exception, boolean exit, String message, Object... params) {
        logger.log(LogType.ERROR, message + exception != null ? " Exception => " + exception.getMessage() : "", params);
        ThreadManager.threadShutdown();
        System.exit(1);
    }

    /**
     * Throws a new error that was encountered.
     * @param exception the exception that was thrown
     * @param message the message regarding this error
     * @param params optional parameters list
     */
    public static void throwError(Throwable exception, String message, Object... params) {
        throwError(exception, true, message, params);
    }

    /**
     * Throws a new error that was encountered.
     * @param exception the exception that was thrown
     */
    public static void throwError(Throwable exception) {
        throwError(exception, true, null, Object[].class);
    }

    /**
     * Throws a new error that was encountered.
     * @param message the message regarding this error
     * @param params optional parameters list
     */
    public static void throwError(String message, Object... params) {
        throwError(null, true, message, params);
    }
}
