package libreria;

import java.util.ArrayList;

public class Author extends Person {
    private ArrayList<Book> books;

    public Author(Profile profile) {
        super(profile);
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}




