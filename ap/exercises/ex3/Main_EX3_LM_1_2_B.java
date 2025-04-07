package ap.exercises.ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


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

    public String toFileString() {
        return title + "," + author + "," + pages + "," + year;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
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

    public String toFileString() {
        return firstName + "," + lastName + "," + studentNumber + "," + major;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[0], parts[1], parts[2], parts[3]);
    }
}


public class Main_EX3_LM_1_2_B {

    private static final String BOOKS_FILE = "books.txt";
    private static final String STUDENTS_FILE = "students.txt";

    public static void main(String[] args) {

        createInitialData();


        List<Book> books = readBooksFromFile();
        System.out.println("All Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }


        List<Student> students = readStudentsFromFile();
        System.out.println("All Students:");
        for (Student student : students) {
            student.displayStudentInfo();
        }

        System.out.println("Changing information for first book and first student...\n");

        if (!books.isEmpty()) {
            books.get(0).setTitle("New Purple Pastels");
            books.get(0).setPages(175);
        }

        if (!students.isEmpty()) {
            students.get(0).setFirstName("zohre");
            students.get(0).setMajor("Software Engineering");
        }

        saveBooksToFile(books);
        saveStudentsToFile(students);

        if (!books.isEmpty()) {
            System.out.println("Updated Book Information:");
            books.get(0).displayBookInfo();
        }

        if (!students.isEmpty()) {
            System.out.println("Updated Student Information:");
            students.get(0).displayStudentInfo();
        }
    }

    private static void createInitialData() {

        if (!new File(BOOKS_FILE).exists()) {
            List<Book> initialBooks = new ArrayList<>();
            initialBooks.add(new Book("Purple Pastels", "Katherine Applegate", 157, 2000));
            initialBooks.add(new Book("Green Ray", "Jules Verne", 200, 1990));
            initialBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, 1925));
            initialBooks.add(new Book("1984", "George Orwell", 328, 1949));
            saveBooksToFile(initialBooks);
        }
        if (!new File(STUDENTS_FILE).exists()) {
            List<Student> initialStudents = new ArrayList<>();
            initialStudents.add(new Student("Maryam", "Ahmadi", "402567851", "Computer Science"));
            initialStudents.add(new Student("fateme", "Mohammadi", "401234567", "Electrical Engineering"));
            initialStudents.add(new Student("Zahra", "Moradi", "403891234", "Mechanical Engineering"));
            saveStudentsToFile(initialStudents);
        }
    }

    private static List<Book> readBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }
        return books;
    }

    private static List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }
        return students;
    }

    private static void saveBooksToFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    private static void saveStudentsToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENTS_FILE))) {
            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }
}



