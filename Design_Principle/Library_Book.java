import java.util.*;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    String name;
    List<Book> books = new ArrayList<>();

    Library(String name) {
        this.name = name;
    }

    void addBook(Book b) {
        books.add(b);
    }
}

public class Library_Book {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James");
        Book b2 = new Book("Python", "Guido");

        Library lib1 = new Library("Central");
        Library lib2 = new Library("City");

        lib1.addBook(b1);
        lib2.addBook(b2);
    }
}
