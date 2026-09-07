
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("(?<=[0-9])(cm|€)(?=\\s)", "");
    }

    public static String obfuscateEmail(String s) {
        if (s == null) {
            return null;
        }
        
        String domainPat = "[a-zA-Z0-9.]+";

        Pattern pat = Pattern.compile((String.format("([a-zA-Z0-9._-]+)@(%s)", domainPat)));
        Matcher matcher = pat.matcher(s);

        StringBuilder res = new StringBuilder();

        while (matcher.find()) {
            String name = matcher.group(1);
            String domain = matcher.group(2);

            if (name.contains(".") || name.contains("-") || name.contains("_")) {
                name = name.replaceAll("(?<=[._-]).|.(?=[._-])", "*");
            } else if (name.length() > 3) {
                name = name.replaceAll("^.{3}", "***");
            }

            String[] levels = domain.split("\\.");

            if (levels.length == 3) {
                levels[0] = levels[0].replaceAll(".", "*");
                levels[2] = levels[2].replaceAll(".", "*");
            } else if (levels.length == 2) {
                String top = levels[1];

                if (!top.equals("com") && !top.equals("org") && !top.equals("net")) {
                    levels[1] = top.replaceAll(".", "*");
                }
                levels[0] = levels[0].replaceAll(".", "*");
            }

            matcher.appendReplacement(res, name + "@" + String.join(".", levels));
        }

        matcher.appendTail(res);

        return res.toString();

    }
}
