// Parent class
class Light {
    int brightness;
    String color;

    // No-arg constructor
    public Light() {
        this(100);  // calls constructor with int parameter
        System.out.println("Light() - No-arg constructor");
    }

    // One-arg constructor
    public Light(int brightness) {
        this(brightness, "White");  // calls constructor with two parameters
        System.out.println("Light(int) - One-arg constructor");
    }

    // Two-arg constructor
    public Light(int brightness, String color) {
        this.brightness = brightness;
        this.color = color;
        System.out.println("Light(int, String) - Two-arg constructor");
    }
}

// Child class
class LED extends Light {
    String type;

    // No-arg constructor
    public LED() {
        this("Standard");  // calls one-arg constructor in same class
        System.out.println("LED() - No-arg constructor");
    }

    // One-arg constructor
    public LED(String type) {
        super();  // calls Light() constructor
        this.type = type;
        System.out.println("LED(String) - One-arg constructor");
    }

    // Two-arg constructor
    public LED(int brightness, String color, String type) {
        super(brightness, color);  // calls specific Light constructor
        this.type = type;
        System.out.println("LED(int, String, String) - Two-arg constructor");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        System.out.println("Creating LED using no-arg constructor:");
        LED led1 = new LED();

        System.out.println("\nCreating LED using one-arg constructor:");
        LED led2 = new LED("Smart");

        System.out.println("\nCreating LED using full constructor:");
        LED led3 = new LED(200, "Blue", "Smart Dimmable");
    }
}
