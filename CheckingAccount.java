/**
 * CheckingAccount.java
 * Author: Aime Serge Tuyishime
 */

import java.util.Date;

public class CheckingAccount {

    private String uniqueID;
    private double acctBalance;
    private double annualInterestRate;
    private Date createdDateTime;

    public CheckingAccount() {
        this.createdDateTime = new Date(System.currentTimeMillis());
    }

    public CheckingAccount(double initialBalance, String uniqueID, double annualInterestRate) {
        this.uniqueID = uniqueID;
        this.acctBalance = initialBalance;
        this.annualInterestRate = annualInterestRate;
        this.createdDateTime = new Date(System.currentTimeMillis());
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(double balance) {
        this.acctBalance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public double getDailyIntRate(double annualIntRate) {
        double dailyInterestRate = (this.acctBalance * annualIntRate / 36500);
        dailyInterestRate = Math.round(dailyInterestRate * 100.0) / 100.0;
        return dailyInterestRate;
    }

    public double depositCash(double deposit) {
        this.acctBalance += deposit;
        return this.acctBalance;
    }

    public double withdrawCash(double amount) {
        this.acctBalance -= amount;
        return this.acctBalance;
    }

    @Override
    public String toString() {
        return "CheckingAccount [uniqueID=" + uniqueID + ", acctBalance=" + acctBalance
                + ", annualInterestRate=" + annualInterestRate + ", createdDateTime=" + createdDateTime + "]";
    }
}
