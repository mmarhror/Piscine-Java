
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> couples = new HashMap<>();
        Queue<String> single = new LinkedList<>(first.keySet());

        Map<String, Integer> nextFavIdx = new HashMap<>();

        while (!single.isEmpty()) {
            String boy = single.poll();

            int propIdx = nextFavIdx.getOrDefault(boy, 0);

            List<String> favs = first.get(boy);

            String girl = favs.get(propIdx);

            String girlPartner = couples.get(girl);

            if (girlPartner == null) {
                couples.put(girl, boy);

            } else {
                List<String> girlFavs = second.get(girl);

                int boyRank = girlFavs.indexOf(boy) == -1 ? Integer.MAX_VALUE : girlFavs.indexOf(boy);
                int partnerRank = girlFavs.indexOf(girlPartner) == -1 ? Integer.MAX_VALUE : girlFavs.indexOf(girlPartner);

                if (boyRank < partnerRank) {
                    couples.put(girl, boy);
                    single.add(girlPartner);
                } else {
                    single.add(boy);
                }
            }

            nextFavIdx.put(boy, propIdx + 1);

        }

        Map<String, String> res = new HashMap<>();

        for (Map.Entry<String, String> ent : couples.entrySet()) {
            res.put(ent.getValue(), ent.getKey());
        }

        return res;
    }
}
