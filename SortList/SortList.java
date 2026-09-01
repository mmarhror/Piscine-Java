
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }

        list.sort(Integer::compareTo);

        return list;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return null;
        }

        list = sort(list);
        Collections.reverse(list);

        return list;
    }
}
