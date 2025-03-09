import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperations {
    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        // Write data to file
        writeFile("Hello, this is a sample text file.\nWelcome to Java file operations.");

        // Read data from file
        readFile();

        // Modify file content
        modifyFile("sample", "modified");

        // Read updated file
        readFile();
    }

    /**
     * Writes the specified content to the file.
     * @param content The text to be written.
     */
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and prints the content of the file.
     */
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("Reading file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Modifies the file by replacing occurrences of a word with another word.
     * @param oldWord The word to be replaced.
     * @param newWord The replacement word.
     */
    public static void modifyFile(String oldWord, String newWord) {
        try {
            Path path = Paths.get(FILE_PATH);
            List<String> lines = Files.readAllLines(path);
            List<String> modifiedLines = new ArrayList<>();
            
            for (String line : lines) {
                modifiedLines.add(line.replace(oldWord, newWord));
            }
            
            Files.write(path, modifiedLines);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}