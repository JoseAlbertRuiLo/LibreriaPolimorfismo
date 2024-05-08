package libreria;

import java.util.ArrayList;

public class LibraryController {

    private static Administrator currentAdmin = null;
    private static Client currentClient = null;

    public static void borrowBook() {
        if (currentAdmin == null) {
            System.out.println("Debe ser Administrador para prestar libros.");
            return;
        }

        String[] nameAndLastName = ConsoleReader.readNameAndLastName("Ingrese el nombre y apellido del cliente:");
        String clientName = nameAndLastName[0];
        String clientLastName = nameAndLastName[1];
        Client client = ClientRepository.getClientByName(clientName, clientLastName);

        if (client != null) {
            String isbn = ConsoleReader.readString("Ingrese el ISBN del libro: ");
            Book book = BookRepository.getBookByISBN(isbn);

            if (book != null && book.isAvailable()) {
                client.borrowBook(book);
                book.setAvailable(false);
                TransactionRepository.addTransaction(new Transaction("Prestado", client, book));
                System.out.println("Libro prestado exitosamente.");
            } else {
                System.out.println("El libro no está disponible para préstamo.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static boolean loginAsAdministrator(String username, String password) {
        Administrator admin = AdministratorRepository.getAdministratorByUsername(username);
        if (admin != null && admin.checkPassword(password)) {  // Verifica el hash de la contraseña.
            currentAdmin = admin;  // Guarda la sesión actual.
            return true;  // Inicio de sesión exitoso.
        } else {
            return false;  // Inicio de sesión fallido.
        }
    }

    public static boolean loginAsClient(String username, String password) {
        Client client = ClientRepository.getClientByUsername(username);  // Asegúrate de que este método exista.
        if (client != null && client.checkPassword(password)) {  // Comprueba el hash de la contraseña.
            currentClient = client;  // Si el inicio de sesión es exitoso, guarda el cliente actual.
            return true;  // Inicio de sesión exitoso.
        } else {
            return false;  // Inicio de sesión fallido.
        }
    }

    public static void returnBook() {
        if (currentAdmin == null) {
            System.out.println("Debe ser Administrador para devolver libros.");
            return;
        }

        String[] nameAndLastName = ConsoleReader.readNameAndLastName("Ingrese el nombre y apellido del cliente:");
        String clientName = nameAndLastName[0];
        String clientLastName = nameAndLastName[1];
        Client client = ClientRepository.getClientByName(clientName, clientLastName);

        if (client != null && !client.getBorrowedBooks().isEmpty()) {
            String isbn = ConsoleReader.readString("Ingrese el ISBN del libro: ");
            Book book = BookRepository.getBookByISBN(isbn);

            if (book != null && client.getBorrowedBooks().contains(book)) {
                client.returnBook(book);
                book.setAvailable(true);
                TransactionRepository.addTransaction(new Transaction("Devuelto", client, book));
                System.out.println("Libro devuelto exitosamente.");
            } else {
                System.out.println("El cliente no tiene este libro prestado.");
            }
        } else {
            System.out.println("El cliente no tiene libros prestados.");
        }
    }

    public static void displayAllBooks() {
        ArrayList<Book> books = BookRepository.getAllBooks();  // Verifica que esta función exista.
        if (books.isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            System.out.printf("%-15s%-40s%-30s%-15s%n", "ISBN", "Título", "Autor", "Disponible");
            for (Book book : books) {
                System.out.printf("%-15s%-40s%-30s%-15s%n", book.getIsbn(), book.getTitle(), getAuthorName(book.getAuthor()), book.isAvailable());
            }
        }
    }

    public static void displayAllAuthors() {
        ArrayList<Author> authors = AuthorRepository.getAllAuthors();  // Asegúrate de que esta función esté definida.
        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            System.out.printf("%-20s%-20s%n", "Nombre", "Apellido");
            for (Author author : authors) {
                System.out.printf("%-20s%-20s%n", author.getProfile().getName(), author.getProfile().getLastName());
            }
        }
    }

    public static void displayAllClients() {
        ArrayList<Client> clients = ClientRepository.getAllClients();  // Verifica esta función.
        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.printf("%-20s%-20s%-20s%n", "Nombre", "Apellido", "Libros Prestados");
            for (Client client : clients) {
                System.out.printf("%-20s%-20s%-20s%n", client.getProfile().getName(), client.getProfile().getLastName(), client.getBorrowedBooks().size());
            }
        }
    }

    public static void displayAllTransactions() {
        ArrayList<Transaction> transactions = TransactionRepository.getAllTransactions();  // Verifica esta función.
        if (transactions.isEmpty()) {
            System.out.println("No hay transacciones.");
        } else {
            System.out.printf("%-20s%-40s%-20s%-20s%n", "Cliente", "Libro", "Tipo", "Fecha");
            for (Transaction transaction : transactions) {
                System.out.printf("%-20s%-40s%-20s%-20s%n", getClientName(transaction.getClient()), getBookTitle(transaction.getBook()), transaction.getType(), transaction.getDate());
            }
        }
    }

    public static void displayClientMenu() {
        System.out.println("Menú de Cliente");
        System.out.println("1. Mostrar libros");
        System.out.println("2. Mostrar mis transacciones");
        System.out.println("3. Salir");

        int option = ConsoleReader.readInt("Seleccione una opción:");

        switch (option) {
            case 1 ->
                displayAllBooks();
            case 2 ->
                displayClientTransactions();  // Asegúrate de tener la función correspondiente.
            case 3 ->
                System.out.println("Saliendo del programa.");
            default ->
                System.out.println("Opción no válida.");
        }
    }

    private static String getAuthorName(Author author) {
        if (author != null && author.getProfile() != null) {
            return author.getProfile().getName() + " " + author.getProfile().getLastName();
        } else {
            return "Autor Desconocido";
        }
    }

    private static String getBookTitle(Book book) {
        return (book != null) ? book.getTitle() : "Libro Desconocido";
    }

    private static String getClientName(Client client) {
        return (client != null && client.getProfile() != null)
                ? client.getProfile().getName() + " " + client.getProfile().getLastName()
                : "Cliente Desconocido";
    }

    private static void displayClientTransactions() {
        if (currentClient == null) {
            System.out.println("Cliente no válido.");
            return;
        }

        ArrayList<Transaction> clientTransactions = new ArrayList<>();
        ArrayList<Transaction> allTransactions = TransactionRepository.getAllTransactions();  // Verifica si este método está definido.
        for (Transaction transaction : allTransactions) {  // Usa la variable iterada `transaction`.
            if (transaction.getClient().equals(currentClient)) {
                clientTransactions.add(transaction);
            }
        }

        if (clientTransactions.isEmpty()) {
            System.out.println("No hay transacciones para este cliente.");
        } else {
            System.out.printf("%-40s%-20s%-20s%n", "Libro", "Tipo", "Fecha");
            for (Transaction transaction : clientTransactions) {  // Aquí debe ser `clientTransactions`.
                System.out.printf(
                        "%-40s%-20s%-20s%n",
                        getBookTitle(transaction.getBook()),
                        transaction.getType(),
                        transaction.getDate()
                );
            }
        }
    }
}
