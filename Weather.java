// Weather.java
class Weather {
    public Weather() {
        System.out.println("Weather: General conditions initialized.");
    }

    public void report() {
        System.out.println("Reporting general weather.");
    }
}

// Storm.java
class Storm extends Weather {
    public Storm() {
        super();
        System.out.println("Storm: Storm conditions initialized.");
    }

    @Override
    public void report() {
        System.out.println("Reporting stormy weather.");
    }
}

// Thunderstorm.java
class Thunderstorm extends Storm {
    public Thunderstorm() {
        super();
        System.out.println("Thunderstorm: Thunder and lightning initialized.");
    }

    @Override
    public void report() {
        System.out.println("Reporting thunderstorm conditions.");
    }
}

// Sunshine.java
class Sunshine extends Weather {
    public Sunshine() {
        super();
        System.out.println("Sunshine: Bright and clear initialized.");
    }

    @Override
    public void report() {
        System.out.println("Reporting sunny weather.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Polymorphic Reports ===");
        Weather w1 = new Thunderstorm();
        Weather w2 = new Sunshine();

        System.out.println("\nCalling report():");
        w1.report();  // Thunderstorm report
        w2.report();  // Sunshine report
    }
}
