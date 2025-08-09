package agents;

import core.Item;
import core.MainBox;
import core.Space;
import core.SubBox;

import java.util.*;

public class TempAgent implements AgentManager {

    // Private variable (findings). Store the results of scan. String is the key, and the value is qual ot the list of objects
    private final Map<String, List<Item>> findings = new HashMap<>();


    @Override
    public Map<String, List<Item>> scan(Space space) { // Take the space object and populate findings
        findings.clear(); // Clear the map before scans

      /**  Nested Loops: Iterate through object
       *    MainBoxes within Space, SubBoxes within a MainBox
       *    Items in a SubBoxes
         */
        for (MainBox mainbox : space.getMainBoxes()) {
            for (SubBox subbox : mainbox.getSubBoxes()) {
                String cat = subbox.getCategory(); // Retrieve category of the current SubBox
                for (Item item : subbox.getItems()) {

                    // Adding an item to a map, checks if a list for the cat (key) exists in the map
                    // If not create a new ArrayList that is associated with the cat key. If it does return the already made list
                    findings.computeIfAbsent(cat, k -> new ArrayList<>()).add(item); // add current item ot the list

                }
            }
        }
        return findings; // After iterating through all items, return the populated findings map
    }

    // Return a new map, of unmodified lists
    public Map<String, List<Item>> getFindings() {
        Map<String, List<Item>> safe = new HashMap<>(); // Empty hashmap creation
        for (Map.Entry<String, List<Item>> e : findings.entrySet()) { // Loop iterates through each key and value in the private findings map
            safe.put(e.getKey(), Collections.unmodifiableList(e.getValue())); // Take the key from e.getKey() and add it to the safe Map, Take the value List <Item> from e.getValue(). Wrapped in a unmodifiable list (cannot be changed)
        }
        return Collections.unmodifiableMap(safe); // Return the final read only version of the map
    }

    // Calculate the total number of items
    public int getFindingItemCount() {
        /**
         * findings.value() = return the collections of values in the findings map
         * .stream() = convert the collection of lists into a stream (sequence of elements)
         * .mapToInt(List ::size) = transform stream, takes each list and maps it to an int
         * .sum() = calculate ths sum of int values: Total number of items found
         */
        return findings.values().stream().mapToInt(List::size).sum();
    }

    // Formatted Results
    public void highlight() {
        System.out.println("\nTemp agent highlights: "); // Header for console
        if (findings.isEmpty()) { // Check if findings map is empty, print..
            System.out.println("No items found - scan space first");
            return;
        }
        for (Map.Entry<String, List<Item>> e : findings.entrySet()) { // Iterate through each entry in thenfindings map

            System.out.println("\nCategory: " + e.getKey()); // Print the category in key map
            for (Item item : e.getValue()) { // Nested loop, iterate through List <Item> associated with category
                System.out.println(item.getName()); // Print the items in the list
            }
        }
    }

    public Object getMetadata() {

        return null;
    }

}





