// File: MultilevelInheritanceDemo.java

// ==================== Base Class ====================
class Animal {
    // Protected fields
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    // Constructor
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    // Methods
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
               ", Lifespan: " + lifespan + " years, Wildlife: " + isWildlife;
    }
}

// ==================== Intermediate Class ====================
class Mammal extends Animal {
    // Mammal-specific fields
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod; // in days

    // Constructor
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true; // always true for mammals
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    // Overriding move
    @Override
    public void move() {
        super.move(); // parent version
        System.out.println("Mammal is walking/running");
    }

    // Mammal-specific methods
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

// ==================== Specific Class ====================
class Dog extends Mammal {
    // Dog-specific fields
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel; // 1-10
    private String favoriteActivity;

    // Constructor 1: Basic dog with minimal parameters
    public Dog() {
        super("Dog", "Domestic", 13, false, "Varies", 63);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 5;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating basic dog");
    }

    // Constructor 2: Detailed dog with all parameters
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog constructor: Copying dog " + other.breed);
    }

    // Overridden methods
    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    // Dog-specific methods
    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty Level: " + loyaltyLevel + "/10");
    }

    // Demonstrating full inheritance chain
    public void demonstrateInheritance() {
        System.out.println("\n--- Demonstrating Inheritance Chain ---");
        eat();   // overridden
        move();  // overridden
        sleep(); // overridden
        nurse(); // Mammal
        regulateTemperature(); // Mammal
        System.out.println(getAnimalInfo()); // Animal
    }

    // Main method
    public static void main(String[] args) {
        // 1. Test constructor chaining
        System.out.println("=== Basic Dog Constructor ===");
        Dog dog1 = new Dog();

        System.out.println("\n=== Detailed Dog Constructor ===");
        Dog dog2 = new Dog("Dog", "Domestic", 12, false,
                           "Brown", 65, "Labrador", true, 9, "Swimming");

        System.out.println("\n=== Copy Constructor ===");
        Dog dog3 = new Dog(dog2);

        // 2. Test method overriding
        System.out.println("\n=== Method Overriding ===");
        dog2.eat();
        dog2.move();
        dog2.sleep();

        // 3. Access inherited members
        System.out.println("\n=== Inherited Members ===");
        System.out.println("Species: " + dog2.species);
        System.out.println("Fur Color: " + dog2.furColor);

        // 4. Demonstrate full inheritance chain
        dog2.demonstrateInheritance();

        // 5. Dog-specific methods
        System.out.println("\n=== Dog-specific Methods ===");
        dog2.bark();
        dog2.fetch();
        dog2.showLoyalty();

        // 6. instanceof checks
        System.out.println("\n=== instanceof Checks ===");
        System.out.println("dog2 instanceof Dog: " + (dog2 instanceof Dog));
        System.out.println("dog2 instanceof Mammal: " + (dog2 instanceof Mammal));
        System.out.println("dog2 instanceof Animal: " + (dog2 instanceof Animal));
    }
}
