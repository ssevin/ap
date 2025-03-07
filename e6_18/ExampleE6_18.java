package e6_18;

import java.util.Scanner;

public class ExampleE6_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int distance;
        System.out.println("Enter a number:");
        number = scanner.nextInt();

        int height = 2 * number - 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                distance = Math.abs(j - (number - 1)) + Math.abs(i - (number - 1));
                if (distance < number) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}
