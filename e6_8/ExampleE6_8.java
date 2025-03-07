package e6_8;

import java.util.Scanner;

public class ExampleE6_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        char character;
        System.out.println("Enter a word:");
        word = scanner.nextLine();

        System.out.println("Characters of the word:");
        for (int i = 0; i < word.length(); i++) {
            character = word.charAt(i);
            System.out.println(character);
        }
    }
}
