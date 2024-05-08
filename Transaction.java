package libreria;

import java.util.Date;
import java.util.UUID;

public class Transaction extends DatedItem {
    private String id;
    private String type;
    private Client client;
    private Book book;

    public Transaction(String type, Client client, Book book) {
        super(new Date());
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.client = client;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }
}




