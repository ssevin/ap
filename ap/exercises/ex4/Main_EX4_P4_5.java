package ap.exercises.ex4;

import java.util.Scanner;

public class Main_EX4_P4_5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int size = 20;
        char[][] area = new char[size][size];

        int xPos = 1;
        int yPos = 1;
        String choice;

        do {
            initializeArea(area, size);

            placeCharacter(area, xPos, yPos);

            displayArea(area, size);

            System.out.println("choose one of them:");
            System.out.println();
            System.out.println("1- Horizontal movement (get X)");
            System.out.println("2- Vertical sanctity (get Y)");
            System.out.println("3- get direction");
            System.out.println();

            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {

                case 1:
                    System.out.println("Enter the horizontal movement distance:");
                    double distance = scanner.nextDouble();
                    scanner.nextLine();
                    double newX = getX(area, xPos, yPos, distance, size);
                    xPos = (int) newX;
                    break;

                case 2:
                    System.out.println("Enter the vertical movement distance:");
                    double yDistance = scanner.nextDouble();
                    scanner.nextLine();
                    yPos = (int) getY(area, xPos, yPos, yDistance, size);
                    break;

                case 3:
                    double direction = getDirection(xPos, yPos);
                    System.out.println("Current direction (column.row): " + direction);
                    break;

                default:
                    System.out.println("Invalid choice!");

            }
            initializeArea(area, size);
            placeCharacter(area, xPos, yPos);
            displayArea(area, size);
            System.out.println("Do you want to continue? (Y/N)");
            choice = scanner.nextLine().toLowerCase();
        } while (choice.equals("y"));
    }

    public static double getX(char[][] area, int currentX, int currentY, double distance, int size) {

        area[currentY][currentX] = ' ';


        double newX = currentX + distance;


        if (newX <= 0) {
            newX = 1;
        } else if (newX >= size - 1) {
            newX = size - 2;
        }

        return newX;
    }

    public static double getY(char[][] area, int currentX, int currentY, double distance, int size) {
        area[currentY][currentX] = ' ';
        double newY = currentY + distance;

        if (newY <= 0) {
            newY = 1;
        } else if (newY >= size - 1) {
            newY = size - 2;
        }

        return newY;
    }

    public static double getDirection(int xPos, int yPos) {

        return xPos + (yPos / 100.0);
    }
    public static void initializeArea(char[][] area, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    area[i][j] = '*';
                } else {
                    area[i][j] = ' ';
                }
            }
        }
    }

    public static void placeCharacter(char[][] area, int x, int y) {
        area[y][x] = 'X';
    }

    public static void displayArea(char[][] area, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

}
