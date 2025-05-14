package ap.exercises.midterm;

import java.util.Random;
import java.util.Scanner;

public class Manager {

    private String firstName;
    private String lastName;
    private String educationLevel;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee's first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter employee's last name:");
        String lastName = scanner.nextLine();

        int employeeID = Employee.generateRandomEmployeeID();
        Employee employee = new Employee(firstName, lastName, employeeID);

        save.saveEmployeeInfo(employee);
        System.out.println("Employee added successfully with ID: " + employeeID);
    }

    public void managerInfo(){

        System.out.println("first name");
        System.err.println("Zahra");

        System.out.println("last name");
        System.err.println("Ahmadi");

        System.out.println("Degree");
        System.err.println("PhD in management.");

    }


}
