
import java.io.*;
import java.nio.file.*;
import java.util.Optional;

public class FileSearch {

    public static String searchFile(String fileName) throws IOException {
        Optional<Path> res = Files.find(Paths.get("documents"), Integer.MAX_VALUE, (path, attrs) -> path.getFileName().toString().equals(fileName)).findFirst();

        if (res.isPresent()) {
            return res.get().toString();
        } else {
            return null;
        }

    }

}
