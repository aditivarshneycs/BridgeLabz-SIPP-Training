public class Product {

    private String name;
    private double price;
    private int stockQuantity;
    private String category;

    public Product(String name, double price, int stockQuantity, String category) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public String getCategory() {
        return category;
    }

    public void setStckQuantity(int stockQuantity)  throws Exception {
        if(stockQuantity < 0 || stockQuantity > 1000) {
            throw new Exception("Stock quantity must be between 0 and 1000");
        }
        this.stockQuantity = stockQuantity;
    }

    public void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Stock Quantity: " + stockQuantity);
        System.out.println("Category: " + category);
    }

}