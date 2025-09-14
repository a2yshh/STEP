class Book {
 String title, author, isbn;
 boolean isAvailable;
 Book() {}
 Book(String title, String author) {
 this.title = title;
 this.author = author;
 this.isAvailable = true;
 }
 Book(String title, String author, String isbn, boolean isAvailable) {
 this.title = title;
 this.author = author;
 this.isbn = isbn;
 this.isAvailable = isAvailable;
 }
 void borrowBook() {
 if (isAvailable) {
 isAvailable = false;
 System.out.println(title + " borrowed.");
 } else {
 System.out.println(title + " not available.");
 }
 }
 void returnBook() {
 isAvailable = true;
 System.out.println(title + " returned.");
 }
 void displayBookInfo() {
 System.out.println("Title: " + title +
 ", Author: " + author +
 ", ISBN: " + isbn +
 ", Available: " + isAvailable);
 }
 public static void main(String[] args) {
 Book b1 = new Book("1984", "Orwell");
 Book b2 = new Book("Sapiens", "Harari", "12345", true);
 b1.borrowBook();
 b1.displayBookInfo();
 b1.returnBook();
 b1.displayBookInfo();
 b2.displayBookInfo();
 }
}
