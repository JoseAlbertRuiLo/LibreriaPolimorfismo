package libreria;

import java.util.ArrayList;

public class Client extends User {
    private ArrayList<Book> borrowedBooks;

    public Client(Profile profile, String username, String password) {
        super(profile, username, password);
        this.borrowedBooks = new ArrayList<>();
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}




