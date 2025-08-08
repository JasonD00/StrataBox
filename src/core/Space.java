package core;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private String name;
    private List<MainBox> mainBoxes;

    public Space(String name) {
        this.name = name;
        this.mainBoxes = new ArrayList<MainBox>();
    }

    // MainBox as the parameter and adds it to the space
    public void addMainBox(MainBox mainBox) {
        mainBoxes.add(mainBox); // add method of ArrayList to add to the end of the mainBox list
    }

    /**
     * Here I want to insert an item into a SubBox by searching
     * for its MainBox and SubBox by name (0(n))
     */

    public boolean insertItem(String name, String subBoxName, Item item) {
        for (MainBox mainBox : mainBoxes) { // Goes through each MainBox
            if (mainBox.getName().equalsIgnoreCase(name)) { // If it matches the name parameter is passed in the mainBoxes list

                for (SubBox subBox : mainBox.getSubBoxes()) {
                    if (subBox.getName().equalsIgnoreCase(subBoxName)) {

                        subBox.addItem(item);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<MainBox> getMainBoxes() {
        return mainBoxes;
    }

    @Override
    public String toString() {
        return "Space [name=" + name + ", mainBoxes=" + mainBoxes + "]";
    }

}
