
import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> merge = new HashSet<>(set1);

        merge.addAll(set2);

        return merge;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> merge = new HashSet<>(set1);

        merge.retainAll(set2);

        return merge;
    }
}
