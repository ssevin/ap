package ap.exercises.ex4;

class Person {

    private String p;
    private String f1;
    private String f2;
    private String f3;
    private String f4;

    public Person(String p, String f1, String f2, String f3, String f4) {
        this.p = p;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
    }

    public String getP() {
        return p;
    }

    public String getF1() {
        return f1;
    }

    public String getF2() {
        return f2;
    }

    public String getF3() {
        return f3;
    }

    public String getF4() {
        return f4;
    }
}


public class Main_EX4_P3_6 {

    public static void befriend(Person p) {
        System.out.println(p.getP() + " is friends with others.");
    }

    public static void unfriend(Person p) {
        System.out.println(p.getF1() + " and " + p.getF2() + " has unfriended someone.");
    }

    public static String getFriendNames(Person p) {

        return p.getF1() + " , " + p.getF2() + " , " + p.getF3() + " , " + p.getF4();
    }

    public static void main(String[] args) {

        Person person = new Person("sara", "maryam", "zahra", "fatemeh", "roze");
        befriend(person);
        unfriend(person);

        String friends = getFriendNames(person);
        System.out.println(friends);

    }
}
