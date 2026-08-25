
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

        // Try-with-resources closes the output stream automatically
        try (OutputStream out = new FileOutputStream(dest)) {
            out.write(cap(content).getBytes());
        }
    }

    static String cap(String in) {
        in = in.toLowerCase();
        boolean capital = true;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                res.append(ch); // Keeps spaces, newlines, and punctuation exactly as they are
                capital = true; // Next letter should be capitalized
            } else if (Character.isLetter(ch) && capital) {
                res.append(Character.toUpperCase(ch));
                capital = false; // Turn off capital until we hit a non-alphanumeric char
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
