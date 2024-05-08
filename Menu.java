package libreria;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Controller> options;

    public Menu() {
        this.options = new HashMap<>();
    }

    public void addOption(String label, Controller controller) {
        options.put(label, controller);
    }

    public void display() {
        options.forEach((key, value) -> System.out.printf("%s: %s%n", key, value.getDescription()));
    }

    public void execute(String key) {
        Controller controller = options.get(key);
        if (controller != null) {
            controller.execute();
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
