package ap.exercises.ex4;

import java.util.Arrays;

class Sequence{

    private int[] values;

    public Sequence(int size){
        values = new int[size];
    }

    public void set(int i , int n){
        values[i] = n;
    }

    public int get(int i){
        return values[i];
    }

    public int size(){
        return values.length;
    }

    public boolean equals(Sequence other) {

        if (this.size() != other.size()) {
            return false;
        }


        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }

        return true;
    }


}

public class Main_EX4_E7_12 {
    public static void main(String[] args) {

                Sequence seq1 = new Sequence(3);
                seq1.set(0, 10);
                seq1.set(1, 20);
                seq1.set(2, 30);

                Sequence seq2 = new Sequence(3);
                seq2.set(0, 10);
                seq2.set(1, 20);
                seq2.set(2, 30);

                Sequence seq3 = new Sequence(2);
                seq3.set(0, 10);
                seq3.set(1, 20);

                System.out.println(seq1.equals(seq2));
                System.out.println(seq1.equals(seq3));

    }
}
