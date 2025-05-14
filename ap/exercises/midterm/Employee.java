package ap.exercises.midterm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    public static int generateRandomEmployeeID() {
        Random random = new Random();
        return 100000000 + random.nextInt(900000000);
    }

    public void employeeLogin(int generatedID){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        this.firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        this.lastName = scanner.nextLine();

        this.employeeID = generatedID;
        System.out.println("Your employee ID: " + this.employeeID);
        System.out.println("Welcome! " + this.firstName + " " + this.lastName);

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

}
