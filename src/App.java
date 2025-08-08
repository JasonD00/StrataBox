import core.Item;
import core.MainBox;
import core.Space;
import core.SubBox;

public class App {
    public static void main(String[] args) {

       Space mySpace = new Space("Main Storage");

       // MainBox with category
       MainBox animalsBox = new MainBox("Animals", "Biology");
       //MainBox plantsBox = new MainBox("Plants", "");

       mySpace.addMainBox(animalsBox);
       //mySpace.addMainBox(plantsBox);

        // SubBoxes and category
        SubBox carnivors = new SubBox("Carnivors", "Meat-Eater");
        SubBox herbivors = new SubBox("Herbivors", "Plant-Eater");

        // Add items
        carnivors.addItem(new Item("Lion"));
        herbivors.addItem(new Item("Rabbit"));

        // Basic hierarchy for now
        animalsBox.addSubBox(carnivors);
        animalsBox.addSubBox(herbivors);

        // Display
        for (MainBox mb : mySpace.getMainBoxes()) {
            System.out.println("MainBox: " + mb.getName() + " Category: " + mb.getCategory());

                for (SubBox sb : mb.getSubBoxes()) {
                    System.out.println("SubBox: " + sb.getName() + " Category: " + sb.getCategory());

                    for (Item item : sb.getItems()) {
                        System.out.println("Item: " + item.getName());
                    }
                }
        }
        }
    }
