
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class KeepTheChange {

    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> res = new ArrayList<>();

        if (amount == 0 || coins == null || coins.isEmpty()) {
            return res;
        }

        int[] minCoins = new int[amount + 1];
        int[] lastCoins = new int[amount + 1];

        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for (int num = 1; num <= amount; num++) {
            for (int coin : coins) {
                if (num - coin >= 0) {
                    int rem = num - coin;
                    if (minCoins[rem] + 1 < minCoins[num]) {
                        minCoins[num] = minCoins[rem] + 1;
                        lastCoins[num] = coin;
                    }
                }
            }
        }

        int current = amount;

        while (current > 0) {
            int coin = lastCoins[current];
            res.add(coin);
            current -= coin;
        }

        res.sort((a, b) -> b - a);

        return res;
    }

}
