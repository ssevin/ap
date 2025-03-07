package e6_2a;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ExampleE6_2a {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numbers[] = new int[5];
        int max = numbers[0];
        int min = numbers[0];
        System.out.println("Enter 5 numbers");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (numbers[i] > numbers[0]) {
                max = numbers[i];
            }
            if (numbers[i] < numbers[0]) {
                min = numbers[i];
            }
        }
        System.out.println("Max number is:" + max);
        System.out.println("Min number is:" + min);


    }
}