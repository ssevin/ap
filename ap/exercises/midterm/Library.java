package ap.exercises.midterm;

import java.util.ArrayList;

public class Library {

    public String name = "Zanjan University Library" ;

    private ArrayList<Book> books ;

    private Save save = new Save();

    public Library(){
        books = save.loadBooks();
        if (books.isEmpty()) {

            books.add(new Book("Java Programming", "John Doe", 2020, 400, 15));
            books.add(new Book("Data Structures", "Jane Smith", 2019, 350, 13));
            books.add(new Book("Algorithms", "Robert Johnson", 2021, 500, 10));
            books.add(new Book("Clean Code" , "Robert C. Martin", 2008 , 464 , 5));
            books.add(new Book("Refactoring" , "Martin Fowler" , 1999 , 464 , 4));
            books.add(new Book("Atomic Habits" , "James Clear" , 2018 , 320 , 7 ));
            books.add(new Book("Deep Work" , "Cal Newport" , 2016 , 296 , 10));
            saveBooks();
        }
    }

    public void saveBooks() {
        save.saveBooks(books);
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
        saveBooks();
    }

}
