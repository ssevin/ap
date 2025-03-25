import java.util.Scanner;
import java.util.Random;

public class Main_EX2_PM_1_3 {
    public static void main(String[] args) {
        int number;
        final int size = 10;
        char[][] square = new char[size][size];
        int insideSquare = (size - 2) * (size - 2);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = ' ';
            }
        }
        for (int i = 0; i < size; i++) {
            square[i][0] = '*';
            square[i][size - 1] = '*';
            square[0][i] = '*';
            square[size - 1][i] = '*';
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points:(MAX:64)");
        number = scanner.nextInt();

        while (number > insideSquare || number < 0) {
            System.out.println("Please enter a number between 0-64");
            number = scanner.nextInt();
        }
        Random random = new Random();
        int addedPoints = 0;
        while (addedPoints < number) {
            int row = 1 + random.nextInt(size - 2);
            int col = 1 + random.nextInt(size - 2);

            if (square[row][col] == ' ') {
                square[row][col] = '.';
                addedPoints++;
            }
        }

        System.out.println("final square is:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }

    }
}
