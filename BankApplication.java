import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name = sc.nextLine();
        String customerId = sc.nextLine();
        BankAccount obj1 = new BankAccount(name, customerId);
        obj1.menu();
    }
}

class BankAccount {
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if (amount != 0) {
            bal += amount;
            prevTrans = amount;
        }
    }

    void withdraw(double amount) {
        if (amount != 0) {
            bal -= amount;
            prevTrans = -amount;
        }
    }

    void getPreviousTransaction() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrawn: " + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    void menu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("====================================");
            System.out.println("Enter an option");
            System.out.println("====================================");
            option = sc.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("------------------------------------");
                    System.out.println("Balance = " + bal);
                    System.out.println("------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("------------------------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("------------------------------------");
                    double amount = sc.nextDouble();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("------------------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("------------------------------------");
                    double amount2 = sc.nextDouble();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("------------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("************");
                    break;

                default:
                    System.out.println("Invalid option! Please enter again.");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for using our services!");
    }
}
