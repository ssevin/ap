package e6_1a;

public class ExampleE6_1a {
    public static void main(String[] args) {

        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }

        System.out.println("result is:" + sum);
    }
}