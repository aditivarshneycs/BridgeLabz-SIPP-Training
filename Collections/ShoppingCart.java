import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        HashMap<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Apple", 100);
        productPrices.put("Banana", 50);
        productPrices.put("Orange", 80);

        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Banana", 2);
        cart.put("Apple", 1);
        cart.put("Orange", 3);

        TreeMap<Integer, List<String>> priceMap = new TreeMap<>();
        for (String product : productPrices.keySet()) {
            int price = productPrices.get(product);
            priceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("Cart in insertion order:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }

        System.out.println("\nProducts sorted by price:");
        for (Map.Entry<Integer, List<String>> entry : priceMap.entrySet()) {
            for (String item : entry.getValue()) {
                System.out.println(item + " - ₹" + entry.getKey());
            }
        }
    }
}