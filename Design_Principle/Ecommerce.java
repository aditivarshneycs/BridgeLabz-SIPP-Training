import java.util.*;

class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    List<Product> products = new ArrayList<>();
    void addProduct(Product p) {
        products.add(p);
    }
}

class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
    void placeOrder(Order o) {
        System.out.println(name + " placed an order.");
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Customer c = new Customer("Aditi");
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);

        Order o = new Order();
        o.addProduct(p1);
        o.addProduct(p2);

        c.placeOrder(o);
    }
}

