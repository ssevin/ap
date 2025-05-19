package ap.exercises.ex4;

import java.util.Scanner;

class Student{

    private String name;
    private int totalQuiz;
    private int totalScore;
    private float avrageScore;
    private int countOfScores;

    public Student(String name , int totalQuiz , float avrageScore , int countOfScores){
        this.name = name;
        this.totalQuiz = totalQuiz;
        this.avrageScore = avrageScore;
        this.countOfScores = countOfScores;
    }

    public String getName() {
        return name;
    }

    public int getTotalQuiz(){
        return totalQuiz;
    }

    public int getTotalScore(){
        return totalScore;
    }

    public float getAvrageScore(){
        return avrageScore;
    }

    public int getCountOfScores(){
        return countOfScores;
    }

    public static void addQuiz(int score){

        System.out.println("score: " + score);

    }

}

public class Main_EX4_P3_8 {
    public static void main(String[] args) {

        Student student = new Student("maryam" , 75 , 62.5F , 2);

        Student.addQuiz(50);

    }
}
