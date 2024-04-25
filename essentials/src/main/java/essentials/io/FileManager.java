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

package essentials.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import essentials.debug.Logger;
import essentials.handlers.ErrorHandler;

/**
 * File management class for working with files.
 * @package essentials.io
 */
public class FileManager {
    /**
     * Intance of our debug logger.
     * @var Logger
     */
    private static final Logger logger = Logger.createInstance(FileManager.class.getName());

    /**
     * Creates a brand new file.
     * If the file does exist, this will do nothing.
     * @param filename the file object
     */
    public static void create(File filename) {
        try {
            filename.createNewFile();
        } catch (IOException e) {
            ErrorHandler.throwError(e, "The attempt to create the file [%s] failed due to an IO exception.", filename.getAbsolutePath());
        } catch (Exception e) {
            ErrorHandler.throwError(e, "The attempt to create the file [%s] failed due to an exception.", filename.getAbsolutePath());
        }
    }

    /**
     * Creates a brand new file.
     * If the file does exist, this will purge that file.
     * @param filename the file path string
     */
    public static void create(String filename) {
        create(new File(filename));
    }

    /**
     * Reads the given file and returns its contents.
     * @param filename the file object
     * @return file contents
     */
    public static String read(File filename) {
        String contents = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) contents += line;
        } catch (IOException e) {
            ErrorHandler.throwError(e, "The attempt to read the contents of file [%s] failed due to an IO exception.", filename.getAbsolutePath());
        } catch (Exception e) {
            ErrorHandler.throwError(e, "The attempt tor ead the contents of file [%s] failed due to an exception.", filename.getAbsolutePath());
        }

        return contents;
    }

    /**
     * Reads the given file and returns its contents.
     * @param filename the file path string
     * @return file contents
     */
    public static String read(String filename) {
        return read(new File(filename));
    }

    /**
     * Writes the given contents to the given file.
     * @param filename the file object
     * @param contents the contents to write to file
     */
    public static void write(File filename, String contents) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(contents);
        } catch (IOException e) {
            ErrorHandler.throwError(e, "The attempt to write the contents to the file [%s] failed due to an IO exception.", filename.getAbsolutePath());
        } catch (Exception e) {
            ErrorHandler.throwError(e, "The attempt to write the contents to the file [%s] failed due to an exception.", filename.getAbsolutePath());
        }
    }

    /**
     * Writes the given contents to the given file.
     * @param filename the file path string
     * @param contents the contents to write to file
     */
    public static void write(String filename, String contents) {
        write(new File(filename), contents);
    }
}
