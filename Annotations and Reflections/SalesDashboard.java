package Annotations_and_Reflection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Item {
    private String name;
    private double price;
    private String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    // For distinct() based on name
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " ($" + price + ") [" + category + "]";
    }
}

class Order {
    private LocalDate date;
    private List<Item> items;

    public Order(LocalDate date, List<Item> items) {
        this.date = date;
        this.items = items;
    }

    public LocalDate getDate() { return date; }
    public List<Item> getItems() { return items; }
}

public class SalesDashboard {
    public static void main(String[] args) {
        // ==== Sample Data ====
        Item laptop = new Item("Laptop", 1200, "Electronics");
        Item mixer = new Item("Mixer", 150, "Home Appliances");
        Item treadmill = new Item("Treadmill", 800, "Fitness");
        Item phone = new Item("Phone", 900, "Electronics");
        Item blender = new Item("Blender", 120, "Home Appliances");
        Item dumbbells = new Item("Dumbbells", 60, "Fitness");

        Order o1 = new Order(LocalDate.now().minusDays(10), Arrays.asList(laptop, phone));
        Order o2 = new Order(LocalDate.now().minusDays(20), Arrays.asList(mixer, blender));
        Order o3 = new Order(LocalDate.now().minusDays(30), Arrays.asList(treadmill, dumbbells));

        Map<String, List<Order>> store1 = new HashMap<>();
        store1.put("Harshita", Arrays.asList(o1, o2, o3)); // 3 orders in last 60 days
        store1.put("Anjali", Arrays.asList(o2, o3));       // only 2 orders

        Map<String, List<Map<String, List<Order>>>> cityToStoresMap = new HashMap<>();
        cityToStoresMap.put("Delhi", Arrays.asList(store1));

        // ==== Stream Processing ====
        List<Item> topAffordablePicks =
            cityToStoresMap.values().stream() // cities
                .flatMap(List::stream)        // list of stores
                .flatMap(store -> store.entrySet().stream()) // customers
                .filter(entry -> {
                    // At least 3 orders in last 60 days
                    long count = entry.getValue().stream()
                            .filter(o -> ChronoUnit.DAYS.between(o.getDate(), LocalDate.now()) <= 60)
                            .count();
                    return count >= 3;
                })
                .map(Map.Entry::getValue)          // orders
                .flatMap(List::stream)             // flatten orders
                .flatMap(order -> order.getItems().stream()) // items
                .distinct()                        // remove duplicates (based on name)
                .sorted(Comparator.comparingDouble(Item::getPrice).reversed()) // descending price
                .peek(i -> System.out.println("Flowing: " + i.getName() + " - $" + i.getPrice()))
                .skip(2)    // skip top 2 expensive
                .limit(10)  // next 10
                .collect(Collectors.toList());

        System.out.println("\n=== Top Affordable Picks ===");
        topAffordablePicks.forEach(System.out::println);

        // 9. Group by category
        Map<String, List<Item>> groupedByCategory =
            topAffordablePicks.stream()
                .collect(Collectors.groupingBy(Item::getCategory));

        // 10. Count items in Electronics
        long electronicsCount = groupedByCategory.getOrDefault("Electronics", List.of()).size();
        System.out.println("\nElectronics Count: " + electronicsCount);

        // 11. anyMatch → price > 500
        boolean anyOver500 = topAffordablePicks.stream().anyMatch(i -> i.getPrice() > 500);
        System.out.println("Any item > $500? " + anyOver500);

        // 12. allMatch → price > 10
        boolean allAbove10 = topAffordablePicks.stream().allMatch(i -> i.getPrice() > 10);
        System.out.println("All items > $10? " + allAbove10);

        // 13. noneMatch → no empty/null names
        boolean noneInvalid = topAffordablePicks.stream().noneMatch(i -> i.getName() == null || i.getName().isEmpty());
        System.out.println("No invalid names? " + noneInvalid);

        // 14. findFirst → Home Appliances
        groupedByCategory.getOrDefault("Home Appliances", List.of())
                .stream().findFirst()
                .ifPresentOrElse(
                        i -> System.out.println("First Home Appliance: " + i),
                        () -> System.out.println("No Home Appliances found"));

        // 15. findAny → Fitness
        groupedByCategory.getOrDefault("Fitness", List.of())
                .stream().findAny()
                .ifPresentOrElse(
                        i -> System.out.println("Any Fitness Item: " + i),
                        () -> System.out.println("No Fitness items found"));

        // 16. reduce → total value
        double totalValue = topAffordablePicks.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println("Total Value of Selected Items: $" + totalValue);
    }
}
