package ap.exercises.midterm;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class Manager {

    private String firstName;
    private String lastName;
    private String educationLevel;
    private static int nextEmployeeID = 100000001;

    public Manager(String firstName, String lastName, String educationLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationLevel = educationLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void addEmployee(Save save) {

        int currentEmployees = save.countEmployees();
        if (currentEmployees >= 2) {
            System.out.println("Manager can only register the first 2 employees. Others must register themselves.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee's first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter employee's last name:");
        String lastName = scanner.nextLine();

        int employeeID = nextEmployeeID++;
        Employee employee = new Employee(firstName, lastName, employeeID);

        save.saveEmployeeInfo(employee);
        System.out.println("Employee added successfully with ID: " + employeeID);
    }


//    public void addEmployee(Save save) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter employee's first name:");
//        String firstName = scanner.nextLine();
//
//        System.out.println("Enter employee's last name:");
//        String lastName = scanner.nextLine();
//
//        int employeeID = Employee.generateRandomEmployeeID();
//        Employee employee = new Employee(firstName, lastName, employeeID);
//
//        save.saveEmployeeInfo(employee);
//        System.out.println("Employee added successfully with ID: " + employeeID);
//    }

    public void managerInfo() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Degree: " + educationLevel);
    }

//    public void managerInfo1(){
//
//        System.out.println("first name");
//        System.err.println("Zahra");
//
//        System.out.println("last name");
//        System.err.println("Ahmadi");
//
//        System.out.println("Degree");
//        System.err.println("PhD in management.");
//
//    }

    public void showEmployeeInfo(Save save) {
        try {
            File file = new File(save.EMPLOYEE_FILE);
            if (!file.exists()) {
                System.out.println("No employee registered yet!");
                return;
            }

            System.out.println("\n--- All Employees Information ---");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int employeeCount = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("First name: ")) {
                    String firstName = line.substring("First name: ".length());
                    String lastName = reader.readLine().substring("Last name: ".length());
                    String employeeID = reader.readLine().substring("employee ID: ".length());

                    System.out.println("\nemployee " + (++employeeCount));
                    System.out.println( "first name: " + firstName);
                    System.out.println("last name: " + lastName);
                    System.out.println("ID: " + employeeID);
                }
            }

            if (employeeCount == 0) {
                System.out.println("No employees found!");
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading employee information" + e.getMessage());
        }

//            Scanner scanner = new Scanner(file);
//            System.out.println("\n--- Employee Information ---");
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//            scanner.close();
//        } catch (IOException e) {
//            System.err.println("Error reading employee information: " + e.getMessage());
//        }



    }
}
