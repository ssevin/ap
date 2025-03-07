package e6_5;

import java.util.Scanner;

public class ExampleE6_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float numbers[] = new float[100];
        float range;
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        int size;
        float avg;
        float sum = 0;
        int choice;
        System.out.println("Enter count of float numbers:");
        size = scanner.nextInt();
        System.out.println("Enter numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextFloat();
        }
        System.out.println("Please choose one of them:");
        System.out.println("\n");
        System.out.println("1- The average of the values");
        System.out.println("2- The smallest of the values.");
        System.out.println("3- The largest of the values.");
        System.out.println("4- The range, that is the difference between the smallest and largest.");
        choice = scanner.nextInt();

        switch (choice) {

            case 1:
                for (int i = 0; i < size; i++) {
                    sum += numbers[i];
                }
                avg = sum / size;
                System.out.println("The average of the value is:" + avg);
                break;

            case 2:
                for (int i = 0; i < size; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                    }
                }
                System.out.println("The smallest of the value is:" + min);
                break;

            case 3:
                for (int i = 0; i < size; i++) {
                    if (numbers[i] > max) {
                        max = numbers[i];
                    }
                }
                System.out.println("The smallest of the value is:" + max);
                break;

            case 4:
                for (int i = 0; i < size; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                    }
                    if (numbers[i] > max) {
                        max = numbers[i];
                    }
                }
                range = max - min;
                System.out.println("The range, that is the difference between the smallest and largest is:" + range);
                break;
        }
    }
}
