# Library Management System (Java - Console Based)

[![Java](https://img.shields.io/badge/Java-8%2B-blue)](https://www.oracle.com/java/)
[![Build](https://img.shields.io/badge/build-passing-brightgreen)](#)
[![License](https://img.shields.io/badge/license-MIT-lightgrey)](#)

A simple **console-based Library Management System** built in Java.
This project demonstrates the use of:

- **Object-Oriented Programming (OOP)**
- **Collections Framework (`ArrayList`, `Map`)**
- **Exception Handling & Input Validation**
- **Separation of Concerns** with modular classes (`Book`, `Student`, etc.)

---

## 📂 Project Structure

    librarymanagementsystem
    ├── Library.java
    ├── Book.java
    ├── BookRepository.java
    ├── Student.java
    ├── StudentRepository.java
    └── ErrorHandling.java
---

## ⚙️ Requirements
- **Java 8** or above
- Any IDE (**IntelliJ IDEA / Eclipse / VS Code**) or command-line setup

---

## ▶️ How to Run
1. Clone this repository:
   ```
   git clone https://github.com/astha-gupta9/library-management-system.git
   cd "librarymanagementsystem"
   ```
2. Compile the project:
   ```
   javac *.java
   ```
3. Run the application:
    ```
   java Library
    ```
   
---

## ✨ Features Implemented

- Add, view and manage books
- Add, view and manage students
- Issue books to students & return them
- Input validation to prevent crashes during runtime
- Clean modular design for scalability

---

## 🖥️ Sample Console Run

    ******************Welcome to the Library!******************
    Select From The Following Options:
    ***********************************************************
    
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 1
    Enter Book Id: 101
    Enter Book Name: The Alchemist
    Enter Book Author: Paulo Coelho
    Enter Total Number of Books: 4
    Book added successfully!
    ID: 101 | Title: The Alchemist | Author: Paulo Coelho | Availability: Available
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 2
    Enter Id of the Book whose total quantity is to be upgraded: 101
    Enter the Number of Books you want to add: 5
    Quantity upgraded successfully!
    ID: 101 | Title: The Alchemist | Author: Paulo Coelho | Availability: Available
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 3
    Search for the Book here: The Alch
    
    Books by same Name:
    ID: 101 | Title: The Alchemist | Author: Paulo Coelho | Availability: Available
    
    Books by same Author Name:
    None
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 4
    ID: 101 | Title: The Alchemist | Author: Paulo Coelho | Availability: Available
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 5
    Enter Student Id: 115
    Enter Student Name: Astha Gupta
    Student registered successfully!
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 6
    ID: 115 | Name: Astha Gupta | Total Books assigned : 0
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 7
    Enter Student Id: 115
    Enter Book Id: 101
    Book issued successfully!
    Book 'The Alchemist' issued to Astha Gupta.
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 8
    Enter Student Id: 115
    Enter Book Id: 101
    Book returned successfully!
    Book  'The Alchemist' returned by Astha Gupta.
    -----------------------------------------------------------
    Press 0 to Exit Application.
    Press 1 to Add New Book.
    Press 2 to Upgrade Quantity of a Book.
    Press 3 to Search a Book.
    Press 4 to Show All Books.
    Press 5 to Register Student.
    Press 6 to Show All Registered Students.
    Press 7 to Check Out Book.
    Press 8 to Check In Book.
    -----------------------------------------------------------
    Enter your choice: 0
    Exiting Application...

---

## 📝 Notes
- Data is stored in memory (no database used).
- This is an **educational project** to practice Java OOP, not a production system.
- This is the initial version; persistence (file storage) and advanced features may be added later.
- Contributions, ideas and suggestions are welcome!

---

## 📌 License
This project is licensed under **MIT License** and is free to use for **educational purposes**.
