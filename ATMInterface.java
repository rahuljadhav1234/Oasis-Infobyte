import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class ATM {
    private double balance;
    private String userId;
    private String pin;
    private ArrayList<String> transactionHistory;

    public ATM(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String enteredUserId, String enteredPin) {
        return this.userId.equals(enteredUserId) && this.pin.equals(enteredPin);
    }

    public void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction History");
        System.out.println("5. Quit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: $" + amount + " on " + new Date());
        System.out.println("$" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount + " on " + new Date());
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM("123456", "7890");

        System.out.println("Enter user ID:");
        String enteredUserId = scanner.nextLine();
        System.out.println("Enter PIN:");
        String enteredPin = scanner.nextLine();

        if (atm.authenticate(enteredUserId, enteredPin)) {
            System.out.println("Authentication successful!");
            boolean exit = false;

            while (!exit) {
                atm.showMenu();
                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();
                double amount;

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter deposit amount:");
                        amount = scanner.nextDouble();
                        atm.deposit(amount);
                        break;
                    case 3:
                        System.out.println("Enter withdrawal amount:");
                        amount = scanner.nextDouble();
                        atm.withdraw(amount);
                        break;
                    case 4:
                        atm.showTransactionHistory();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }
}
