
import java.util.ArrayList;

public class CleanExtract {

    public static String extract(String s) {
        ArrayList<String> res = new ArrayList<>();

        for (String word : s.split("\\|")) {
            int f = word.indexOf('.');
            int l = word.lastIndexOf('.');

            if (f == -1 && !word.trim().isEmpty()) {
                res.add(word.trim());
                continue;
            }

            if (f != -1 && f < l) {
                res.add(word.substring(f + 1, l).trim());
            }
        }

        return String.join(" ", res);
    }
}
