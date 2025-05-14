package ap.exercises.midterm;

import java.time.LocalDate;

public class Student {

    private String firstName;
    private String lastName;
    private int studentID;
    private String major;
    private LocalDate dateOfMembership;

    public Student(String firstName, String lastName, int studentID, String major, LocalDate dateOfMembership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.major = major;
        this.dateOfMembership = dateOfMembership;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDateOfMembership(LocalDate dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }
}
