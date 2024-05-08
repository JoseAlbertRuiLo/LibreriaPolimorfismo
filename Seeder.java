package libreria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seeder {

    public static void initialize() {
        Author author1 = new Author(new Profile("J.K.", "Rowling", new Date()));
        Author author2 = new Author(new Profile("George", "Martin", new Date()));
        Author author3 = new Author(new Profile("J.R.R.", "Tolkien", new Date()));
        Author author4 = new Author(new Profile("Agatha", "Christie", new Date()));
        Author author5 = new Author(new Profile("Stephen", "King", new Date()));
        Author author6 = new Author(new Profile("Harper", "Lee", new Date()));
        Author author7 = new Author(new Profile("Gabriel", "García Márquez", new Date()));

        Book book1 = new Book("123", "Harry Potter", author1, new Date(), true);
        Book book2 = new Book("456", "Juego de Tronos", author2, new Date(), true);
        Book book3 = new Book("789", "El Hobbit", author3, new Date(), true);
        Book book4 = new Book("987", "Asesinato en el Orient Express", author4, new Date(), true);
        Book book5 = new Book("654", "Eso", author5, new Date(), true);
        Book book6 = new Book("321", "Matar a un Ruiseñor", author6, new Date(), true);
        Book book7 = new Book("12345", "Cien Años de Soledad", author7, new Date(), true);

        AuthorRepository.addAuthor(author1);
        AuthorRepository.addAuthor(author2);
        AuthorRepository.addAuthor(author3);
        AuthorRepository.addAuthor(author4);
        AuthorRepository.addAuthor(author5);
        AuthorRepository.addAuthor(author6);
        AuthorRepository.addAuthor(author7);

        BookRepository.addBook(book1);
        BookRepository.addBook(book2);
        BookRepository.addBook(book3);
        BookRepository.addBook(book4);
        BookRepository.addBook(book5);
        BookRepository.addBook(book6);
        BookRepository.addBook(book7);

        Client client1 = new Client(new Profile("Alberto", "Ruiz", new Date()), "aruiz", "password");
        Client client2 = new Client(new Profile("Alfredo", "Martínez", new Date()), "amartinez", "password");
        Client client3 = new Client(new Profile("Eva", "Torres", new Date()), "etorres", "password");
        Client client4 = new Client(new Profile("Jorge", "Rodríguez", new Date()), "jrodriguez", "password");
        Client client5 = new Client(new Profile("Miguel", "Tapia", new Date()), "mtapia", "password");
        Client client6 = new Client(new Profile("Cristian", "López", new Date()), "clopez", "password");
        Client client7 = new Client(new Profile("Armando", "Rosas", new Date()), "arosas", "password");

        ClientRepository.addClient(client1);
        ClientRepository.addClient(client2);
        ClientRepository.addClient(client3);
        ClientRepository.addClient(client4);
        ClientRepository.addClient(client5);
        ClientRepository.addClient(client6);
        ClientRepository.addClient(client7);

        Administrator superAdmin = new Administrator(new Profile("Super", "Admin", new Date()), "admin", "superpassword", true);
        superAdmin.setPermissions(new ArrayList<>(List.of(Permissions.READ, Permissions.WRITE, Permissions.DELETE)));
        
        AdministratorRepository.addAdministrator(superAdmin);
    }
}
