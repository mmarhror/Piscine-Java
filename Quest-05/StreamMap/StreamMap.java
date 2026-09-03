
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

    public static Integer sumOfStringLength(Stream<String> s) {
        return s.mapToInt((elem) -> elem.length()).sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.map((elem) -> elem.toUpperCase()).collect(Collectors.toList());
    }

    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.filter((e) -> e > 42).map((e) -> e.intValue()).collect(Collectors.toSet());
    }
}
