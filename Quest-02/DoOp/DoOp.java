
public class DoOp {

    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error";
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);
        String op = args[1];

        if ((op.equals("/") || op.equals("%")) && b == 0) {
            return "Error";
        }

        return switch (op) {
            case "+" ->
                itoa(a + b);
            case "-" ->
                itoa(a - b);
            case "*" ->
                itoa(a * b);
            case "/" ->
                itoa(a / b);
            case "%" ->
                itoa(a % b);
            default ->
                "Error";
        };
    }

    static String itoa(int n) {
        return Integer.toString(n);
    }
}
