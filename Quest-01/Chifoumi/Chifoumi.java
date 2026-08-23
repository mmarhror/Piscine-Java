
public class Chifoumi {

    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        return switch (chifoumiAction) {
            case ROCK ->
                ChifoumiAction.SCISSOR;
            case PAPER ->
                ChifoumiAction.ROCK;
            default ->
                ChifoumiAction.PAPER;
        };
    }
}
