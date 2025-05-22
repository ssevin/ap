package ap.exercises.midtermexam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.Callable;

class Laptop{

   private String model;
   private String price;
   private String yearOfMade;
   private String color;

   public Laptop(){

   }

    public Laptop(String model, String price, String yearOfMade, String color) {
        this.model = model;
        this.price = price;
        this.yearOfMade = yearOfMade;
        this.color = color;
    }


    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getYearOfMade() {
        return yearOfMade;
    }

    public String getColor() {
        return color;
    }

    public void display1 (){

        Laptop laptop = new Laptop(model , price , yearOfMade , color);
        ArrayList <Laptop> shop = new ArrayList<>();

        shop.add(new Laptop("B" , "100" , "2010" , "white"));
        shop.add(new Laptop("C" , "100" , "2000" , "black"));

        for (Laptop laptop1 : shop){
            System.out.println("model : " + laptop1.getModel());
            System.out.println("price: " +laptop1.getColor());
            System.out.println("year: " + laptop1.getYearOfMade());
            System.out.println("color: " + laptop1.getColor());
            System.out.println("----------------------------");
        }
    }
}

class Case {

    private String model;
    private String price;
    private String countryName;
    private String size;

    public Case(){

    }
    public Case(String model, String price, String countryName, String size) {
        this.model = model;
        this.price = price;
        this.countryName = countryName;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getSize() {
        return size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void display2 (){

        Case case1 = new Case(model,price , countryName , size);
        ArrayList<Case> shop = new ArrayList<>();
        shop.add(new Case("B" , "100" , "2010" , "white"));
        shop.add(new Case("C" , "100" , "2000" , "black"));

        for (Case case2 : shop){
            System.out.println("model: " + case2.getModel());
            System.out.println("price: " + case2.getPrice());
            System.out.println("country: " + case2.getCountryName());
            System.out.println("size: " + case2.getSize());
        }
    }
}

class Store {
    Laptop laptop = new Laptop();
    Case case1 = new Case();
}
public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        Case case1 = new Case();
        Store store = new Store();
        case1.display2();
        laptop.display1();
    }
}
