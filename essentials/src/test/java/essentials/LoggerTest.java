/**
 * Command Line Hub
 * Essentials Core Library
 * 
 * UNIT TESTS: Logger
 * 
 * By Sam Wilcox <sam@cmdlinehub.org>
 * https://www.cmdlinehub.org
 * 
 * View the user-end license agreement at:
 * https://license.cmdlinehub.org
 */

package essentials;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import essentials.debug.Logger;

/**
 * Unit tests for testing the Logger component.
 */
public class LoggerTest {
    /**
     * The file object pointing to our log file.
     * @var File
     */
    private File logFile;

    /**
     * Constructor that sets up this test classes properties.
     */
    public LoggerTest() {
        this.logFile = new File(System.getProperty("java.io.tmpdir") + "/CmdLineHub/logs/" + this.getClass().getName() + "-debug.log");
    }

    /**
     * This executes before every test.
     */
    @Before
    public void setUp() {
        cleanupLogFile();
    }

    /**
     * This executes after every test.
     */
    @After
    public void tearDown() {
        cleanupLogFile();
    }

    /**
     * Tests to verify that a new instance is instantiated when createInstance()
     * is called.
     */
    @Test
    public void instantiationTest() {
        Logger logger = Logger.createInstance(LoggerTest.class.getName());
        assertTrue(logger != null && logger instanceof Logger ? true : false);
    }

    /**
     * This tests that the logger creates a new log file when a log
     * file and its directories dont currently exist.
     */
    @Test
    public void dirFileCreationTest() {
        Logger logger = Logger.createInstance(LoggerTest.class.getName());
        assertTrue(this.logFile.exists());
    }

    /**
     * Helper method that deletes the log file if it exists.
     */
    private void cleanupLogFile() {
        try {
            if (this.logFile.exists()) {
                if (this.logFile.delete()) {
                    System.out.println("Log file deleted successfully.");
                } else {
                    System.out.println("Failed to delete log file.");
                }
            } else {
                System.out.println("Log file does not exist.");
            }
        } catch (SecurityException e) {
            System.out.println("Security Exception occurred while deleting log file: " + e.getMessage());
        }
    }
}
