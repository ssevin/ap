package ap.exercises.ex4;

import java.util.ArrayList;
import java.util.List;

class CashRegister {
    private List<Double> purchasedItems;

    public CashRegister() {
        purchasedItems = new ArrayList<>();
    }

    public void addItem(double price) {
        purchasedItems.add(price);
    }

    public double getTotal() {
        double total = 0;
        for (double price : purchasedItems) {
            total += price;
        }
        return total;
    }

    public void printReceipt() {
        String receipt = "purchase invoice:\n";
        for (double price : purchasedItems) {
            String priceStr = String.valueOf(price);
            receipt = receipt.concat("- ").concat(priceStr).concat("\n");
        }

        receipt = receipt.concat("total sum").concat(String.valueOf(getTotal()));

        System.out.println(receipt);
    }
}

public class Main_EX4_3_10 {
    public static void main(String[] args) {

        CashRegister register = new CashRegister();

        register.addItem(11.5);
        register.addItem(33);
        register.addItem(25.50);

        register.printReceipt();
    }
}

