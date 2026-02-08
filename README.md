# QuickBank Console

A console-based banking simulation built in Java. This is one of many programs I have programmed for practice to strengthen my Java fundamentals and object-oriented programming skills.

## Features

- Account creation with unique ID and initial balance
- Deposit funds
- Withdraw funds with insufficient balance protection
- View daily interest rate based on annual percentage
- View full account details including creation timestamp
- Input validation with error handling for invalid entries

## How to Run

1. Make sure you have Java installed (JDK 8 or higher).
2. Compile the source files:
   ```
   javac BankApplication.java CheckingAccount.java
   ```
3. Run the application:
   ```
   java BankApplication
   ```

## Usage

When the application starts, you will be prompted to:

1. Enter a unique account ID (minimum 4 characters)
2. Enter an initial balance (minimum $500)
3. Enter an annual interest rate as a percentage

After setup, the main menu provides the following options:

1. **Deposit** - Add funds to your account
2. **Withdraw** - Remove funds from your account
3. **View Interest Rate** - See your calculated daily interest
4. **View Account Details** - Display all account information
5. **Exit** - Close the application

## Project Structure

- `BankApplication.java` - Main application with user interface and menu logic
- `CheckingAccount.java` - Account model with balance management and interest calculation
