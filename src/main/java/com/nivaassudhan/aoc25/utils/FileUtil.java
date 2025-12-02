package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileUtil {

    /**
     * Reads all lines from a file and returns them as a List of Strings.
     * * @param filename The name of the file to read (e.g., "input.txt").
     * @return A List<String> containing all lines, or an empty List on error.
     */
    public static List<String> readInputFile(String filename) {
        try {
            // 1. Create a Path object pointing to the file.
            Path filePath = Path.of(filename);

            // 2. Read all lines from the file into the List.
            // This is the most common and concise way to handle AoC input.
            return Files.readAllLines(filePath);

        } catch (IOException e) {
            // This block handles common errors (file not found, read permission issues).
            System.err.println("ERROR: Could not read file: " + filename);
            e.printStackTrace();

            // Return an empty, unmodifiable list on failure to prevent NullPointerExceptions
            // in the calling code.
            return Collections.emptyList();
        }
    }
}
