public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return isLocked ? -1 : balance; }
    public boolean isAccountLocked() { return isLocked; }

    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) this.pin = newPin;
        else System.out.println("Wrong old PIN!");
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
        }
    }

    public void deposit(double amount, int pin) {
        if (validatePin(pin)) balance += amount;
    }

    public void withdraw(double amount, int pin) {
        if (validatePin(pin) && balance >= amount) balance -= amount;
        else System.out.println("Withdrawal failed!");
    }

    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin) && balance >= amount) {
            balance -= amount;
            target.balance += amount;
        }
    }

    private void lockAccount() { isLocked = true; }
    private void resetFailedAttempts() { failedAttempts = 0; }
    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) lockAccount();
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("A123", 500);
        SecureBankAccount acc2 = new SecureBankAccount("B456", 100);

        acc1.setPin(0, 1234);
        acc2.setPin(0, 9999);

        acc1.deposit(200, 1234);
        acc1.withdraw(100, 1234);
        acc1.transfer(acc2, 50, 1234);

        System.out.println("Acc1 balance: " + acc1.getBalance());
        System.out.println("Acc2 balance: " + acc2.getBalance());

        acc1.withdraw(50, 1111);
        acc1.withdraw(50, 1111);
        acc1.withdraw(50, 1111);

        System.out.println("Acc1 locked: " + acc1.isAccountLocked());
    }
}
