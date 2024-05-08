package libreria;

public class LibraryManagementSystem {
    private static Menu menu;

    public static void run() {
        initializeMenu(); // Iniciar el menú
        String choice;
        do {
            menu.display(); // Mostrar opciones
            choice = ConsoleReader.readString("Seleccione una opción: "); // Leer entrada del usuario
            menu.execute(choice); // Ejecutar acción
        } while (!choice.equals("7")); // Salir con opción 7
    }

    private static void initializeMenu() {
        menu = new Menu();

        menu.addOption("1", new Controller() {
            @Override
            public void execute() {
                LibraryController.borrowBook(); // Prestar libro
            }

            @Override
            public String getDescription() {
                return "1. Prestar libro";
            }
        });

        menu.addOption("2", new Controller() {
            @Override
            public void execute() {
                LibraryController.returnBook(); // Devolver libro
            }

            @Override
            public String getDescription() {
                return "2. Devolver libro";
            }
        });

        menu.addOption("3", new Controller() {
            @Override
            public void execute() {
                LibraryController.displayAllBooks(); // Mostrar todos los libros
            }

            @Override
            public String getDescription() {
                return "3. Mostrar todos los libros";
            }
        });

        menu.addOption("4", new Controller() {
            @Override
            public void execute() {
                LibraryController.displayAllAuthors(); // Mostrar todos los autores
            }

            @Override
            public String getDescription() {
                return "4. Mostrar todos los autores";
            }
        });

        menu.addOption("5", new Controller() {
            @Override
            public void execute() {
                LibraryController.displayAllClients(); // Mostrar todos los clientes
            }

            @Override
            public String getDescription() {
                return "5. Mostrar todos los clientes";
            }
        });

        menu.addOption("6", new Controller() {
            @Override
            public void execute() {
                LibraryController.displayAllTransactions(); // Mostrar todas las transacciones
            }

            @Override
            public String getDescription() {
                return "6. Mostrar todas las transacciones";
            }
        });

        menu.addOption("7", new Controller() {
            @Override
            public void execute() {
                System.out.println("Saliendo del sistema."); // Opción para salir
            }

            @Override
            public String getDescription() {
                return "7. Salir";
            }
        });
    }
}
