package ap.exercises.ex2;

import java.util.Scanner;
import java.util.Random;

public class Main_EX2_PM_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 10;
        char[][] square = new char[size][size];
        int y = 1;
        int x = 1;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = ' ';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[0][i] = '*';
                square[i][0] = '*';
                square[i][size - 1] = '*';
                square[size - 1][i] = '*';
            }
        }

        square[y][x] = 'X';
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the number of points:(MAX:64)");
        int number = scanner.nextInt();
        scanner.nextLine();


        Random random = new Random();
        int addedPoints = 0;

        while (addedPoints < number) {
            int randY = 1 + random.nextInt(size - 2);
            int randX = 1 + random.nextInt(size - 2);

            if (square[randY][randX] == ' ') {
                square[randY][randX] = '.';
                addedPoints++;
            }
        }
        int score = 0;
        boolean running = true;

        while (running) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Score: " + score);
            System.out.println("Points remaining: " + addedPoints);
            System.out.println("choose one: a/s/d/w/q");
            System.out.println("a:left / s:down / d:right / w:up / q:exit");
            String choice = scanner.nextLine();

            square[y][x] = ' ';

            switch (choice) {
                case "w":
                    if (y > 1) {
                        y--;
                    } else {
                        System.out.println("hitting the game wall!");
                    }
                    break;

                case "a":
                    if (x > 1)
                        x--;
                    break;

                case "s":
                    if (y < size - 2)
                        y++;
                    break;

                case "d":
                    if (x < size - 2)
                        x++;
                    break;

                case "q":
                    System.out.println("EXIT...");
                    running = false;
                    continue;
                default:
                    System.out.println("Invalid input!");
                    continue;

            }
            if (square[y][x] == '.') {
                score++;
                addedPoints--;
            }
            square[y][x] = 'X';

            if (addedPoints == 0) {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(square[i][j] + " ");
                    }
                    System.out.println();
                }
                long endTime = System.currentTimeMillis();
                long duration = (endTime - startTime) / 1000;

                System.out.println("Game Over!");
                System.out.println("Final score: " + score);
                System.out.println("Time: " + duration + " seconds");
                running = false;

            }
        }
    }
}

