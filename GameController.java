public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    // Default constructor
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Parameterized constructor
    public GameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = Math.min(Math.max(batteryLevel, 0), 100); // Validate battery
        this.sensitivity = Math.min(Math.max(sensitivity, 0.1), 3.0); // Validate sensitivity
    }

    // Two-parameter convenience constructor
    public GameController(String controllerBrand, String connectionType) {
        this(controllerBrand, connectionType, true, 100, 1.0); // Default other values
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("\n=== " + controllerBrand + " CONFIGURATION ===");
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        GameController defaultController = new GameController();
        GameController customController = new GameController("ProPad", "Bluetooth", true, 85, 2.5);
        GameController convenienceController = new GameController("LitePad", "USB");

        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        convenienceController.displayConfiguration();
        convenienceController.calibrateController();
        convenienceController.testVibration();
    }
}
