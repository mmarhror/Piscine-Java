
public class SortArgs {

    public static void sort(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - i - 1; j++) {
                if (biggerNum(args[j], args[j + 1])) {
                    String temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
        System.out.println(String.join(" ", args) + "\n");
    }

    static boolean biggerNum(String a, String b) {
        return Integer.parseInt(a) > Integer.parseInt(b);
    }
}
