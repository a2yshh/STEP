package com.company.security;

public class AccessModifierDemo {
    // Fields with different access levels
    private int privateField;        // Only within this class
    String defaultField;             // Package-private (default)
    protected double protectedField; // Package + subclasses
    public boolean publicField;      // Accessible everywhere

    // Constructor to initialize fields
    public AccessModifierDemo(int privateField, String defaultField,
                              double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    // Methods with different access levels
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Demonstrate internal access
    public void testInternalAccess() {
        System.out.println("PrivateField: " + privateField);
        System.out.println("DefaultField: " + defaultField);
        System.out.println("ProtectedField: " + protectedField);
        System.out.println("PublicField: " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 99.5, true);

        // Accessible here
        // obj.privateField; ❌ ERROR - not accessible outside class
        System.out.println(obj.defaultField);   // ✅ same package
        System.out.println(obj.protectedField); // ✅ same package
        System.out.println(obj.publicField);    // ✅ everywhere

        // obj.privateMethod(); ❌ ERROR
        obj.defaultMethod();   // ✅
        obj.protectedMethod(); // ✅
        obj.publicMethod();    // ✅

        obj.testInternalAccess(); // Shows all
    }
}

// Another class in SAME package
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(5, "World", 55.5, false);

        // System.out.println(obj.privateField); ❌ private not accessible
        System.out.println(obj.defaultField);   // ✅ same package
        System.out.println(obj.protectedField); // ✅ same package
        System.out.println(obj.publicField);    // ✅ everywhere

        // obj.privateMethod(); ❌
        obj.defaultMethod();   // ✅
        obj.protectedMethod(); // ✅
        obj.publicMethod();    // ✅
    }
}
