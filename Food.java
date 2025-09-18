// Food.java
abstract class Food {
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

// Pizza.java
class Pizza extends Food {
    protected void wash() {
        System.out.println("Washing vegetables for pizza.");
    }

    protected void cook() {
        System.out.println("Baking pizza in oven.");
    }

    protected void serve() {
        System.out.println("Serving hot pizza with cheese.");
    }
}

// Soup.java
class Soup extends Food {
    protected void wash() {
        System.out.println("Washing ingredients for soup.");
    }

    protected void cook() {
        System.out.println("Boiling soup ingredients.");
    }

    protected void serve() {
        System.out.println("Serving soup in a bowl.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        System.out.println("Preparing Pizza:");
        pizza.prepare();

        System.out.println("\nPreparing Soup:");
        Food soup = new Soup();
        soup.prepare();
    }
}
