package core;

public class Item {
    private String name;
   // private String category;

    public Item(String name) {
        this.name = name;
       // this.category = category;
    }

    public String getName() {
        return name;
    }

//    public String getCategory() {
//        return category;
//    }

    public String toString() {
        return name;
    }
}
