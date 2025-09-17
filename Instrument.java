// Base class
class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println("Playing a generic instrument.");
    }
}

// Piano class
class Piano extends Instrument {
    private int keys;

    public Piano(String material, int keys) {
        super("Piano", material);
        this.keys = keys;
    }

    @Override
    public void play() {
        System.out.println("Playing the Piano with " + keys + " keys.");
    }
}

// Guitar class
class Guitar extends Instrument {
    private int strings;

    public Guitar(String material, int strings) {
        super("Guitar", material);
        this.strings = strings;
    }

    @Override
    public void play() {
        System.out.println("Strumming the Guitar with " + strings + " strings.");
    }
}

// Drum class
class Drum extends Instrument {
    private String type;

    public Drum(String material, String type) {
        super("Drum", material);
        this.type = type;
    }

    @Override
    public void play() {
        System.out.println("Beating the " + type + " Drum.");
    }
}

// Test class
public class InstrumentDemo {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Wood", 88),
            new Guitar("Metal", 6),
            new Drum("Leather", "Bass")
        };

        for (Instrument i : instruments) {
            i.play();
        }
    }
}
