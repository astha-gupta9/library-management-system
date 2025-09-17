package librarymanagementsystem;

import librarymanagementsystem.BookRepository;
import librarymanagementsystem.Student;
import librarymanagementsystem.StudentRepository;
import librarymanagementsystem.Library;

public class Book {
    private int id;
    private String title;
    private String author;
    private int totalQuantity;
    private int available;

    Book (int id, String title, String author, int totalQuantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalQuantity = totalQuantity;
        this.available = totalQuantity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalQuantity() {
        return this.totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getAvailable() {
        return this.available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @java.lang.Override
    public java.lang.String toString() {
        String avail = isAvailable() ? "Available" : "Not Available";
        return "ID: " + getId() + " | Title: " + getTitle() + " | Author: " + getAuthor() + " | Availability: " + avail;
    }

    public boolean isAvailable() {
        if (getAvailable() > 0) return true;

//        System.out.println("Book is out of stock!");
        return false;
    }

    public void incrementAvailable() {
        setAvailable(getAvailable() + 1);
    }

    public void decrementAvailable() {
        setAvailable(getAvailable() - 1);
    }
}