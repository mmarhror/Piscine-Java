
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Capitalize {

    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            return;
        }

        String src = args[0];
        String dest = args[1];

        String content = new String(Files.readAllBytes(Paths.get(src)));

        // Try-with-resources guarantees the file is closed and saved correctly
        try (OutputStream out = new FileOutputStream(dest)) {
            out.write(cap(content).getBytes());
        }
    }

    static String cap(String in) {
        StringBuilder res = new StringBuilder();
        boolean capital = true;

        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                res.append(ch); // Keeps spaces, tabs, newlines, and punctuation exactly as they are
                capital = true; // Marks the start of a potential new word
            } else {
                if (capital) {
                    res.append(Character.toUpperCase(ch));
                    capital = false; // Toggled immediately (even if 'ch' is a digit like in "1337hello")
                } else {
                    res.append(Character.toLowerCase(ch));
                }
            }
        }

        return res.toString();
    }
}
