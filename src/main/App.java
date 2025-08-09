package main;

import agents.AdminAgent;
import agents.TempAgent;
import core.Item;
import core.MainBox;
import core.Space;
import core.SubBox;

public class App {
    public static void main(String[] args) {

        // Basic Agent
        TempAgent tmp = new TempAgent();
        AdminAgent a = new AdminAgent();

       Space mySpace = new Space("Main Storage");


       // MainBox with category
       MainBox animalsBox = new MainBox("Animals", "Biology");
       MainBox plantsBox = new MainBox("Plants", "Biology");

       mySpace.addMainBox(animalsBox);
       mySpace.addMainBox(plantsBox);

        // SubBoxes and category
        SubBox carnivors = new SubBox("Carnivors", "Meat-Eater");
        SubBox herbivors = new SubBox("Herbivors", "Plant-Eater");

        SubBox floweringPlants = new SubBox("Flowering Plants", "Have Flowers and Produce Seeds");
        SubBox nonFloweringPlants = new SubBox("Non-Flowering Plants", "Do Not Have Flowers");


        // Add items
        carnivors.addItem(new Item("Lion"));
        herbivors.addItem(new Item("Rabbit"));

        floweringPlants.addItem(new Item("Rose"));
        floweringPlants.addItem(new Item("Sunflower"));

        nonFloweringPlants.addItem(new Item("Pine Tree"));
        nonFloweringPlants.addItem(new Item("Fern"));

        // Basic hierarchy for now
        animalsBox.addSubBox(carnivors);
        animalsBox.addSubBox(herbivors);

        plantsBox.addSubBox(floweringPlants);
        plantsBox.addSubBox(nonFloweringPlants);


        // Display
        for (MainBox mb : mySpace.getMainBoxes()) {
            System.out.println("\nMainBox: " + mb.getName() + " Category: " + mb.getCategory());

                for (SubBox sb : mb.getSubBoxes()) {
                    System.out.println("SubBox: " + sb.getName() + " Category: " + sb.getCategory());

                    for (Item item : sb.getItems()) {
                        System.out.println("Item: " + item.getName());
                    }
                }
        }


            tmp.scan(mySpace);
            tmp.highlight();

            a.verifyTempAgent(tmp, mySpace);
            a.countAllItems(mySpace);
            a.printReport(mySpace);
        }




}
