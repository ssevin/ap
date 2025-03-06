package e5_2;

import java.util.Scanner;

public class ExampleE5_2 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number");
        float number;
        number = scanner.nextFloat();
        if (number == 0) {
            System.out.println("Zero");
        } else if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        }
        if (Math.abs(number) < 1) {
            System.out.println("small");
        } else if (Math.abs(number) > 1000000) {
            System.out.println(0"large");
        }

    }
}

