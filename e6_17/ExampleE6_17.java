package e6_17;

import java.util.Scanner;

import java.util.Scanner;

public class ExampleE6_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter a number:");
        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print("*");
            }
            System.out.print("  ");

            for (int j = 0; j < number; j++) {
                if (i == 0 || i == number - 1 || j == 0 || j == number - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
