package ap.exercises.ex4;

import java.util.Random;

public class Main_EX4_3_4 {

    public static int getFirstSwitchState() {

        Random random = new Random();
        int number1;
        number1 = random.nextInt(2);
        System.out.println("FirstSwitchState: " + number1);
        return number1;
    }

    public static int getSecondSwitchState(int firstState) {

        Random random = new Random();
        if (firstState == 1) {
            System.out.println("Second Switch State:" + " 0 , down");
        } else {
            System.out.println("Second Switch State:" + " 1 , up");
        }
        return firstState;
    }

    public static int getLampState(int firstState, int secondState) {

        if (firstState == 0) {
            System.out.println("Lamp State: " + "0 , off");
        } else {
            System.out.println("Lamp State:" + "1 , on");
        }
        return firstState;

    }

    public static void toggleFirstSwitch(int firstState) {
        int newState1 = (firstState == 0) ? 1 : 0;
        System.out.println("Toggled First Switch from " + firstState + " to " + newState1);

        int newSecondState = getSecondSwitchState(newState1);
        int newLampState = getLampState(newState1, newSecondState);
    }

    public static void toggleSecondSwitch(int secondState) {
        int newState2 = (secondState == 0) ? 1 : 0;
        System.out.println("Toggled Second Switch from " + secondState + " to " + newState2);

        int newSecondState = getSecondSwitchState(newState2);
        int newLampState = getLampState(newState2, newSecondState);
    }

    public static void main(String[] args) {

        int firstState = getFirstSwitchState();
        int secondState = getSecondSwitchState(firstState);
        int lampState = getLampState(firstState, secondState);
        toggleFirstSwitch(firstState);
        toggleFirstSwitch(secondState);

    }
}
