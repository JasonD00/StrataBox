package agents;

import core.Item;
import core.MainBox;
import core.Space;
import core.SubBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempAgent implements AgentManager {



    private final Map<String, List<Item>> findings = new HashMap<>();


    @Override
    public Map<String, List<Item>> scan(Space space) {
        findings.clear();

        for(MainBox mainbox : space.getMainBoxes()) {
            for(SubBox subbox : mainbox.getSubBoxes()) {
                String cat = subbox.getCategory();
                for(Item item : subbox.getItems()) {

                    findings.computeIfAbsent(cat, k -> new ArrayList<>()).add(item);

                }
            }
        }
        return findings;
    }
}





