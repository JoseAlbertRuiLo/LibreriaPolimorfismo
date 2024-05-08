package libreria;

import java.util.ArrayList;

public class AdministratorRepository {
    private static ArrayList<Administrator> administrators = new ArrayList<>();

    public static void addAdministrator(Administrator administrator) {
        if (!hasSuperAdmin() || administrator.isSuperAdmin()) {
            administrators.add(administrator);
        } else {
            throw new IllegalArgumentException("Ya existe un SuperAdmin. No se pueden crear múltiples SuperAdmins.");
        }
    }

    public static boolean hasSuperAdmin() {
        for (Administrator admin : administrators) {
            if (admin.isSuperAdmin()) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Administrator> getAllAdministrators() {
        return new ArrayList<>(administrators);
    }

    public static void deleteAdministrator(String username) {
        Administrator adminToDelete = getAdministratorByUsername(username);
        if (adminToDelete != null && !adminToDelete.isSuperAdmin()) {
            administrators.remove(adminToDelete);
            System.out.println("Administrador eliminado.");
        } else {
            System.out.println("No se puede eliminar al SuperAdmin o no se encontró el administrador.");
        }
    }

    public static Administrator getAdministratorByUsername(String username) {
        for (Administrator admin : administrators) {
            if (admin.getUsername().equalsIgnoreCase(username)) {
                return admin;
            }
        }
        return null;
    }
}


