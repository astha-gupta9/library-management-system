package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Book;
import librarymanagementsystem.Books;
import librarymanagementsystem.Students;
import librarymanagementsystem.Library;

public class Student {
    private int id;
    private String name;
    private Set<Integer> issuedBookIds = new HashSet<>();
    static final int MAX_ISSUED = 10;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getIssuedBookIds() {
        return this.issuedBookIds;
    }

    public boolean canIssueMore() {
        if (getIssuedBookIds().size() >= MAX_ISSUED) {
            System.out.println(getName() + " has reached the maximum number of issues!");
            return false;
        }
        return true;
    }

    public boolean addIssuedBook(int bookId, Books books) {
        if (getIssuedBookIds().contains(bookId)) {
            System.out.println("Book already issued!");
            return false;
        }

        if (!canIssueMore() || !books.issueBook(bookId)) {
            System.out.println("Book can't be issued!");
            return false;
        }

        getIssuedBookIds().add(bookId);
        System.out.println("Book issued sucessfully!");
        return true;
    }

    public boolean removeIssuedBook(int bookId, Books books) {
        if (!getIssuedBookIds().contains(bookId)) {
            System.out.println(getName() + " didn't issued this book!");
            return false;
        }

        if (!books.returnBook(bookId)) return false;

        getIssuedBookIds().remove(bookId);
        System.out.println("Book removed successfully!");
        return true;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", issuedBookIds=" + issuedBookIds +
                '}';
    }
}