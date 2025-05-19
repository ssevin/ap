package ap.exercises.midterm;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();
        Save save = new Save();
        Borrow borrow = new Borrow();
        Input input = new Input();
        Manager manager = null;
        Employee employee = new Employee();

        Employee currentEmployee = null;


        int role;
        System.out.println("welcome to " + library.name);
        System.out.println("Please select your user role:");

        System.out.println("1- student");
        System.out.println("2- manager");
        System.out.println("3- employee");

        role = scanner.nextInt();
        scanner.nextLine();

        switch (role){

            case 1:
                System.out.println("choose one of them:");
                System.out.println("1-Registration");
                System.out.println("2-Borrowing book");
                System.out.println("3-Returning book");
                System.out.println("4-Book search");
                System.out.println("5-View my information");
                System.out.println("6-View my borrowed books");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){

                    case 1:
                        if (save.doesUserFileExist()) {
                            System.out.println("You can't register again. You've already registered before!");
                        } else {
                            Student student = input.registerStudent();
                            save.saveStudentInfo(student);
                            System.out.println("Registration successful!");
                        }
                        break;

                    case 2:
                        borrow.borrowBook(save, library);

                        break;

                    case 3:
                        Return returnBook = new Return();
                        returnBook.returnBook(save, library);

                        break;

                    case 4:
                        ArrayList<Book> books = new ArrayList<>();
                        System.out.println("Enter the author's name or book title:");
                        String choose = scanner.nextLine().toLowerCase();

                        boolean found = false;
                        for(Book book : library.getAllBooks()) {
                            if (book.getSubject().toLowerCase().contains(choose) || book.getAuthor().toLowerCase().contains(choose)) {
                                System.out.println("Book Found!");
                                System.out.println("Subject: " + book.getSubject());
                                System.out.println("Author: " + book.getAuthor());
                                System.out.println("Year: " + book.getPublishYear());
                                System.out.println("Pages: " + book.getPages());
                                System.out.println("Number of books: " + book.getNumberOfBooks());
                                found = true;
                                break;
                            }
                        }
                            if(!found){
                                System.out.println("No books found matching: " + choose);
                            }
                        break;

                    case 5:
                        System.out.println("Enter your first name:");
                        String viewFirstName = scanner.nextLine();
                        System.out.println("Enter your last name:");
                        String viewLastName = scanner.nextLine();

                        if (save.doesUserExist(viewFirstName, viewLastName)) {
                            save.displayUserInfo(viewFirstName, viewLastName);
                            save.displayUserBorrows(viewFirstName, viewLastName);
                        } else {
                            System.out.println("User not found. Please register first.");
                        }
                        break;

                    case 6:
                        borrow.viewBorrowedBooks(save);
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
                break;

            case 2:

                System.out.println("choose one of them:");
                System.out.println("1- View manager information");
                System.out.println("2- Add new employee");
                System.out.println("3- View all registered users");
                System.out.println("4-Show employee information");
                int choose3 = scanner.nextInt();
                scanner.nextLine();

                switch (choose3) {
                    case 1:
                        manager = new Manager("Zahra", "Ahmadi", "PhD in management");
                        manager.managerInfo();
                        break;

                    case 2:
                        if (manager == null) {
                            manager = new Manager("Zahra", "Ahmadi", "PhD in management");
                        }
                        manager.addEmployee(save);
                        break;

                    case 3:
                        save.displayAllRegisteredUsers();
                        break;

                    case 4:
                        if (manager == null) {
                            manager = new Manager("Zahra", "Ahmadi", "PhD in management");
                        }
                        if (!new File(save.EMPLOYEE_FILE).exists()) {
                            System.out.println("No employees registered yet!");
                        } else {
                            manager.showEmployeeInfo(save);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
                break;

            case 3:
                System.out.println("choose one of them:");
                System.out.println("1-Registration");
                System.out.println("2-Add book information");
                System.out.println("3-Final confirmation of student loan request");
                System.out.println("4-Final confirmation of book delivery from student");
                System.out.println("5-Show my information");
                int choose2 = scanner.nextInt();
                scanner.nextLine();

                switch (choose2){

                    case 1:

                        currentEmployee = new Employee();
                        currentEmployee.employeeLogin(save);
                        save.saveEmployeeInfo(currentEmployee);

                        if(save.doesEmployeeExists()){
                            System.out.println("You have already registered!");

                            System.out.println("Enter your first name:");
                            String empFirstName = scanner.nextLine();
                            System.out.println("Enter your last name:");
                            String empLastName = scanner.nextLine();

                            employee = save.loadEmployee(empFirstName, empLastName);
                            if(employee == null) {
                                System.out.println("Employee not found!");
                                break;
                            }
                        }
                        else {
                            employee = new Employee();
                            employee.employeeLogin(save);
                            save.saveEmployeeInfo(employee);
                        }

                        System.out.println("Do you want to edit your information?(Y/N)");
                        String choose1 = scanner.nextLine().toLowerCase();

                        if(choose1.equals("y")) {
                            employee.editEmployeeInfo();

                            new File(save.EMPLOYEE_FILE).delete();

                            save.saveEmployeeInfo(employee);
                            System.out.println("Your information has been edited");
                            System.out.println("your ID: " + employee.getEmployeeID());
                        }

                        break;

                    case 2:
                        if(!save.doesEmployeeExists()){
                            System.out.println("You must register first!");
                        }else{
                            employee.addBooks(library);
                        }
                        break;

                    case 3:
                            employee.borrowConfirm(save, library, borrow , manager);

                        break;

                    case 4:
                        if(!save.doesEmployeeExists()) {
                            System.out.println("You must register first!");
                        } else {
                            employee.returnConfirm(save, library, manager);
                        }

                        break;

                    case 5:
                        if (!save.doesEmployeeExists()) {
                            System.out.println("You are not registered yet!");
                            break;
                        }

                        System.out.println("Enter your first name:");
                        String empFirstName = scanner.nextLine();
                        System.out.println("Enter your last name:");
                        String empLastName = scanner.nextLine();

                        Employee loadedEmployee = save.loadEmployee(empFirstName, empLastName);
                        if (loadedEmployee != null) {
                            loadedEmployee.showEmployeeInfo(save);
                        } else {
                            System.out.println("Employee not found!");
                        }

                        if (currentEmployee != null) {
                            currentEmployee.showEmployeeInfo(save);
                        } else {
                            System.out.println("You need to register first!");
                        }

                        break;
                }
            default:
                System.out.println("Invalid role selection!");

        }
    }
}
