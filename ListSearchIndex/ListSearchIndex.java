
import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {

    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int match = list.lastIndexOf(value);
        return match != -1 ? match : null;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int match = list.indexOf(value);
        return match != -1 ? match : null;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> ms = new ArrayList<>();

        if (list == null) {
            return ms;
        }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(value)) {
                ms.add(i);
            }
        }

        return ms;
    }
}
