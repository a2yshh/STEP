// Base class
class Bird {
    public void fly() {
        System.out.println("Bird is flying...");
    }
}

// Penguin class overrides fly()
class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly, it swims instead!");
    }
}

// Eagle class overrides fly()
class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky!");
    }
}

// Test class
public class BirdDemo {
    public static void main(String[] args) {
        Bird[] birds = { new Bird(), new Penguin(), new Eagle() };

        // Polymorphism in action
        for (Bird b : birds) {
            b.fly();
        }
    }
}
