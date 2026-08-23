
public class Chifoumi {

    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        return switch (chifoumiAction) {
            case ROCK ->
                ChifoumiAction.PAPER;
            case PAPER ->
                ChifoumiAction.SCISSOR;
            case SCISSOR ->
                ChifoumiAction.ROCK;
        };
    }
}
