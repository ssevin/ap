package ap.exercises.midterm;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Borrow {

    Scanner scanner = new Scanner(System.in);
    LocalDate localDate = LocalDate.now();

    public void borrowBook(Save save, Library library){

        Student student = new Student();

        System.out.println("Enter your first name:");
        String firstName= scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        if (!save.doesUserExist(firstName , lastName)){
            System.out.println("Your information is not registered" + "You must register first");
            return;
        }

            System.out.println("Enter the name of the book:");
            String bookName = scanner.nextLine();

            Book foundBook = null;

        for (Book book : library.getAllBooks()) {
            if (book.getSubject().equalsIgnoreCase(bookName)) {
                foundBook = book;
                break;
            }
        }

        if (foundBook == null) {
            System.out.println("Book not found in the library.");
            return;
        }

        if (foundBook.getNumberOfBooks() <= 0) {
            System.out.println("Sorry, this book is currently not available.");
            return;
        }

        foundBook.setNumberOfBooks(foundBook.getNumberOfBooks() - 1);
        library.saveBooks();

        LocalDate checkoutDate = LocalDate.now();
        LocalDate returnDate = checkoutDate.plusDays(14);

        System.out.println("Borrowing Successful");
        System.out.println("Book: " + foundBook.getSubject());
        System.out.println("Borrower: " + firstName + " " + lastName);
        System.out.println("Checkout Date: " + checkoutDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Please return the book by the due date.");

        save.saveBorrow(firstName, lastName, foundBook.getSubject() , checkoutDate, returnDate);

    }

    public void viewBorrowedBooks(Save save) {
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        if (!save.doesUserExist(firstName, lastName)) {
            System.out.println("Your information is not registered. You must register first.");
            return;
        }

        save.displayUserBorrows(firstName, lastName);
    }
}
