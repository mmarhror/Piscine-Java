
import java.util.Set;

public class SetEquals {

    public static boolean areSetsEqual(Set<String> set1, Set<String> set2) {
        if (set1 == null) {
            // if (map2 == null) {
            //     return true;
            // }
            return false;
        }
        return set1.equals(set2);
    }
}
