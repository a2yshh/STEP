// File: Vehicle.java
import java.util.UUID;

public class Vehicle {
    // Protected fields for inheritance
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // Private fields (encapsulation)
    private String registrationNumber;
    private boolean isRunning;

    // Default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = UUID.randomUUID().toString();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = UUID.randomUUID().toString();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // Methods for vehicle operations
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Vehicle Info: " + brand + " " + model + " (" + year + "), Engine: " 
                + engineType + ", Reg#: " + registrationNumber + ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }

    // Getter/Setter for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }
}

// File: Car.java
public class Car extends Vehicle {
    // Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // Default constructor
    public Car() {
        super(); // Explicit call to parent default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // Parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Explicit call to parent parameterized constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // Overriding start method
    @Override
    public void start() {
        super.start(); // Call parent version first
        System.out.println("Car-specific startup: Engine warmed up, electronics initialized");
    }

    // Overriding displaySpecs method
    @Override
    public void displaySpecs() {
        super.displaySpecs(); // Call parent method
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission Type: " + transmissionType);
    }

    // Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // Main method for testing
    public static void main(String[] args) {
        // 1. Constructor chaining test
        System.out.println("=== Default Constructor Test ===");
        Car car1 = new Car();

        System.out.println("\n=== Parameterized Constructor Test ===");
        Car car2 = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Petrol", "Automatic");

        // 2. Test inheritance of fields and methods
        System.out.println("\n=== Inherited Fields & Methods ===");
        System.out.println("Brand (from Vehicle): " + car2.brand); // protected field
        car2.start(); // overridden method
        car2.stop();  // inherited method
        System.out.println(car2.getVehicleInfo());

        // 3. Test super keyword usage
        System.out.println("\n=== Display Specs (with super) ===");
        car2.displaySpecs();

        // 4. Test Car-specific methods
        System.out.println("\n=== Car-specific Methods ===");
        car2.openTrunk();
        car2.playRadio();

        // 5. Polymorphic behavior
        System.out.println("\n=== Polymorphism Test ===");
        Vehicle v = new Car("Honda", "Civic", 2023, "Petrol", 4, "Petrol", "CVT");
        v.start();   // Calls Car's overridden start
        v.displaySpecs(); // Calls Car's overridden displaySpecs
    }
}
