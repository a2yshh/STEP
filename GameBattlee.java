// File: GameBattle.java
abstract class Character {
    String name;
    public Character(String name) { this.name = name; }
    abstract void attack();
}

class Warrior extends Character {
    public Warrior(String name) { super(name); }
    void attack() { System.out.println(name + " swings a sword with high defense!"); }
}

class Mage extends Character {
    public Mage(String name) { super(name); }
    void attack() { System.out.println(name + " casts a powerful spell using mana!"); }
}

class Archer extends Character {
    public Archer(String name) { super(name); }
    void attack() { System.out.println(name + " shoots a long-range arrow!"); }
}

public class GameBattle {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior("Thor"),
            new Mage("Gandalf"),
            new Archer("Legolas")
        };

        for (Character c : army) {
            c.attack(); // Runtime decides which attack() runs
        }
    }
}
