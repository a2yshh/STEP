// Parent class
class Tool {
    private String privateTool = "Private Tool";
    protected String protectedTool = "Protected Tool";
    public String publicTool = "Public Tool";

    // Getter for private field
    public String getPrivateTool() {
        return privateTool;
    }
}

// Child class
class Hammer extends Tool {

    public void testAccess() {
        // System.out.println(privateTool); // ❌ Not accessible - private
        System.out.println("Private Tool (via getter): " + getPrivateTool()); // ✅

        System.out.println("Protected Tool: " + protectedTool); // ✅ Accessible
        System.out.println("Public Tool: " + publicTool);       // ✅ Accessible
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        Hammer hammer = new Hammer();
        hammer.testAccess();
    }
}
