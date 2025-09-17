// Parent class
class Phone {
    protected String brand;
    protected String model;

    // Default constructor
    public Phone() {
        System.out.println("Phone: Default constructor called");
        this.brand = "Unknown";
        this.model = "Unknown";
    }

    // Parameterized constructor
    public Phone(String brand, String model) {
        System.out.println("Phone: Parameterized constructor called");
        this.brand = brand;
        this.model = model;
    }

    public void showDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}

// Child class
class SmartPhone extends Phone {
    private String operatingSystem;

    // Default constructor
    public SmartPhone() {
        super();  // Calls parent default constructor
        System.out.println("SmartPhone: Default constructor called");
        this.operatingSystem = "Unknown OS";
    }

    // Parameterized constructor
    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);  // Calls parent parameterized constructor
        System.out.println("SmartPhone: Parameterized constructor called");
        this.operatingSystem = operatingSystem;
    }

    public void showDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", OS: " + operatingSystem);
    }
}

// Test class
public class PhoneSmartPhoneDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Phone objects ===");
        Phone p1 = new Phone();
        p1.showDetails();

        Phone p2 = new Phone("Nokia", "3310");
        p2.showDetails();

        System.out.println("\n=== Creating SmartPhone objects ===");
        SmartPhone sp1 = new SmartPhone();
        sp1.showDetails();

        SmartPhone sp2 = new SmartPhone("Apple", "iPhone 15", "iOS");
        sp2.showDetails();
    }
}
