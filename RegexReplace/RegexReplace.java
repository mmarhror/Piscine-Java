
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        if (s == null) {
            return null;
        }
        // Match 'cm' or '€' preceded by a digit and followed by a space OR end of string ($)
        return s.replaceAll("(?<=[0-9])(cm|€)(?=\\s|$)", "");
    }

    public static String obfuscateEmail(String s) {
        if (s == null) {
            return null;
        }

        Pattern pat = Pattern.compile("([a-zA-Z0-9._-]+)@([a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)+)");
        Matcher matcher = pat.matcher(s);

        StringBuilder res = new StringBuilder();

        while (matcher.find()) {
            String name = matcher.group(1);
            String domain = matcher.group(2);

            // 1. Obfuscate Username
            if (name.contains(".") || name.contains("-") || name.contains("_")) {
                StringBuilder sb = new StringBuilder();
                boolean hide = false;
                for (char c : name.toCharArray()) {
                    if (hide) {
                        sb.append('*');
                    } else {
                        sb.append(c);
                    }
                    // Start hiding characters AFTER we encounter a separator
                    if (c == '-' || c == '.' || c == '_') {
                        hide = true;
                    }
                }
                name = sb.toString();
            } else if (name.length() > 3) {
                name = name.replaceAll("^.{3}", "***");
            }

            // 2. Obfuscate Domain
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

            // 3. Rebuild and append
            matcher.appendReplacement(res, name + "@" + String.join(".", levels));
        }

        matcher.appendTail(res);

        return res.toString();
    }
}
