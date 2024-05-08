package libreria;

import java.util.Scanner;

public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Para consumir la línea nueva
        return input;
    }

    // Esta función debería leer el nombre y apellido de una persona.
    public static String[] readNameAndLastName(String prompt) {
        System.out.println(prompt); // Mostrar el mensaje
        System.out.print("Nombre: "); // Pedir el nombre
        String name = scanner.nextLine(); // Leer el nombre
        System.out.print("Apellido: "); // Pedir el apellido
        String lastName = scanner.nextLine(); // Leer el apellido
        return new String[] { name, lastName }; // Devolver como arreglo
    }
}
