package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Student;
import librarymanagementsystem.Book;
import librarymanagementsystem.BookRepository;
import librarymanagementsystem.Library;

public class StudentRepository {
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
}