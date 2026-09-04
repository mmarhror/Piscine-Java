
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KeepTheChange {

    static class State {

        int remaining;
        List<Integer> coinsUsed;

        State(int amount, List<Integer> coinsUsed) {
            this.remaining = amount;
            this.coinsUsed = coinsUsed;
        }

    }

    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        if (amount <= 0 || coins == null || coins.isEmpty()) {
            return new ArrayList<>();
        }

        Queue<State> queue = new LinkedList<>();
        boolean[] seen = new boolean[amount + 1];

        queue.add(new State(amount, new ArrayList<>()));
        seen[amount] = true;

        while (!queue.isEmpty()) {
            State state = queue.poll();

            for (int coin : coins) {
                int rem = state.remaining - coin;

                List<Integer> coinsUsed = new ArrayList<>(state.coinsUsed);
                coinsUsed.add(coin);

                if (rem == 0) {
                    coinsUsed.sort((a, b) -> b - a);;
                    return coinsUsed;
                }

                if (rem > 0 && !seen[rem]) {
                    seen[rem] = true;
                    queue.add(new State(rem, coinsUsed));
                }

            }
        }

        return new ArrayList<>();
    }

}
