class Product {
    static double discount = 10.0;
    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayDetails() {
        if (this instanceof Product) {
            System.out.println(
                    "Product: " + productName + ", ID: " + productID + ", Price: " + price + ", Qty: " + quantity);
        }
    }
}
