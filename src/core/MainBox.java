package core;

import java.util.Stack;

public class MainBox {
    private String name;
    private String category;
    private Stack<SubBox> subBoxes;

    public MainBox(String name, String category) {
        this.name = name;
        this.category = category;
        this.subBoxes = new Stack<>();
    }

    // Add SubBox to the Stack
    public void addSubBox(SubBox subBox) {
        subBoxes.push(subBox);
    }

    // LIFO delete for SubBoxes
    public SubBox deleteSubBox() {
        return subBoxes.isEmpty() ? null : subBoxes.pop();
    }

    public Stack<SubBox> getSubBoxes() {
        return subBoxes;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "MainBox [name=" + name + ", subBoxes=" + subBoxes + "]";
    }
}
