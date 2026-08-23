
public class StringReplace {

    public static String replace(String s, String target, String replacement) {
        if (target == null || replacement == null) {
            return s;
        }
        return s.replace(target, replacement);
    }
}
