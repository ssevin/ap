package ap.exercises.ex3;

import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

class Student {
    String firstName;
    String lastName;
    String major;
    int studentID;

    void displayStudentsinfo(){
        System.out.println("first name: " + firstName);
        System.out.println("last name: " + lastName);
        System.out.println("major: " + major);
        System.out.println("student ID: " + studentID);
    }
}

class Book{
    String title;
    String author;
    int pages;
    int year;

    void displayBooksinfo(){
        System.out.println("title: " + title);
        System.out.println("author: " + author);
        System.out.println("pages: " + pages);
        System.out.println("year: " + year);
    }
}

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter information about the book.(title , author , pages , year)");
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int pages = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter information about the student. (first name , last name , major , studentID)");
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String major = scanner.nextLine();
        int studentID = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student();
        student.firstName = firstName;
        student.lastName = lastName;
        student.major = major;
        student.studentID = studentID;

        Book book = new Book();
        book.title = title;
        book.author = author;
        book.pages = pages;
        book.year = year;

        System.out.println("\n--- Student Information ---");
        student.displayStudentsinfo();
        System.out.println("\n--- Book Information ---");
        book.displayBooksinfo();

        System.out.println("Do you want to change student information? (yes/no)");
        String answer = scanner.nextLine().toLowerCase();
        if(answer.equals("yes")){
            System.out.println("Which student information do you want to change?");
            System.out.println("1- firstname , 2- lastname , 3- student ID , 4- major , 5- all of them");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1:
                    System.out.print("new first name:");
                    student.firstName = scanner.nextLine();
                    break;

                case 2:
                    System.out.println("new last name:");
                    student.lastName = scanner.nextLine();
                    break;

                case 3:
                    System.out.println("new student ID:");
                    student.studentID = scanner.nextInt();
                    break;

                case 4:
                    System.out.println("new major:");
                    student.major = scanner.nextLine();
                    break;

                case 5:
                    System.out.println("Change all information.");
                    System.out.print("new first name: ");
                    student.firstName = scanner.nextLine();
                    System.out.print("new last name: ");
                    student.lastName = scanner.nextLine();
                    System.out.print("new student ID: ");
                    student.studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("new major: ");
                    student.major = scanner.nextLine();
                    scanner.nextLine();
                    break;

            }
            System.out.println("\n--- Updated Student Information ---");
            student.displayStudentsinfo();

            System.out.println("Do you want to change book information? (yes/no)");
            answer = scanner.nextLine().toLowerCase();
            if(answer.equals("yes")){
                System.out.println("Which book information do you want to change?");
                System.out.println("1- title , 2- author , 3- pages , 4- year , 5- all of them");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){

                    case 1:
                        System.out.print("new title:");
                        book.title = scanner.nextLine();
                        break;

                    case 2:
                        System.out.println("new author:");
                        book.author = scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("new pages:");
                        book.pages = scanner.nextInt();
                        break;

                    case 4:
                        System.out.println("new year:");
                        book.year = scanner.nextInt();
                        break;

                    case 5:
                        System.out.println("Change all information.");
                        System.out.print("new title: ");
                        book.title = scanner.nextLine();
                        System.out.print("new author: ");
                        book.author = scanner.nextLine();
                        System.out.print("new pages: ");
                        book.pages = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("new year: ");
                        book.year = scanner.nextInt();
                        scanner.nextLine();
                        break;

                }
                System.out.println("\n--- Updated Student Information ---");
                student.displayStudentsinfo();
            }
        }
    }
}
