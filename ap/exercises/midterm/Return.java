package ap.exercises.midterm;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.IOException;

public class Return {

    Save save = new Save();


    Scanner scanner = new Scanner(System.in);

    public void returnBook(Save save, Library library) {
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        if (!save.doesUserExist(firstName, lastName)) {
            System.out.println("Your information is not registered. You must register first.");
            return;
        }

        System.out.println("Enter the name of the book you want to return:");
        String bookName = scanner.nextLine();

        if (!save.hasBorrowedBook(save, firstName, lastName, bookName)) {
            System.out.println("You haven't borrowed this book.");
            return;
        }

        Book foundBook = null;
        for (Book book : library.getAllBooks()) {
            if (book.getSubject().equalsIgnoreCase(bookName)) {
                foundBook = book;
                break;
            }
        }

        if (foundBook == null) {
            System.out.println("This book doesn't exist in our library records.");
            return;
        }

        foundBook.setNumberOfBooks(foundBook.getNumberOfBooks() + 1);
        library.saveBooks();


        save.removeBorrowRecord(save, firstName, lastName, bookName);

        System.out.println("Book returned successfully!");
        System.out.println("Book: " + foundBook.getSubject());
        System.out.println("Current available copies: " + foundBook.getNumberOfBooks());
    }
}