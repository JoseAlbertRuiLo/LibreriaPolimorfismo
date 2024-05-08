package libreria;

import java.util.ArrayList;

public class ClientRepository {
    private static ArrayList<Client> clients = new ArrayList<>();
    
    public static Client getClientByUsername(String username) {
        for (Client client : clients) {
            if (client.getUsername().equalsIgnoreCase(username)) {  // Compara nombres de usuario.
                return client;  // Devuelve el cliente si coincide.
            }
        }
        return null;  // Si no se encuentra, devuelve `null`.
    }

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static ArrayList<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    public static Client getClientByName(String name, String lastName) {
        for (Client client : clients) {
            if (client.getProfile().getName().equalsIgnoreCase(name) &&
                client.getProfile().getLastName().equalsIgnoreCase(lastName)) {
                return client;
            }
        }
        return null;
    }

    public static void deleteClient(String name, String lastName) {
        Client clientToDelete = getClientByName(name, lastName);
        if (clientToDelete != null && clientToDelete.getBorrowedBooks().isEmpty()) {
            clients.remove(clientToDelete);
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("No se puede eliminar el cliente. Tiene libros prestados.");
        }
    }
}

