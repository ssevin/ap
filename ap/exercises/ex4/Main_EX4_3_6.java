package ap.exercises.ex4;

import java.util.Random;

class Circuit {
    private Random random;
    private int firstSwitchState;
    private int secondSwitchState;

    public Circuit() {
        random = new Random();
        firstSwitchState = random.nextInt(2);
        secondSwitchState = random.nextInt(2);
    }

    public int getSwitchState(int switchNum) {
        if (switchNum == 1) return firstSwitchState;
        else if (switchNum == 2) return secondSwitchState;
        return switchNum;
    }

    public int getLampState() {
        return (firstSwitchState != secondSwitchState) ? 1 : 0;
    }

    public void toggleSwitch(int switchNum) {
        if (switchNum == 1) {
            firstSwitchState = random.nextInt(2);
        } else if (switchNum == 2) {
            secondSwitchState = random.nextInt(2);
        }
    }
}

public class Main_EX4_3_6 {
    public static void main(String[] args) {

        Circuit circuit = new Circuit();

        System.out.println("Initial situation:");
        System.out.println("switch 1: " + circuit.getSwitchState(1));
        System.out.println("switch 2:" + circuit.getSwitchState(2));
        System.out.println("lamp :" + circuit.getLampState());

        circuit.toggleSwitch(1);
        System.out.println("After changing switch 1:");
        System.out.println("switch 1 new:" + circuit.getSwitchState(1));
        System.out.println("lamp :" + circuit.getLampState());

    }
}
