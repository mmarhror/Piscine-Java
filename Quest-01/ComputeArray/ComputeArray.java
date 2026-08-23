
public class ComputeArray {

    public static int[] computeArray(int[] array) {
        if (array == null) {
            return null;
        }

        int[] res = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            res[i] = switch (a % 3) {
                case 0 ->
                    a * 5;
                case 1 ->
                    a + 7;
                default ->
                    a;
            };
        }

        return res;
    }
}
