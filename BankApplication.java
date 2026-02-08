/**
 * BankApplication.java
 * Author: Aime Serge Tuyishime
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("_____________________________");
        System.out.println("    QUICKBANK CONSOLE APP    ");
        System.out.println("_____________________________");
        System.out.println();

        // Collect unique ID
        System.out.print("Enter unique ID: ");
        String uniqueID = scanner.nextLine();

        while (uniqueID.length() < 4) {
            System.out.println("ERROR: Unique ID must be at least 4 characters.");
            System.out.print("Enter unique ID: ");
            uniqueID = scanner.nextLine();
        }
        checkingAccount.setUniqueID(uniqueID);

        // Collect initial balance
        double acctBalance = readDouble(scanner, "Enter the initial balance: ");
        while (acctBalance < 500) {
            System.out.println("ERROR: New accounts require at least $500.");
            acctBalance = readDouble(scanner, "Enter the initial balance: ");
        }
        checkingAccount.setAcctBalance(acctBalance);

        // Collect annual interest rate
        double annualInterestRate = readDouble(scanner, "Enter annual interest rate as a percentage: ");
        while (annualInterestRate <= 0) {
            System.out.println("ERROR: Interest rate must be greater than 0.");
            annualInterestRate = readDouble(scanner, "Enter annual interest rate as a percentage: ");
        }
        checkingAccount.setAnnualInterestRate(annualInterestRate);

        // Main menu loop
        int option;
        do {
            System.out.println();
            System.out.println("____________________________");
            System.out.println("        MAIN MENU           ");
            System.out.println("____________________________");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Interest Rate");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.println();
            option = readInt(scanner, "Enter your selection: ");

            while (option < 1 || option > 5) {
                System.out.println("INVALID SELECTION - TRY AGAIN!");
                option = readInt(scanner, "Enter your selection: ");
            }

            switch (option) {
                case 1:
                    double deposit = readDouble(scanner, "Enter deposit amount: ");
                    while (deposit <= 0) {
                        System.out.println("ERROR: Deposit must be greater than $0.");
                        deposit = readDouble(scanner, "Enter deposit amount: ");
                    }
                    checkingAccount.depositCash(deposit);
                    System.out.printf("New Balance: $%.2f%n", checkingAccount.getAcctBalance());
                    break;

                case 2:
                    double withdrawal = readDouble(scanner, "Enter withdrawal amount: ");
                    while (withdrawal <= 0) {
                        System.out.println("ERROR: Withdrawal must be greater than $0.");
                        withdrawal = readDouble(scanner, "Enter withdrawal amount: ");
                    }
                    if (withdrawal > checkingAccount.getAcctBalance()) {
                        System.out.println("ERROR: Insufficient funds.");
                    } else {
                        checkingAccount.withdrawCash(withdrawal);
                        System.out.printf("New Balance: $%.2f%n", checkingAccount.getAcctBalance());
                    }
                    break;

                case 3:
                    double dailyRate = checkingAccount.getDailyIntRate(annualInterestRate);
                    System.out.printf("Your daily interest is: $%.2f%n", dailyRate);
                    break;

                case 4:
                    System.out.println("____________________________");
                    System.out.println("      ACCOUNT DETAILS       ");
                    System.out.println("____________________________");
                    System.out.println("Unique ID: " + checkingAccount.getUniqueID());
                    System.out.println("Created: " + checkingAccount.getCreatedDateTime());
                    System.out.printf("Balance: $%.2f%n", checkingAccount.getAcctBalance());
                    System.out.printf("Daily Interest: $%.2f%n", checkingAccount.getDailyIntRate(annualInterestRate));
                    break;

                case 5:
                    System.out.println("Thank you for using QuickBank. Goodbye!");
                    break;
            }
            System.out.println("____________________________");

        } while (option != 5);

        scanner.close();
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
