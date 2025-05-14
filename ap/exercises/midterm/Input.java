package ap.exercises.midterm;

import java.util.Scanner;
import java.time.LocalDate;

public class Input {


    public Student registerStudent() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter your ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your major:");
        String major = scanner.nextLine();

        LocalDate currentDate = LocalDate.now();

        Student student = new Student(firstName, lastName, studentID, major, currentDate);

        System.out.println("Your membership date: " + student.getDateOfMembership());
        return student;
    }

}
