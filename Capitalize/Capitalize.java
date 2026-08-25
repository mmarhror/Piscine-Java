
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

        OutputStream out = new FileOutputStream(dest);
        out.write(cap(content).getBytes());

    }

    static String cap(String in) {
        in = in.toLowerCase();

        boolean capital = true;

        String res = "";

        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                res += ch;
                capital = true;

            } else if (Character.isLetter(ch) && capital) {
                res += Character.toUpperCase(ch);
                capital = false;

            } else {
                res += ch;
            }

        }

        return String.join(" ", res.trim().split("\\s+")) + "\n";
    }
}
