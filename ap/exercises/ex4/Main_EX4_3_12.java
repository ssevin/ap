package ap.exercises.ex4;

class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double raise) {

        System.out.println(name + " gets a " + (raise / 100) * salary + " percent raise");

    }
}

public class Main_EX4_3_12 {
    public static void main(String[] args) {

        Employee sevin = new Employee("sevin", 4000);
        sevin.raiseSalary(10);
    }
}
