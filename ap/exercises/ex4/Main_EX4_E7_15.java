package ap.exercises.ex4;

class Sequence {
    private int[] values;

    public Sequence(int size) { values = new int[size]; }
    public void set(int i, int n) { values[i] = n; }
    public int get(int i) { return values[i]; }
    public int size() { return values.length; }

    public Sequence sum(Sequence other) {

        int maxLength = Math.max(this.size(), other.size());
        Sequence result = new Sequence(maxLength);

        int minLength = Math.min(this.size(), other.size());
        for (int i = 0; i < minLength; i++) {
            result.set(i, this.get(i) + other.get(i));
        }

        if (this.size() > other.size()) {
            for (int i = minLength; i < maxLength; i++) {
                result.set(i, this.get(i));
            }
        } else if (other.size() > this.size()) {
            for (int i = minLength; i < maxLength; i++) {
                result.set(i, other.get(i));
            }
        }

        return result;
    }
}

public class Main_EX4_E7_15 {
    public static void main(String[] args) {

        Sequence seq1 = new Sequence(9);
        seq1.set(0, 1); seq1.set(1, 4); seq1.set(2, 9); seq1.set(3, 16);
        seq1.set(4, 9); seq1.set(5, 7); seq1.set(6, 4); seq1.set(7, 9); seq1.set(8, 11);

        Sequence seq2 = new Sequence(7);
        seq2.set(0, 11); seq2.set(1, 11); seq2.set(2, 7); seq2.set(3, 9);
        seq2.set(4, 16); seq2.set(5, 4); seq2.set(6, 1);

        Sequence sumSeq = seq1.sum(seq2);

        System.out.println("sequence 1: " + seq1);
        System.out.println("sequence 2: " + seq2);
        System.out.println("result(sum): " + sumSeq);

    }
}
