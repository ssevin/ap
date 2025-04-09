package ap.exercises.ex3;

import javax.xml.namespace.QName;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int pages;
    private int year;


    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayBookInfo() {
        System.out.println("Book Information:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Year: " + year);
        System.out.println("---------------------");
    }

}

class Student {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String major;

    public Student(String firstName, String lastName, String studentNumber, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.major = major;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void displayStudentInfo() {
        System.out.println("Student Information:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Major: " + major);
        System.out.println("---------------------");
    }

}

public class Main_EX3_LM_1_3 {
    public static void main(String[] args) {

        Book[] books = new Book[4];
        books[0] = new Book("Purple Pastels", "Katherine Applegate", 157, 2000);
        books[1] = new Book("Green Ray", "Jules Verne", 200, 1990);
        books[2] = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, 1925);
        books[3] = new Book("1984", "George Orwell", 328, 1949);

        Student[] students = new Student[3];
        students[0] = new Student("Maryam", "Ahmadi", "402567851", "Computer Science");
        students[1] = new Student("fateme", "Mohammadi", "401234567", "Electrical Engineering");
        students[2] = new Student("Zahra", "Moradi", "403891234", "Mechanical Engineering");

        System.out.println("All Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        System.out.println("All Students:");
        for (Student student : students) {
            student.displayStudentInfo();
        }

        System.out.println("Changing information for first book and first student...\n");


        books[0].setTitle("New Purple Pastels");
        books[0].setPages(175);


        students[0].setFirstName("zohre");
        students[0].setMajor("Software Engineering");


        System.out.println("Updated Book Information:");
        books[0].displayBookInfo();

        System.out.println("Updated Student Information:");
        students[0].displayStudentInfo();

        new Main_EX3_LM_1_3().searchStudents(students);

    }

    //new section(searching)
    public void searchStudents(Student[] students) {

        System.out.println("searching student name:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter:");
        char letter = scanner.nextLine().toLowerCase().charAt(0);

        boolean found = false;

        System.out.println("\nsearch results:");
        for (Student student : students) {
            String firstName = student.getFirstName().toLowerCase();
            String lastName = student.getLastName().toLowerCase();

            if (firstName.indexOf(letter) != -1 || lastName.indexOf(letter) != -1) {
                student.displayStudentInfo();
                found = true;
            }
        }
        if (found) {
            System.out.println("\nSearch was successful!");
        } else {
            System.out.println("No results found!");
        }
    }
}

