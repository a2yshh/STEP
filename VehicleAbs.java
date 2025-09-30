// File: Vehicle.java
abstract class VehicleAbs {
    // Abstract method
    public abstract void start();

    // Non-abstract method
    public void fuelType() {
        System.out.println("Uses fuel");
    }
}

// File: Car.java
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts with key");
    }
}

// File: Bike.java
class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts with kick");
    }
}

// File: VehicleTest.java
public class VehicleTest {
    public static void main(String[] args) {
        // Vehicle reference to Car
        Vehicle v1 = new Car();
        v1.start();      // Calls Car's implementation
        v1.fuelType();   // Calls common method

        // Vehicle reference to Bike
        Vehicle v2 = new Bike();
        v2.start();      // Calls Bike's implementation
        v2.fuelType();   // Calls common method
    }
}

