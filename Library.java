package librarymanagementsystem;

import java.util.*;
import librarymanagementsystem.Student;
import librarymanagementsystem.StudentRepository;
import librarymanagementsystem.Book;
import librarymanagementsystem.BookRepository;
import librarymanagementsystem.ErrorHandling;

public class Library {
    public String showMenu() {
        return "-----------------------------------------------------------\nPress 0 to Exit Application.\nPress 1 to Add New Book.\nPress 2 to Upgrade Quantity of a Book.\nPress 3 to Search a Book.\nPress 4 to Show All Books.\nPress 5 to Register Student.\nPress 6 to Show All Registered Students.\nPress 7 to Check Out Book.\nPress 8 to Check In Book.\n-----------------------------------------------------------\nEnter your choice:";
    }

    public void addBook(Scanner sc, BookRepository bookRepo, ErrorHandling err) {
        int bookId = err.validateID(-1, "Enter Book Id:", sc);
        String bookName = err.validateStringInput("", "Enter Book Name:", sc);
        String authorName = err.validateStringInput("", "Enter Book Author:", sc);
        int totalBooks = err.validateIntegerInput(-1, "Enter Total Number of Books:", sc);

        Book b = new Book(bookId, bookName, authorName, totalBooks);
        bookRepo.addBook(b);
    }

    public void upgradeQuantity(Scanner sc, BookRepository bookRepo, ErrorHandling err) {
        int bookId = err.validateID(-1, "Enter Id of the Book whose total quantity is to be upgraded:", sc);
        int extra = err.validateIntegerInput(-1, "Enter the Number of Books you want to add:", sc);

        bookRepo.upgradeQuantity(bookId, extra);
    }

    public void searchBook(Scanner sc, BookRepository bookRepo, ErrorHandling err) {
        String query = err.validateStringInput("", "Search for the Book here:", sc);

        List<Book> bookListByName = bookRepo.searchByTitle(query);
        List<Book> bookListByAuthor = bookRepo.searchByAuthor(query);

        System.out.println();

        boolean isBookFound = false;

        System.out.println("Books by same Name:");
        for (Book b : bookListByName) {
            isBookFound = true;
            System.out.println(b.toString());
        }

        if (!isBookFound) System.out.println("None");
        else System.out.println();

        isBookFound = false;

        System.out.println("Books by same Author Name:");
        for (Book b : bookListByAuthor) {
            isBookFound = true;
            System.out.println(b.toString());
        }

        if (!isBookFound) System.out.println("None");
        else System.out.println();
    }

    public void showAllBooks(BookRepository bookRepo) {
        List<Book> allBooks = bookRepo.getAllBooks();

        for (Book b : allBooks) {
            System.out.println(b.toString());
        }
    }

    public void registerStudent(Scanner sc, StudentRepository studRepo, ErrorHandling err) {
        int studId = err.validateID(-1, "Enter Student Id:", sc);
        String studName = err.validateStringInput("", "Enter Student Name:", sc);

        Student s = new Student(studId, studName);
        studRepo.registerStudent(s);
    }

    public void showAllStudents(StudentRepository studRepo) {
        List<Student> allStuds = studRepo.getAllStudents();

        for (Student s : allStuds) {
            System.out.println(s.toString());
        }
    }

    public void checkOutBook(Scanner sc, BookRepository bookRepo, StudentRepository studRepo, ErrorHandling err) {
        int studId = err.validateID(-1, "Enter Student Id:", sc);
        int bookId = err.validateID(-1, "Enter Book Id:", sc);

        Book b = bookRepo.findById(bookId);
        Student s = studRepo.findById(studId);

        if (s == null || b == null || !b.isAvailable() || !s.canIssueMore()) {
            System.out.println("Book can't be issued!");
            return;
        }

        if (s.getIssuedBookIds().contains(bookId)) {
            System.out.println("Book already issued!");
            return;
        }

        bookRepo.issueBook(bookId);
        s.addIssuedBook(bookId, bookRepo);

        System.out.println("Book " + "'" + b.getTitle() + "' issued to " + s.getName() + ".");
    }

    public void checkInBook(Scanner sc, BookRepository bookRepo, StudentRepository studRepo, ErrorHandling err) {
        int studId = err.validateID(-1, "Enter Student Id:", sc);
        int bookId = err.validateID(-1, "Enter Book Id:", sc);

        Book b = bookRepo.findById(bookId);
        Student s = studRepo.findById(studId);

        if (s == null || b == null) {
            System.out.println("Book can't be returned.");
            return;
        }

        if (!s.getIssuedBookIds().contains(bookId)) {
            System.out.println(s.getName() + " didn't issue this book!");
            return;
        }

        bookRepo.returnBook(bookId);
        s.removeIssuedBook(bookId, bookRepo);

        System.out.println("Book " + "'" + b.getTitle() + "' returned by " + s.getName() + ".");
    }

    public static void main (String[] args) {
        BookRepository bookRepo = new BookRepository();
        StudentRepository studRepo = new StudentRepository();
        Library library = new Library();
        ErrorHandling err = new ErrorHandling();

        Scanner sc = new Scanner(System.in);

        System.out.println("******************Welcome to the Library!******************");
        System.out.println("             Select From The Following Options:            ");
        System.out.println("***********************************************************");
        System.out.println();

        while (true) {
            int option = err.validateMenuChoice(-1, library.showMenu(), sc);

            switch (option) {
                case 0:
                    System.out.println("Exiting Application...");
                    System.exit(0);
                case 1:
                    library.addBook(sc, bookRepo, err);
                    break;
                case 2:
                    library.upgradeQuantity(sc, bookRepo, err);
                    break;
                case 3:
                    library.searchBook(sc, bookRepo, err);
                    break;
                case 4:
                    library.showAllBooks(bookRepo);
                    break;
                case 5:
                    library.registerStudent(sc, studRepo, err);
                    break;
                case 6:
                    library.showAllStudents(studRepo);
                    break;
                case 7:
                    library.checkOutBook(sc, bookRepo, studRepo, err);
                    break;
                case 8:
                    library.checkInBook(sc, bookRepo, studRepo, err);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
