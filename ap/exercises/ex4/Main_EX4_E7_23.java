package ap.exercises.ex4;
import java.util.ArrayList;

class Sequence {
    private ArrayList<Integer> values;

    public Sequence() {
        values = new ArrayList<Integer>();
    }

    public void add(int n) {
        values.add(n);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    public Sequence append(Sequence other) {
        Sequence result = new Sequence();

        for (int num : this.values) {
            result.add(num);
        }

        for (int num : other.values) {
            result.add(num);
        }

        return result;
    }
}


public class Main_EX4_E7_23 {
    public static void main(String[] args) {

        Sequence a = new Sequence();
        a.add(1);
        a.add(4);
        a.add(9);
        a.add(16);

        Sequence b = new Sequence();
        b.add(9);
        b.add(7);
        b.add(4);
        b.add(9);
        b.add(11);

        Sequence combined = a.append(b);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a.append(b): " + combined);

    }
}
