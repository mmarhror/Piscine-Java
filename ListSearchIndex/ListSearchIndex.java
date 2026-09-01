
import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {

    public static Integer findLastIndex(List<Integer> list, Integer value) {
        return list.lastIndexOf(value);
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        return list.indexOf(value);
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> ms = new ArrayList<>();

        for (Integer i : list) {
            if (i.equals(value)) {
                ms.add(i);
            }
        }

        if (ms.isEmpty()) {
            return null;
        }

        return ms;
    }
}
