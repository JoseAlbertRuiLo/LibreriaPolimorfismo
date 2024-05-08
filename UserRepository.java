package libreria;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>(); // Almacenar usuarios (clientes y administradores)

    public static void addUser(User user) {
        users.add(user); // Agregar usuario a la lista
    }

    public static List<User> getAllUsers() { 
        return new ArrayList<>(users); // Devolver una copia de la lista de usuarios
    }

    public static ArrayList<Client> getAllClients() { 
        ArrayList<Client> clients = new ArrayList<>(); // Lista para almacenar clientes
        for (User user : users) { // Iterar sobre la lista de usuarios
            if (user instanceof Client) { // Verificar si el usuario es un cliente
                clients.add((Client) user); // Agregar a la lista de clientes
            }
        }
        return clients; // Devolver la lista de clientes
    }

    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) { 
                return user; // Devolver usuario por nombre de usuario
            }
        }
        return null; // Devolver null si no se encuentra
    }

    public static void deleteUser(String username) {
        User userToDelete = getUserByUsername(username); // Buscar usuario por nombre de usuario
        if (userToDelete != null) {
            users.remove(userToDelete); // Eliminar usuario si se encuentra
            System.out.println("Usuario eliminado."); 
        } else {
            System.out.println("No se encontró el usuario."); 
        }
    }
}

