package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Student;
import librarymanagementsystem.Students;
import librarymanagementsystem.Book;
import librarymanagementsystem.Books;
import librarymanagementsystem.ErrorHandling;

public class Library {
    public String showMenu() {
        return "-----------------------------------------------------------\nPress 0 to Exit Application.\nPress 1 to Add New Book.\nPress 2 to Upgrade Quantity of a Book.\nPress 3 to Search a Book.\nPress 4 to Show All Books.\nPress 5 to Register Student.\nPress 6 to Show All Registered Students.\nPress 7 to Check Out Book.\nPress 8 to Check In Book.\n-----------------------------------------------------------";
    }

    public void addBook(Scanner sc, Books books, ErrorHandling err) {
        int bookId = err.validateIntegerInput(-1, "Enter Book Id:", sc);
        String bookName = err.validateStringInput("", "Enter Book Name:", sc);
        String authorName = err.validateStringInput("", "Enter Book Author:", sc);
        int totalBooks = err.validateIntegerInput(-1, "Enter Total Number of Books:", sc);

        Book b = new Book(bookId, bookName, authorName, totalBooks);
        books.addBook(b);
    }

    public void upgradeQuantity(Scanner sc, Books books, ErrorHandling err) {
        int bookId = err.validateIntegerInput(-1, "Enter Id of the Book whose total quantity is to be upgraded: ", sc);
        int extra = err.validateIntegerInput(-1, "Enter the Number of Books you want to add: ", sc);

        books.upgradeQuantity(bookId, extra);
    }

    public void searchBook(Scanner sc, Books books, ErrorHandling err) {
        String query = err.validateStringInput("", "Search for the Book here: ", sc);

        List<Book> bookListByName = books.searchByTitle(query);
        List<Book> bookListByAuthor = books.searchByAuthor(query);

        System.out.println("Books by same Name: ");
        System.out.println(bookListByName);

        System.out.println("Books by same Author Name: ");
        System.out.println(bookListByAuthor);
    }

    public void showAllBooks(Books books) {
        List<Book> allBooks = books.getAllBooks();

        for (Book b : allBooks) {
            System.out.println(b);
        }
    }

    public void registerStudent(Scanner sc, Students students, ErrorHandling err) {
        int studId = err.validateIntegerInput(-1, "Enter Student Id: ", sc);
        String studName = err.validateStringInput("", "Enter Student Name: ", sc);

        Student s = new Student(studId, studName);
        students.registerStudent(s);
    }

    public void showAllStudents(Students students) {
        List<Student> allStuds = students.getAllStudents();

        for (Student s : allStuds) {
            System.out.println(s);
        }
    }

    public void checkOutBook(Scanner sc, Books books, Students students, ErrorHandling err) {
        int bookId = err.validateIntegerInput(-1, "Enter Book Id: ", sc);
        int studId = err.validateIntegerInput(-1, "Enter Student Id: ", sc);

        students.issueBookToStudent(studId, bookId, books);
    }

    public void checkInBook(Scanner sc, Books books, Students students, ErrorHandling err) {
        int bookId = err.validateIntegerInput(-1, "Enter Book Id: ", sc);
        int studId = err.validateIntegerInput(-1, "Enter Student Id: ", sc);

        students.returnBookFromStudent(studId, bookId, books);
    }

    public static void main (String[] args) {
        Books books = new Books();
        Students students = new Students();
        Library library = new Library();
        ErrorHandling err = new ErrorHandling();

        Scanner sc = new Scanner(System.in);

        System.out.println("******************Welcome to the Librray!******************");
        System.out.println("             Select From The Following Options:            ");
        System.out.println("***********************************************************");
        System.out.println();

        while (true) {
            int option = err.validateIntegerInput(-1, library.showMenu(), sc);

            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    library.addBook(sc, books, err);
                    break;
                case 2:
                    library.upgradeQuantity(sc, books, err);
                    break;
                case 3:
                    library.searchBook(sc, books, err);
                    break;
                case 4:
                    library.showAllBooks(books);
                    break;
                case 5:
                    library.registerStudent(sc, students, err);
                    break;
                case 6:
                    library.showAllStudents(students);
                    break;
                case 7:
                    library.checkOutBook(sc, books, students, err);
                    break;
                case 8:
                    library.checkInBook(sc, books, students, err);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
