
import java.util.List;

public class ListEquals {

    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        if (list1 == null) {
            if (list2 == null) {
                return true;
            }
            return false;
        }
        return list1.equals(list2);
    }
}
