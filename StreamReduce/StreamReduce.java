
import java.util.stream.Stream;

public class StreamReduce {

    public static Integer sumAll(Stream<Integer> s) {
        return s.mapToInt((e) -> e).sum();
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        return s.mapToInt((e) -> e / divider).sum();
    }
}
