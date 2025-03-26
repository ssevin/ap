package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_2_1 {
    public static void main(String[] args) {
        int size = 10;
        char[][] square = new char[size][size];
        int choose;
        int y = 1;
        int x = 1;

        do {
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

            square[y][x] = 'X';
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(square[i][j]);
                }
                System.out.println();
            }
            System.out.println("choose one of them: (0=UP, 1=RIGHT, 2=DOWN, 3=LEFT, other=EXIT)");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();


            switch (choose) {
                case 0:
                    if (y > 1) {
                        y--;
                        System.out.println("UP");
                    } else {
                        System.out.println("hitting the game wall!");
                    }
                    break;

                case 1:
                    if (x < size - 2) {
                        x++;
                        System.out.println("RIGHT");
                    } else {
                        System.out.println("hitting the game wall!");
                    }
                    break;

                case 2:
                    if (y < size - 2) {
                        y++;
                        System.out.println("DOWN");
                    } else {
                        System.out.println("hitting the game wall!");
                    }
                    break;

                case 3:
                    if (x > 1) {
                        x--;
                        System.out.println("LEFT");
                    } else {
                        System.out.println("hitting the game wall!");
                    }
                    break;


            }


        } while (choose >= 0 && choose <= 3);


    }
}
