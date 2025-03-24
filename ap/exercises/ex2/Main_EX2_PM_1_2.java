package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k;
        System.out.println("please enter a number:");
        k = scanner.nextInt();
        int size = k + 2;
        char[][] square = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    square[i][j] = '*';
                } else {
                    square[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }

    }
}
