package core;

import java.util.Stack;

public class SubBox {
    private String name;
    private String category;
    private Stack<Item> items = new Stack<>();

    public SubBox(String name, String category) {
        this.name = name;
        this.category = category;
        this.items = new Stack<>();
    }

    // Add item to the stack
    public void addItem(Item item) {
        items.push(item);
    }

    // If the stack is not empty then pop and remove the top item
    public Item deleteItem() {
        return items.isEmpty() ? null : items.pop();
    }

    // return items
    public Stack <Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "SubBox: " + name + " [ " + category + " ] " + items + "]";
    }


}
