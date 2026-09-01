
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {

    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        Integer p = inventory.get(productId);

        return p == null ? -1 : p;
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Integer> ent : inventory.entrySet()) {
            if (ent.getValue() == price) {
                res.add(ent.getKey());
            }
        }

        return res;
    }
}
