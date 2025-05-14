package ap.exercises.midterm;

import java.util.ArrayList;


public class Book {

    private String subject;
    private String author;
    private int publishYear;
    private int pages;
    private int numberOfBooks;

    public Book(){


    }

    public Book(String subject , String author , int publishYear , int pages , int numberOfBooks){
        this.subject = subject;
        this.author = author;
        this.publishYear = publishYear;
        this.pages = pages;
        this.numberOfBooks = numberOfBooks;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getPages() {
        return pages;
    }

    public int getNumberOfBooks(){
        return numberOfBooks;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setNumberOfBooks(int numberOfBooks){
        this.numberOfBooks = numberOfBooks;
    }

}
