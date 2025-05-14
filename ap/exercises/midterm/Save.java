package ap.exercises.midterm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Save {

    Scanner scanner = new Scanner(System.in);


    private final String USER_FILE = "user_info.txt";
    private final String EMPLOYEE_FILE = "employee_info.txt";
    private final String BOOKS_FILE = "books.txt";

    public boolean doesUserFileExist() {
        return new File(USER_FILE).exists();
    }

    public boolean doesEmployeeExists() {
        return new File(EMPLOYEE_FILE).exists();
    }

    public void saveStudentInfo(Student student) {
        try (FileWriter fw = new FileWriter(USER_FILE)) {
            fw.write("First Name: " + student.getFirstName() + "\n");
            fw.write("Last Name: " + student.getLastName() + "\n");
            fw.write("Student ID: " + student.getStudentID() + "\n");
            fw.write("Major: " + student.getMajor() + "\n");
            fw.write("Membership Date: " + student.getDateOfMembership() + "\n");
        } catch (IOException e) {
            System.err.println("Error saving student information: " + e.getMessage());
        }
    }

    public void saveEmployeeInfo(Employee employee){

        try(FileWriter fw = new FileWriter(EMPLOYEE_FILE)){

            fw.write("First name: " + employee.getFirstName() + "\n");
            fw.write("Last name: " + employee.getLastName() + "\n");
            fw.write("employee ID: " + employee.getEmployeeID() + "\n");

        } catch (Exception e) {
            System.err.println("Error saving employee information: " + e.getMessage());
        }
    }






}

