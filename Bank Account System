import java.util.Random;
class BankAccount {
 String accountHolder;
 int accountNumber;
 double balance;
 BankAccount() {
 this.balance = 0;
 }
 BankAccount(String accountHolder) {
 this.accountHolder = accountHolder;
 this.accountNumber = new Random().nextInt(10000);
 }
 BankAccount(String accountHolder, double balance) {
 this.accountHolder = accountHolder;
 this.accountNumber = new Random().nextInt(10000);
 this.balance = balance;
 }
 void deposit(double amount) {
 balance += amount;
 }
 void withdraw(double amount) {
 if (amount <= balance) balance -= amount;
 else System.out.println("Insufficient funds");
 }
 void displayAccount() {
 System.out.println("Account Holder: " + accountHolder +
 ", Account No: " + accountNumber +
 ", Balance: " + balance);
 }
 public static void main(String[] args) {
 BankAccount a1 = new BankAccount();
 BankAccount a2 = new BankAccount("Alice");
 BankAccount a3 = new BankAccount("Bob", 5000);
 a2.deposit(1000);
 a3.withdraw(2000);
 a1.displayAccount();
 a2.displayAccount();
 a3.displayAccount();
 }
}
