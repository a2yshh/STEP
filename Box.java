// Base class
class Box {
    public void pack() {
        System.out.println("Packing the box...");
    }

    public void unpack() {
        System.out.println("Unpacking the box...");
    }
}

// Child class
class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack(); // Call parent method first
        System.out.println("Adding ribbon and decoration for the gift!");
    }

    @Override
    public void unpack() {
        super.unpack(); // Call parent method first
        System.out.println("Unwrapping the ribbon and gift wrap.");
    }
}

// Test class
public class BoxDemo {
    public static void main(String[] args) {
        GiftBox gbox = new GiftBox();
        gbox.pack();
        gbox.unpack();
    }
}
