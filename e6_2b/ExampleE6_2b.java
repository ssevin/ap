package e6_2b;

import java.util.Scanner;

public class ExampleE6_2b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int even = 0;
        int odd = 0;
        int numbers[] = new int[100];

        System.out.println("Enter count of numbers:");
        size = scanner.nextInt();

        System.out.println("Enter numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
            if (numbers[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("count of even numbers:" + even);
        System.out.println("count of odd numbers:" + odd);

        scanner.close();

    }
}
