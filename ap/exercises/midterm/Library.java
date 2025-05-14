package ap.exercises.midterm;

import java.util.ArrayList;

public class Library {

    public String name = "Zanjan University Library" ;

    private ArrayList<Book> books = new ArrayList<>();

    private Save save = new Save();

    public Library(){

        books.add(new Book("Java Programming", "John Doe", 2020, 400 , 15));
        books.add(new Book("Data Structures", "Jane Smith", 2019, 350 , 13));
        books.add(new Book("Algorithms", "Robert Johnson", 2021, 500 , 10));

    }

    public void displayBooks(){

        System.out.println(name);
        System.out.println("list of available books:");
        for (Book book : books){
            System.out.println("subject: " + book.getSubject() + "\n" + "author: " + book.getAuthor()
                    + "\n" + "year of publication:" + book.getPublishYear() +
                    "pages: "+ book.getPages() + "number of books: " + book.getNumberOfBooks());
        }
    }


    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }











}
