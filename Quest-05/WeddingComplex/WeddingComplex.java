
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(
            Map<String, List<String>> first,
            Map<String, List<String>> second) {

        if (first == null || second == null || first.isEmpty() || second.isEmpty()) {
            return new HashMap<>();
        }

        List<String> freeProposers = new ArrayList<>(first.keySet());

        Map<String, String> engagements = new HashMap<>();

        Map<String, Integer> proposalIndices = new HashMap<>();
        for (String proposer : first.keySet()) {
            proposalIndices.put(proposer, 0); 
        }

        while (!freeProposers.isEmpty()) {
            String proposer = freeProposers.get(0);
            List<String> proposerPrefs = first.get(proposer);

            int nextChoiceIndex = proposalIndices.get(proposer);
            String acceptor = proposerPrefs.get(nextChoiceIndex);

            proposalIndices.put(proposer, nextChoiceIndex + 1);

            if (!engagements.containsKey(acceptor)) {
                engagements.put(acceptor, proposer);
                freeProposers.remove(proposer); 
            } 
            else {
                String currentPartner = engagements.get(acceptor);
                List<String> acceptorPrefs = second.get(acceptor);

                int preferenceOfNew = acceptorPrefs.indexOf(proposer);
                int preferenceOfCurrent = acceptorPrefs.indexOf(currentPartner);

                if (preferenceOfNew < preferenceOfCurrent) {
                    engagements.put(acceptor, proposer);

                    freeProposers.remove(proposer);       
                    freeProposers.add(currentPartner);   
                }
            }
        }

        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : engagements.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }
}
