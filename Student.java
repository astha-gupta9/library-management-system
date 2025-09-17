package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Book;
import librarymanagementsystem.BookRepository;
import librarymanagementsystem.StudentRepository;
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

    public boolean addIssuedBook(int bookId, BookRepository bookRepo) {
        return getIssuedBookIds().add(bookId);
    }

    public boolean removeIssuedBook(int bookId, BookRepository bookRepo) {
        return getIssuedBookIds().remove(bookId);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ID: " + getId() + " | Name: " + getName() + " | Total Books assigned : " + getIssuedBookIds().size();
    }
}