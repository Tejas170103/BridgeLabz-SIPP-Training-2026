class BankAccount {

    int accountNumber;
    String holder;
    double balance;

    static int totalAccounts = 0;

    double overdraftLimit = 5000;


    // Constructor
    BankAccount(int accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;

        totalAccounts++;
    }


    // Deposit method
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited");
    }


    // Withdraw method
    void withdraw(double amount) {

        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn");
        }
        else {
            System.out.println("Withdrawal failed: Overdraft limit exceeded");
        }

    }


    // Statement
    void getStatement() {

        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------");
    }


}


public class Main {

    public static void main(String[] args) {


        BankAccount a1 = new BankAccount(101, "Rahul", 10000);
        BankAccount a2 = new BankAccount(102, "Aman", 5000);
        BankAccount a3 = new BankAccount(103, "Raj", 8000);


        // Account 1 - 5 transactions
        a1.deposit(2000);
        a1.withdraw(3000);
        a1.deposit(1000);
        a1.withdraw(5000);
        a1.deposit(500);


        // Account 2 - 5 transactions
        a2.deposit(3000);
        a2.withdraw(2000);
        a2.deposit(500);
        a2.withdraw(7000);
        a2.deposit(1000);


        // Account 3 - 5 transactions
        a3.withdraw(1000);
        a3.deposit(4000);
        a3.withdraw(3000);
        a3.deposit(2000);
        a3.withdraw(500);


        // Statements
        a1.getStatement();
        a2.getStatement();
        a3.getStatement();


        System.out.println("Total Accounts Created: " + BankAccount.totalAccounts);

    }
}