import java.io.*;
import java.nio.file.*;

public class FileHandler {
    private static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {
        // Step 1: Write to a file
        writeFile("This is the initial content of the file.\n");

        // Step 2: Read the file content
        System.out.println("Reading file after writing:");
        readFile();

        // Step 3: Modify (Append) the file
        modifyFile("Adding more text to the file.\n");

        // Step 4: Read the modified file
        System.out.println("\nReading file after modification:");
        readFile();
    }

    // Method to write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify (append to) a file
    public static void modifyFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(content);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}
