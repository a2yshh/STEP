package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(1, "X", 1.1, true);

        // System.out.println(obj.privateField);   // ERROR
        // System.out.println(obj.defaultField);   // ERROR
        // System.out.println(obj.protectedField); // ERROR
        System.out.println(obj.publicField);      // OK

        // obj.privateMethod();   // ERROR
        // obj.defaultMethod();   // ERROR
        // obj.protectedMethod(); // ERROR
        obj.publicMethod();       // OK
    }
}

package com.company.extended;

import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int privateField, String defaultField,
                        double protectedField, boolean publicField) {
        super(privateField, defaultField, protectedField, publicField);
    }

    public void testInheritedAccess() {
        // System.out.println(privateField); // ERROR
        // System.out.println(defaultField); // ERROR
        System.out.println(protectedField); // OK
        System.out.println(publicField);    // OK

        // privateMethod();  // ERROR
        // defaultMethod();  // ERROR
        protectedMethod();  // OK
        publicMethod();     // OK
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in ExtendedDemo");
    }

    public static void main(String[] args) {
        AccessModifierDemo parent = new AccessModifierDemo(2, "Parent", 22.2, true);
        ExtendedDemo child = new ExtendedDemo(3, "Child", 33.3, false);

        parent.publicMethod();
        // parent.protectedMethod(); // ERROR

        child.publicMethod();
        child.protectedMethod();
        child.testInheritedAccess();
    }
}


