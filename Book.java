package libreria;

import java.util.Date;

public class Book extends DatedItem {
    private String isbn;
    private String title;
    private Author author;
    private boolean isAvailable;

    public Book(String isbn, String title, Author author, Date publishDate, boolean isAvailable) {
        super(publishDate);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}









