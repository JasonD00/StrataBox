package agents;

import core.Item;
import core.Space;

import java.util.List;
import java.util.Map;

public interface AgentManager {
Map<String, List<Item>> scan(Space space); // Method will return a map through scan method for all implementations

}
