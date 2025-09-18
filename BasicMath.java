// BasicMath.java
class BasicMath {
    public int calculate(int a, int b) {
        return a + b;
    }

    public double calculate(double a, double b) {
        return a + b;
    }

    public int calculate(int a) {
        return a * a;
    }
}

// AdvancedMath.java
class AdvancedMath extends BasicMath {
    public double calculate(double a, double b, double c) {
        return a + b + c;
    }

    public int calculate(int a, int b, int c) {
        return a * b * c;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();

        System.out.println("Sum (int): " + math.calculate(3, 4));
        System.out.println("Sum (double): " + math.calculate(2.5, 3.5));
        System.out.println("Square (int): " + math.calculate(5));
        System.out.println("Product (int, 3 args): " + math.calculate(2, 3, 4));
        System.out.println("Sum (double, 3 args): " + math.calculate(1.1, 2.2, 3.3));
    }
}
