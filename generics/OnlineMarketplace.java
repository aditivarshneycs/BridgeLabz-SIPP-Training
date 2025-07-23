public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 500.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 1000.0, new ClothingCategory());

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 15);

        System.out.println(book.getName() + " after discount: Rs." + book.getPrice());
        System.out.println(shirt.getName() + " after discount: Rs." + shirt.getPrice());
    }
}

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}
