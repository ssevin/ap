package ap.exercises.ex2;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Main_EX2_PM_2_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 10;
        char[][] square = new char[size][size];
        int y = 1;
        int x = 1;
        int score = 0;
        int addedPoints = 0;
        long startTime = System.currentTimeMillis();
        boolean running = true;
        boolean loadedFromSave = false;

        File saveFile = new File("save.txt");

        if (saveFile.exists()) {
            System.out.println("A save game was found. Do you want to continue?(y/n)");
            String choice = scanner.nextLine();

            if (choice == "y") {
                try (Scanner fileScanner = new Scanner(saveFile)) {
                    score = fileScanner.nextInt();
                    addedPoints = fileScanner.nextInt();
                    y = fileScanner.nextInt();
                    x = fileScanner.nextInt();
                    fileScanner.nextLine();

                    for (int i = 0; i < size; i++) {
                        square[i] = fileScanner.nextLine().toCharArray();
                    }
                    System.out.println("The game was successfully loaded.");
                    loadedFromSave = true;
                } catch (IOException e) {
                    System.out.println("Error reading save file. Starting a new game...");
                }
            } else {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        square[i][j] = ' ';
                    }
                }

                for (int i = 0; i < size; i++) {
                    square[0][i] = '*';
                    square[i][0] = '*';
                    square[i][size - 1] = '*';
                    square[size - 1][i] = '*';
                }

                square[1][1] = 'X';
                System.out.println("Enter the number of points: (MAX:64)");
                int number = scanner.nextInt();
                scanner.nextLine();

                Random random = new Random();
                while (addedPoints < number) {
                    int randY = 1 + random.nextInt(size - 2);
                    int randX = 1 + random.nextInt(size - 2);

                    if (square[randY][randX] == ' ') {
                        square[randY][randX] = '.';
                        addedPoints++;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    square[i][j] = ' ';
                }
            }

            for (int i = 0; i < size; i++) {
                square[0][i] = '*';
                square[i][0] = '*';
                square[i][size - 1] = '*';
                square[size - 1][i] = '*';
            }

            square[1][1] = 'X';
            System.out.println("Enter the number of points: (MAX:64)");
            int number = scanner.nextInt();
            scanner.nextLine();

            Random random = new Random();
            while (addedPoints < number) {
                int randY = 1 + random.nextInt(size - 2);
                int randX = 1 + random.nextInt(size - 2);

                if (square[randY][randX] == ' ') {
                    square[randY][randX] = '.';
                    addedPoints++;
                }
            }
        }

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
            System.out.println("a:left / s:down / d:right / w:up / q:exit / save: Save the game");
            String choice = scanner.nextLine();

            square[y][x] = ' ';

            switch (choice) {
                case "w":
                    if (y > 1) y--;
                    else System.out.println("hitting the game wall!");
                    break;
                case "a":
                    if (x > 1) x--;
                    break;
                case "s":
                    if (y < size - 2) y++;
                    break;
                case "d":
                    if (x < size - 2) x++;
                    break;
                case "q":
                    System.out.println("EXIT...");
                    running = false;
                    continue;
                case "save":

                    try {
                        FileWriter writer = new FileWriter(saveFile);
                        writer.write(score + "\n");
                        writer.write(addedPoints + "\n");
                        writer.write(y + "\n");
                        writer.write(x + "\n");


                        for (int i = 0; i < square.length; i++) {
                            for (int j = 0; j < square[i].length; j++) {
                                writer.write(square[i][j]);
                            }
                            writer.write("\n");
                        }

                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Error saving game...");
                    }
                    System.out.println("Game saved.");
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
                System.out.println("Score: " + score);
                System.out.println("Points remaining: " + addedPoints);

                long endTime = System.currentTimeMillis();
                long duration = (endTime - startTime) / 1000;
                System.out.println("Game Over!");
                System.out.println("Final score: " + score);
                System.out.println("Time: " + duration + " seconds");

                saveFile.delete();
                running = false;


            }
        }

    }
}




