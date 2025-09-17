// Base class
class Fruit {
    // Protected fields so child classes can access
    protected String color;
    protected String taste;

    // Constructor for Fruit
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    // Method to display Fruit details
    public void showFruitDetails() {
        System.out.println("Fruit Color: " + color);
        System.out.println("Fruit Taste: " + taste);
    }
}

// Derived class
class Apple extends Fruit {
    // Additional field for Apple
    private String variety;

    // Constructor for Apple
    public Apple(String color, String taste, String variety) {
        // Call parent constructor
        super(color, taste);
        this.variety = variety;
    }

    // Method to display Apple details
    public void showAppleDetails() {
        // Access inherited fields directly (because they are protected)
        System.out.println("Apple Color: " + color);
        System.out.println("Apple Taste: " + taste);
        System.out.println("Apple Variety: " + variety);
    }
}

// Test class
public class FruitAppleDemo {
    public static void main(String[] args) {
        // Create Apple object
        Apple myApple = new Apple("Red", "Sweet", "Fuji");

        // Display details
        myApple.showFruitDetails();   // from parent class
        myApple.showAppleDetails();   // from child class
    }
}
