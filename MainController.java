package libreria;

public class MainController {

    public static void main(String[] args) {
        Seeder.initialize();  // Inicializar datos
        runLibraryManagementSystem();  // Iniciar el sistema
    }

    public static void runLibraryManagementSystem() {
        Menu menu = new Menu();

        menu.addOption("1", new Controller() {
            @Override
            public void execute() {
                loginAsAdministrator(); // Iniciar sesión como administrador
            }

            @Override
            public String getDescription() {
                return "1. Iniciar sesión como Administrador";
            }
        });

        menu.addOption("2", new Controller() {
            @Override
            public void execute() {
                loginAsClient(); // Iniciar sesión como cliente
            }

            @Override
            public String getDescription() {
                return "2. Iniciar sesión como Cliente";
            }
        });

        menu.addOption("3", new Controller() {
            @Override
            public void execute() {
                System.out.println("Saliendo del programa."); // Salir del programa
            }

            @Override
            public String getDescription() {
                return "3. Salir del programa";
            }
        });

        String choice;
        do {
            menu.display(); // Mostrar el menú
            choice = ConsoleReader.readString("Seleccione una opción: "); // Leer entrada del usuario
            menu.execute(choice); // Ejecutar acción
        } while (!choice.equals("3")); // Mantener el bucle hasta que el usuario decida salir
    }

    private static void loginAsAdministrator() {
        String username = ConsoleReader.readString("Ingrese su nombre de usuario: "); // Leer nombre de usuario
        String password = ConsoleReader.readString("Ingrese su contraseña: "); // Leer contraseña

        if (LibraryController.loginAsAdministrator(username, password)) { // Verificar el inicio de sesión
            System.out.println("Inicio de sesión exitoso.");
            LibraryManagementSystem.run(); // Iniciar el sistema para el administrador
        } else {
            System.out.println("Error en el inicio de sesión como administrador.");
        }
    }

    private static void loginAsClient() {
        String username = ConsoleReader.readString("Ingrese su nombre de usuario: "); // Leer nombre de usuario
        String password = ConsoleReader.readString("Ingrese su contraseña: "); // Leer contraseña

        if (LibraryController.loginAsClient(username, password)) { // Verificar el inicio de sesión
            System.out.println("Inicio de sesión exitoso.");
            LibraryManagementSystem.run(); // Iniciar el sistema para el cliente
        } else {
            System.out.println("Error en el inicio de sesión como cliente.");
        }
    }
}


