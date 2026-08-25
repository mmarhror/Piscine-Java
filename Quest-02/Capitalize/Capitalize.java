
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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

        String[] words = in.split(" ");

        ArrayList<String> res = new ArrayList<>();

        for (String w : words) {
            if (!w.isEmpty()) {
                res.add(w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase());
            }
        }

        return String.join(" ", res);
    }
}
