package ap.exercises.midterm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.time.LocalDate;

public class Save {

    Scanner scanner = new Scanner(System.in);

    private final String USER_FILE = "user_info.txt";
    public final String EMPLOYEE_FILE = "employee_info.txt";
    private final String BOOKS_FILE = "books.txt";
    private final String BORROW_FILE = "borrows.txt";

    public boolean doesUserFileExist() {
        return new File(USER_FILE).exists();
    }

    public boolean doesEmployeeExists() {
        File file = new File(EMPLOYEE_FILE);
        return file.exists() && file.length() > 0;
    }

    public int countEmployees() {
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) {
                return 0;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count = 0;
            while (reader.readLine() != null) {
                String line1 = reader.readLine();
                String line2 = reader.readLine();
                String line3 = reader.readLine();
                if(line1 != null && line2 != null && line3 != null) {
                    count++;
                }
            }
            reader.close();
            return count;
        } catch (IOException e) {
            return 0;
        }
    }

    public int getLastEmployeeID() {
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) {
                return 100000000;
            }

            int lastID = 100000000;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("employee ID: ")) {
                    int currentID = Integer.parseInt(line.split(": ")[1]);
                    if (currentID > lastID) {
                        lastID = currentID;
                    }
                }
            }
            reader.close();
            return lastID;
        } catch (IOException e) {
            System.err.println("Error reading last employee ID: " + e.getMessage());
            return 100000000;
        }
    }

    public Employee loadEmployeeByID(String firstName, String lastName) {
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) {
                return null;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("First name: " + firstName)) {
                    String lastLine = reader.readLine();
                    String idLine = reader.readLine();
                    if(lastLine != null && idLine != null &&
                            lastLine.startsWith("Last name: " + lastName)) {
                        try {
                            int id = Integer.parseInt(idLine.substring("employee ID: ".length()));
                            reader.close();
                            return new Employee(firstName, lastName, id);
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing employee ID: " + idLine);
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error loading employee: " + e.getMessage());
        }
        return null;

    }




    public void saveStudentInfo(Student student) {
        try (FileWriter fw = new FileWriter(USER_FILE , true)) {
            fw.write("First Name: " + student.getFirstName() + "\n");
            fw.write("Last Name: " + student.getLastName() + "\n");
            fw.write("Student ID: " + student.getStudentID() + "\n");
            fw.write("Major: " + student.getMajor() + "\n");
            fw.write("Membership Date: " + student.getDateOfMembership() + "\n");
        } catch (IOException e) {
            System.err.println("Error saving student information: " + e.getMessage());
        }
    }

    public void saveEmployeeInfo(Employee employee) {
        try (FileWriter fw = new FileWriter(EMPLOYEE_FILE, true)) {
            fw.write("First name: " + employee.getFirstName() + "\n");
            fw.write("Last name: " + employee.getLastName() + "\n");
            fw.write("employee ID: " + employee.getEmployeeID() + "\n");
            fw.write("--------------------\n");
            System.out.println("Employee info saved successfully. ID: " + employee.getEmployeeID());
        } catch (IOException e) {
            System.err.println("Error saving employee information" + e.getMessage());
        }
    }

    public Employee loadEmployee(String firstName, String lastName) {
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) return null;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("First name: " + firstName)) {
                    String lastLine = reader.readLine();
                    String idLine = reader.readLine();
                    if(lastLine != null && idLine != null &&
                            lastLine.equals("Last name: " + lastName)) {
                        int id = Integer.parseInt(idLine.replace("employee ID: ", ""));
                        reader.close();
                        System.out.println("Loaded employee ID: " + id);
                        return new Employee(firstName, lastName, id);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error loading employee: " + e.getMessage());
        }
        return null;
    }

    public void saveBooks(ArrayList<Book> books) {

        try (FileWriter fw = new FileWriter(BOOKS_FILE)) {

            for (Book book : books) {
                fw.write(book.getSubject() + "," + book.getAuthor() + "," + book.getPublishYear() + ","
                        + book.getPages() + "," + book.getNumberOfBooks() + "\n");
            }

        } catch (Exception e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    public ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();
        File file = new File(BOOKS_FILE);

        if (!file.exists()) {
            return books;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    books.add(new Book(
                            parts[0].trim(),
                            parts[1].trim(),
                            Integer.parseInt(parts[2].trim()),
                            Integer.parseInt(parts[3].trim()),
                            Integer.parseInt(parts[4].trim())
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
        return books;
    }

    public boolean doesUserExist(String firstName, String lastName) {
        try {
            File file = new File(USER_FILE);
            if (!file.exists()) return false;

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("First Name: " + firstName) ||
                        line.contains("Last Name: " + lastName)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading user file!");
        }
        return false;
    }

    public void saveBorrow(String firstName, String lastName, String bookTitle , LocalDate checkoutDate, LocalDate returnDate) {
        try {
            FileWriter fw = new FileWriter(BORROW_FILE, true);
            String record = firstName + " " + lastName + " | " + bookTitle.toLowerCase() + " | " + new Date() + "\n";
            fw.write(record);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving trust information!");
        }
    }

    public void saveUser(String firstName, String lastName, String studentId) {
        try {
            FileWriter fw = new FileWriter(USER_FILE, true);
            String record = firstName + " " + lastName + " | " + studentId + "\n";
            fw.write(record);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving new user!");
        }
    }

    //showing user information

    public void displayUserInfo(String firstName, String lastName) {
        try {
            File file = new File(USER_FILE);
            if (!file.exists()) {
                System.out.println("User information not found!");
                return;
            }

            Scanner scanner = new Scanner(file);
            System.out.println("\n--- Your Information ---");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error reading user information: " + e.getMessage());
        }
    }

    //showing borrow information
    public void displayUserBorrows(String firstName, String lastName) {
        try {
            File file = new File(BORROW_FILE);
            if (!file.exists()) {
                System.out.println("No borrow history found!");
                return;
            }

            Scanner scanner = new Scanner(file);
            System.out.println("\n---Borrow History ---");
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(firstName + " " + lastName)) {
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No borrow records found for you.");
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error reading borrow information: " + e.getMessage());
        }

    }

    //showing information for user if he/she forgot
    public void displayAllRegisteredUsers() {
        try {
            File file = new File(USER_FILE);
            if (!file.exists()) {
                System.out.println("No users registered yet!");
                return;
            }

            System.out.println("\n--- Registered Users ---");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("First Name:") || line.startsWith("Last Name:")) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error reading user data: " + e.getMessage());
        }
    }

    public boolean hasBorrowedBook(Save save, String firstName, String lastName, String bookName) {
        try {
            File file = new File(save.BORROW_FILE);
            if (!file.exists()) return false;

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                if (line.startsWith((firstName + " " + lastName).toLowerCase()) && line.contains(bookName)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error reading borrow records: " + e.getMessage());
        }
        return false;
    }

    public void removeBorrowRecord(Save save, String firstName, String lastName, String bookName) {
        try {
            File file = new File(save.BORROW_FILE);
            if (!file.exists()) return;

            ArrayList<String> records = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!(line.startsWith(firstName + " " + lastName) && line.contains(bookName))) {
                    records.add(line);
                }
            }
            scanner.close();

            FileWriter fw = new FileWriter(save.BORROW_FILE);
            for (String record : records) {
                fw.write(record + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.err.println("Error updating borrow records: " + e.getMessage());
        }
    }
}

