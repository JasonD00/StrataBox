package agents;

import core.Item;
import core.MainBox;
import core.Space;
import core.SubBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class AdminAgent implements AgentManager {


    @Override
    public Map<String, List<Item>> scan(Space space) {

        Map<String, List<Item>> analysis = new HashMap<>(); // Create a map called analysis

            // Iterate through hierarchy
            for(MainBox mainbox : space.getMainBoxes()) {
                for(SubBox subbox : mainbox.getSubBoxes()) {
                    String cat = subbox.getCategory();
                    for(Item item : subbox.getItems()) {

                        // For each item, computeIfAbsent to find or crete a List based on the sub category in SubBox (cat)
                        analysis.computeIfAbsent(cat, k -> new ArrayList<>()).add(item);


                    }
                }
            }
            return analysis; // Return the completed analysis
    }

    // Calculate the total number of items in a Space
    public int countAllItems(Space space) {
        /**
         * Calls its own scan method, gens a map, .values() get the collection of List<Item>
         *     .stream() stream from collection, .map.ToInt(List ::size) maps the integer size
         *     sum() of integers for final count......
         */
        return scan(space).values().stream().mapToInt(List ::size).sum();

    }
    // Generate a Summary of what is found
    public void printReport(Space space) {
        System.out.println("\nAdmin Agent Report: ");
        System.out.println("MainBoxes: " + space.getMainBoxes().size());

        int subBoxCount = space.getMainBoxes().stream().mapToInt(mb -> mb.getSubBoxes().size()).sum();
        System.out.println("SubBoxes: " + subBoxCount);

        System.out.println("Total Items: " + countAllItems(space));


    }

    // Check the TempAgents work, make sure scan is correct
    public boolean verifyTempAgent( TempAgent tempAgent, Space space ) {
        int adminCount = countAllItems(space); // Counts all items in a space
        int tempCount = tempAgent.getFindingItemCount(); // Call get findings from TempAgent to get recorded count

        if(adminCount != tempCount) { // Compare the 2 and report mismatch
            System.out.println("[AdminAgent] Count Mismatch: admin: " + adminCount + " temp: " + tempCount );

        }

        return adminCount == tempCount;
    }

}
