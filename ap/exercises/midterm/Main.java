package ap.exercises.midterm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();
        Save save = new Save();
        Input input = new Input();
        Manager manager = null;
        Employee employee = new Employee();

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
                System.out.println("3-Return a book");
                System.out.println("4-Book search");
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

                        break;

                    case 3:

                        break;

                    case 4:
                        ArrayList<Book> books = new ArrayList<>();
                        books.add(new Book("Clean Code" , "Robert C. Martin",
                                2008 , 464 , 5));
                        books.add(new Book("Refactoring" , "Martin Fowler" ,
                                1999 , 464 , 4));
                        books.add(new Book("Atomic Habits" , "James Clear" ,
                                2018 , 320 , 7 ));
                        books.add(new Book("Deep Work" , "Cal Newport" ,
                                2016 , 296 , 10));
                        System.out.println("Enter the author's name or book title:");
                        String choose = scanner.nextLine().toLowerCase();

                        boolean found = false;
                        for(Book book : library.getAllBooks()){
                            if(book.getSubject().toLowerCase().contains(choose) || book.getAuthor().toLowerCase().contains(choose)){
                                System.out.println("Book Found!");
                                System.out.println("Subject: " + book.getSubject());
                                System.out.println("Author: " + book.getAuthor());
                                System.out.println("Year: " + book.getPublishYear());
                                System.out.println("Pages: " + book.getPages());
                                System.out.println("Number of books: " + book.getNumberOfBooks());
                                found = true;
                            }
                            if(!found){
                                System.out.println("No books found matching: " + choose);
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
                break;

            case 2:

                System.out.println("choose one of them:");
                System.out.println("1- View manager information");
                System.out.println("2- Add new employee");
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

                    default:
                        System.out.println("Invalid choice!");
                }
                break;

            case 3:
                System.out.println("choose one of them:");
                System.out.println("1-Registration");
                System.out.println("2-Add book information");
                int choose2 = scanner.nextInt();
                scanner.nextLine();

                switch (choose2){

                    case 1:
                        if(save.doesEmployeeExists()){
                            System.out.println("You have already registered!");
                        }
                        else{
                            employee = new Employee();
                            int randomID = Employee.generateRandomEmployeeID();
                            employee.employeeLogin(randomID);
                            save.saveEmployeeInfo(employee);
                        }

                        System.out.println("Do you want to edit your information?(Y/N)");
                        String choose1 = scanner.nextLine().toLowerCase();

                        if(choose1.equals("y")) {
                            employee.editEmployeeInfo();
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

                }
            default:
                System.out.println("Invalid role selection!");

        }
    }
}
