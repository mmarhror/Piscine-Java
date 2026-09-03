
import java.util.ArrayList;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>(list);

        res.sort((a, b) -> a - b);
        return res;

    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>(list);

        res.sort((a, b) -> b - a);
        return res;

    }
}
