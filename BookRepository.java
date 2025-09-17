package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Student;
import librarymanagementsystem.StudentRepository;
import librarymanagementsystem.Book;
import librarymanagementsystem.Library;

public class BookRepository {
    private static Map<Integer, Book> books = new HashMap<Integer, Book>();

    public boolean addBook(Book b) {
        if (books.containsKey(b.getId())) {
            System.out.println("Book already exists!");
            return false;
        }

        books.put(b.getId(), b);
        System.out.println("Book added successfully!");
        System.out.println(b);
        return true;
    }

    public boolean upgradeQuantity(int bookId, int extra) {
        Book b = findById(bookId);

        if (b == null) {
            System.out.println("Quantity can't be upgraded!");
            return false;
        }

        b.setTotalQuantity(b.getTotalQuantity() + extra);
        b.setAvailable(b.getAvailable() + extra);
        System.out.println("Quantity upgraded successfully!");
        System.out.println(b.toString());
        return true;
    }

    public Book findById(int bookId) {
        if (books.containsKey(bookId)) {
            return books.get(bookId);
        }

        System.out.println("Book isn't present in the library!");
        return null;
    }

    public List<Book> searchByTitle(String q) {
        List<Book> bookList = new ArrayList<Book>();

        for (Book b : books.values()) {
            if (b.getTitle().contains(q)) {
                bookList.add(b);
            }
        }

        return bookList;
    }

    public List<Book> searchByAuthor(String q) {
        List<Book> bookList = new ArrayList<Book>();

        for (Book b : books.values()) {
            if (b.getAuthor().contains(q)) {
                bookList.add(b);
            }
        }

        return bookList;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books.values());
    }

    public boolean issueBook(int bookId) {
        findById(bookId).decrementAvailable();
        System.out.println("Book issued successfully!");
        return true;
    }

    public boolean returnBook(int bookId) {
        findById(bookId).incrementAvailable();
        System.out.println("Book returned successfully!");
        return true;
    }
}