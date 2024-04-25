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

/**
 * Enumeration of our various logging types.
 */
public enum LogType {
    /**
     * Informative log type.
     */
    INFORMATION,

    /**
     * Warnings log type.
     */
    WARNING,

    /**
     * Error log type.
     * This error type usually results in termination of the application
     * execution.
     */
    ERROR
}
