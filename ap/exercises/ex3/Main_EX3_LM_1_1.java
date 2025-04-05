package ap.exercises.ex3;

import java.util.Scanner;

class Student {
    String firstName;
    String lastName;
    String major;
    int studentID;

    void displayStudentsinfo() {
        System.out.println("first name: " + firstName);
        System.out.println("last name: " + lastName);
        System.out.println("major: " + major);
        System.out.println("student ID: " + studentID);
    }
}

class Book {
    String title;
    String author;
    int pages;
    int year;

    void displayBooksinfo() {
        System.out.println("title: " + title);
        System.out.println("author: " + author);
        System.out.println("pages: " + pages);
        System.out.println("year: " + year);
    }
}

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("information about the book: (title , author , pages , year)");
        Book book = new Book();
        System.out.println(book.title = "purple pastels");
        System.out.println(book.author = "katherine applegate");
        System.out.println(book.pages = 157);
        System.out.println(book.year = 2000);
        System.out.println("-----------------------------------");

        System.out.println("information about the student: (first name , last name , major , studentID)");
        Student student = new Student();
        System.out.println(student.firstName = "maryam");
        System.out.println(student.lastName = "ahmadi");
        System.out.println(student.major = "computer science");
        System.out.println(student.studentID = 402_567_851);
        System.out.println("-----------------------------------");

        System.out.println("Do you want to change student information? (yes/no)");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            System.out.println("Which student information do you want to change?");
            System.out.println("1- firstname , 2- lastname , 3- student ID , 4- major , 5- all of them");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("new first name:");
                    System.err.println(student.firstName = "zahra");
                    break;

                case 2:
                    System.out.print("new last name:");
                    System.err.println(student.lastName = "moradi");
                    break;

                case 3:
                    System.out.print("new student ID:");
                    System.err.println(student.studentID = 401_567_753);
                    break;

                case 4:
                    System.out.print("new major:");
                    System.err.println(student.major = "computer engineering");
                    break;

                case 5:
                    System.out.println("Change all information.");
                    System.out.print("new first name: ");
                    System.err.println(student.firstName = "zahra");

                    System.out.print("new last name: ");
                    System.err.println(student.lastName = "moradi");

                    System.out.print("new student ID: ");
                    System.err.println(student.studentID = 401_567_753);

                    System.out.print("new major: ");
                    System.err.println(student.major = "computer engineering");
                    break;

            }
            System.out.println("\n--- Updated Student Information ---");
            student.displayStudentsinfo();

            System.out.println("Do you want to change book information? (yes/no)");
            answer = scanner.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                System.out.println("Which book information do you want to change?");
                System.out.println("1- title , 2- author , 3- pages , 4- year , 5- all of them");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("new title:");
                        System.err.println(book.title = "green ray");
                        break;

                    case 2:
                        System.out.print("new author:");
                        System.err.println(book.author = "jules verne");
                        break;

                    case 3:
                        System.out.print("new pages:");
                        System.err.println(book.pages = 200);
                        break;

                    case 4:
                        System.out.print("new year:");
                        System.err.println(book.year = 1990);
                        break;

                    case 5:
                        System.out.println("Change all information.");
                        System.out.print("new title: ");
                        System.err.println(book.title = "green ray");

                        System.out.print("new author: ");
                        System.err.println(book.author = "jules verne");

                        System.out.print("new pages: ");
                        System.err.println(book.pages = 200);

                        System.out.print("new year: ");
                        System.err.println(book.year = 1990);
                        break;

                }
                System.out.println("\n--- Updated Book Information ---");
                book.displayBooksinfo();
                System.out.println("-----------------------------------");
                student.displayStudentsinfo();
                return;
            } else {
                System.out.println("-----------------------------------");
                student.displayStudentsinfo();
                System.out.println("-----------------------------------");
                book.displayBooksinfo();
                return;
            }
        } else {
            System.out.println("Do you want to change book information? (yes/no)");
            answer = scanner.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                System.out.println("Which book information do you want to change?");
                System.out.println("1- title , 2- author , 3- pages , 4- year , 5- all of them");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("new title:");
                        System.err.println(book.title = "green ray");
                        break;

                    case 2:
                        System.out.print("new author:");
                        System.err.println(book.author = "jules verne");
                        break;

                    case 3:
                        System.out.print("new pages:");
                        System.err.println(book.pages = 200);
                        break;

                    case 4:
                        System.out.print("new year:");
                        System.err.println(book.year = 1990);
                        break;

                    case 5:
                        System.out.println("Change all information.");
                        System.out.print("new title: ");
                        System.err.println(book.title = "green ray");

                        System.out.print("new author: ");
                        System.err.println(book.author = "jules verne");

                        System.out.print("new pages: ");
                        System.err.println(book.pages = 200);

                        System.out.print("new year: ");
                        System.err.println(book.year = 1990);
                        break;

                }
                System.out.println("\n--- Updated Book Information ---");
                book.displayBooksinfo();
                System.out.println("-----------------------------------");
                student.displayStudentsinfo();
                running = false;
                return;
            } else {
                System.out.println("-----------------------------------");
                student.displayStudentsinfo();
                System.out.println("-----------------------------------");
                book.displayBooksinfo();
                running = false;
            }
        }
        System.out.println("Do you want to change book information? (yes/no)");
        answer = scanner.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            System.out.println("Which book information do you want to change?");
            System.out.println("1- title , 2- author , 3- pages , 4- year , 5- all of them");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("new title:");
                    System.err.println(book.title = "green ray");
                    break;

                case 2:
                    System.out.print("new author:");
                    System.err.println(book.author = "jules verne");
                    break;

                case 3:
                    System.out.print("new pages:");
                    System.err.println(book.pages = 200);
                    break;

                case 4:
                    System.out.print("new year:");
                    System.err.println(book.year = 1990);
                    break;

                case 5:
                    System.out.println("Change all information.");
                    System.out.print("new title: ");
                    System.err.println(book.title = "green ray");

                    System.out.print("new author: ");
                    System.err.println(book.author = "jules verne");

                    System.out.print("new pages: ");
                    System.err.println(book.pages = 200);

                    System.out.print("new year: ");
                    System.err.println(book.year = 1990);
                    break;

            }
            System.out.println("\n--- Updated Book Information ---");
            book.displayBooksinfo();
        } else {
            System.out.println("-----------------------------------");
            student.displayStudentsinfo();
            System.out.println("-----------------------------------");
            book.displayBooksinfo();
            running = false;
        }
    }
}
