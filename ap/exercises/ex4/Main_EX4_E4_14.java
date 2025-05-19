package ap.exercises.ex4;


public class Main_EX4_E4_14 {
    public static void main(String[] args) {

        char ch[][] = new char[7][10];

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if ((i == 1 || i == 3 || i == 5) && (j == 1 || j == 2 || j == 4 || j == 5 || j == 7 || j == 8)) {
                    ch[i][j] = ' ';
                }
            }
        }


        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if ((i == 0 || i == 2 || i == 4 || i == 6) && (j == 0 || j == 3 || j == 6 || j == 9)) {
                    ch[i][j] = '+';
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if ((i == 0 || i == 2 || i == 4 || i == 6) && (j == 1 || j == 2 || j == 4 || j == 5 || j == 7 || j == 8)) {
                    ch[i][j] = '-';
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if ((i == 1 || i == 3 || i == 5) && (j == 0 || j == 3 || j == 6 || j == 9)) {
                    ch[i][j] = '|';
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }

    }
}
