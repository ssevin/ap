package e6_1e;

import java.util.Scanner;

public class ExampleE6_1e {

    public static void main(String[] args) {

        int number;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        number = scanner.nextInt();
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                sum += digit;
            }
            number /= 10;
        }
        System.out.println("sum of odd digits is:" + sum);
    }
}
