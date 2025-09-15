package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Student;
import librarymanagementsystem.Books;
import librarymanagementsystem.Book;
import librarymanagementsystem.Library;

public class Students {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    public boolean registerStudent(Student s) {
        if (!studentMap.containsKey(s.getId())) {
            studentMap.put(s.getId(), s);
            System.out.println("Student registered successfully!");
            return true;
        }

        System.out.println("Student already registered!");
        return false;
    }

    public Student findById(int id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        }

        System.out.println("Student not registered!");
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(studentMap.values());
    }

    public boolean issueBookToStudent(int studId, int bookId, Books books) {
        Student s = findById(studId);
        Book b = books.findById(bookId);

        if (s == null || b == null) return false;

        return s.addIssuedBook(bookId, books);
    }

    public boolean returnBookFromStudent(int studId, int bookId, Books books) {
        Student s = findById(studId);
        Book b = books.findById(bookId);

        if (s == null || b == null) return false;

        return s.removeIssuedBook(bookId, books);
    }
}