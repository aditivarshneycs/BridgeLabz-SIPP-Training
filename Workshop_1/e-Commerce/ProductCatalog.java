public class ProductCatalog{
    private Product[] products;
    private int size;

    public ProductCatalog() {
        products = new Product[100];
        size = 0;
    }

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
            System.out.println("Product added: " + product.getName());
        } else {
            System.out.println("Catalog is full, cannot add more products.");
        }
    }


    public void searchByName(String name){
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                products[i].displayProduct();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with name: " + name);
        }
    }
    
    
    public void searchByCategory(String category) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                products[i].displayProduct();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in category: " + category);
        }
    }

    public void updateStock(String name, int newStock) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                try {
                    products[i].setStckQuantity(newStock);
                    System.out.println("Stock updated for product: " + name);
                } catch (Exception e) {
                    System.out.println("error updating stock for product " + name );
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No product found with name: " + name);
        }
    }

    public void generateReport(boolean ascending) {
        System.out.println("Product Catalog Report:");
        if(size == 0) {
            System.out.println("No products in catalog.");
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                boolean condition = ascending ? 
                    products[j].getPrice() > products[j + 1].getPrice() : 
                    products[j].getPrice() < products[j + 1].getPrice();

                if (condition) {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }

            }
        }
        System.out.println("Sorted Products:");
        for (int i = 0; i < size; i++) {
            products[i].displayProduct();
        }
    }
}