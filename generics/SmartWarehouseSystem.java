import java.util.*;

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop"));
        electronicStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Apples"));
        groceryStorage.addItem(new Groceries("Rice"));

        System.out.println("--- Electronics ---");
        Storage.displayItems(electronicStorage.getItems());

        System.out.println("--- Groceries ---");
        Storage.displayItems(groceryStorage.getItems());
    }
}

abstract class WarehouseItem {
    String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public static void displayItems(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            System.out.println(item.getName());
        }
    }
}
