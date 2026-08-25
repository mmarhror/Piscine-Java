
import java.io.*;
import java.nio.file.*;

public class FileManager {

    public static void createFile(String fileName, String content) throws IOException {
        Files.createFile(Paths.get(fileName));

        OutputStream out = new FileOutputStream(fileName);

        out.write(content.getBytes());
    }

    public static String getContentFile(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName));
    }

    public static void deleteFile(String fileName) throws IOException {
        Files.delete(Paths.get(fileName));
    }
}
