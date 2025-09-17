// Base class
class Color {
    protected String name;

    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor called");
    }

    public void showColor() {
        System.out.println("Color: " + name);
    }
}

// Child class
class PrimaryColor extends Color {
    protected int intensity;

    public PrimaryColor(String name, int intensity) {
        super(name); // Calls Color constructor
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor called");
    }

    public void showPrimaryColor() {
        System.out.println("Primary Color: " + name + ", Intensity: " + intensity);
    }
}

// Grandchild class
class RedColor extends PrimaryColor {
    private String shade;

    public RedColor(String name, int intensity, String shade) {
        super(name, intensity); // Calls PrimaryColor constructor
        this.shade = shade;
        System.out.println("RedColor constructor called");
    }

    public void showRedColor() {
        System.out.println("Red Color: " + name + ", Intensity: " + intensity + ", Shade: " + shade);
    }
}

// Test class
public class ColorDemo {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 90, "Dark Red");
        red.showColor();
        red.showPrimaryColor();
        red.showRedColor();
    }
}
