// File: LibrarySystem.java
class LibraryUser {
    String name;
    public LibraryUser(String name) { this.name = name; }
    void access() { System.out.println(name + " can enter the library."); }
}

class Student extends LibraryUser {
    public Student(String name) { super(name); }
    void access() { System.out.println(name + " borrows books and uses computers."); }
}

class Faculty extends LibraryUser {
    public Faculty(String name) { super(name); }
    void access() { System.out.println(name + " reserves books and accesses research databases."); }
}

class Guest extends LibraryUser {
    public Guest(String name) { super(name); }
    void access() { System.out.println(name + " can only browse books."); }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryUser u1 = new Student("Alice");
        LibraryUser u2 = new Faculty("Dr. Bob");
        LibraryUser u3 = new Guest("Charlie");

        u1.access();
        u2.access();
        u3.access();
    }
}

