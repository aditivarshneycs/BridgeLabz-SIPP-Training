public class Main {
    
    public static void main(String[] args) {
        
        ProductCatalog catalog = new ProductCatalog();
        
        Product product1 = new Product("Laptop", 999.99, 10, "Electronics");
        Product product2 = new Product("Smartphone", 499.99, 20, "Electronics");
        Product product3 = new Product("Coffee Maker", 79.99, 15, "Home Appliances");
        
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);
        
        System.out.println("\nSearching for 'Laptop':");
        catalog.searchByName("Laptop");
        
        System.out.println("\nSearching for 'Electronics':");
        catalog.searchByCategory("Electronics");
        
        System.out.println("\nUpdating stock for 'Smartphone' to 25:");
        catalog.updateStock("Smartphone", 25);
        
        System.out.println("\nSearching for 'Smartphone':");
        catalog.searchByName("Smartphone");
    }
}
