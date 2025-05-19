package ap.exercises.midterm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Employee {

    private String firstName;
    private String lastName;
    private int employeeID;

    public Employee(){

    }

    public Employee(String firstName, String lastName, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void employeeLogin(Save save) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        this.firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        this.lastName = scanner.nextLine();

        Employee existing = save.loadEmployee(this.firstName, this.lastName);
        if(existing != null) {
            this.employeeID = existing.getEmployeeID();
            System.out.println("Welcome back! Your employee ID: " + this.employeeID);
            return;
        }

        if(save.countEmployees() < 2) {
            this.employeeID = save.getLastEmployeeID() + 1;
            save.saveEmployeeInfo(this);
            System.out.println("Registration successful! Your employee ID: " + this.employeeID);
        } else {
            System.out.println("Please ask manager to register you.");
        }

    }

public void editEmployeeInfo() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your first name:");
    this.firstName = scanner.nextLine();

    System.out.println("Enter your last name:");
    this.lastName = scanner.nextLine();
}

public void addBooks(Library library) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("How many books do you want to add?");
    int numberOfBooks = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < numberOfBooks; i++) {
        System.out.println("\nEnter details for book " + (i + 1) + ":");

        System.out.println("Enter the title of the book:");
        String subject = scanner.nextLine();

        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();

        System.out.println("Enter the year of publication of the book:");
        int publishYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the number of pages of the book:");
        int pages = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the number of copies of this book available:");
        int numberOfCopies = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(subject, author, publishYear, pages, numberOfCopies);
        library.addBook(newBook);

    }

    System.out.println("Books added successfully!");
}

    public void showEmployeeInfo(Save save) {

        if (this.firstName == null || this.lastName == null || this.employeeID == 0) {
            Employee loaded = save.loadEmployee(this.firstName, this.lastName);
            if (loaded != null) {
                this.firstName = loaded.getFirstName();
                this.lastName = loaded.getLastName();
                this.employeeID = loaded.getEmployeeID();
            } else {
                System.out.println("You are not registered yet!");
                return;
            }
        }

        System.out.println("\n--- Your Information ---");
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("Employee ID: " + this.employeeID);
    }

public void borrowConfirm(Save save , Library library , Borrow borrow , Manager manager){

        Scanner scanner = new Scanner(System.in);

    System.out.println("Enter student first name:");
    String stuFirstName = scanner.nextLine();

    System.out.println("Enter student last name:");
    String stuLastName = scanner.nextLine();

        save.displayUserBorrows(stuFirstName,stuLastName);

//Confirmation of the employee's identity
    System.out.println("Employee verification:");

    System.out.println("Enter your employee ID:");
    int inputID = scanner.nextInt();
    scanner.nextLine();

    if(inputID == this.employeeID) {
        System.out.println("Verification successful!");
        System.out.println("The book loan has been approved");
    } else {
        System.out.println("Verification failed! Wrong employee ID.");
    }
}

    public void returnConfirm(Save save, Library library, Manager manager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student first name:");
        String stuFirstName = scanner.nextLine();

        System.out.println("Enter student last name:");
        String stuLastName = scanner.nextLine();

        System.out.println("\n--- Borrowed Books ---");
        save.displayUserBorrows(stuFirstName, stuLastName);

        System.out.println("\nEnter the title of book to return:");
        String bookTitle = scanner.nextLine();

        if(!save.hasBorrowedBook(save, stuFirstName, stuLastName, bookTitle)) {
            System.out.println("This student hasn't borrowed this book!");
            return;
        }


        save.removeBorrowRecord(save, stuFirstName, stuLastName, bookTitle);


        for(Book book : library.getAllBooks()) {
            if(book.getSubject().equalsIgnoreCase(bookTitle)) {
                book.setNumberOfBooks(book.getNumberOfBooks() + 1);
                System.out.println("Book quantity updated in library.");
                break;
            }
        }

        System.out.println("Book return confirmed.");
        System.out.println("Book '" + bookTitle + "' has been successfully returned.");
    }
































}

