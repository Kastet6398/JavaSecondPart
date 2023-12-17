package auth;

import currency.BaseCurrency;
import fields.Date;

public final class BankAccount {
    private UserType owner;
    private double balance;
    private double interestRate;
    private double creditLimit;
    private double mustReturn;
    private Date mustReturnDate;
    // currency is the example of Strategy pattern: we don't use a concrete currency, like USD, UAH, but BaseCurrency
    private BaseCurrency currency;

    public UserType getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getMustReturn() {
        return mustReturn;
    }

    public Date getMustReturnDate() {
        return mustReturnDate;
    }

    public BaseCurrency getCurrency() {
        return currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMustReturn(double mustReturn) {
        this.mustReturn = mustReturn;
    }

    public void setCurrency(BaseCurrency currency) {
        this.currency = currency;
    }

    public void setMustReturnDate(Date mustReturnDate) {
        this.mustReturnDate = mustReturnDate;
    }

    public void setOwner(UserType owner) {
        this.owner = owner;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BankAccount(UserType owner, BaseCurrency currency, double balance, double interestRate, double creditLimit, Date mustReturnDate) {
        this.owner = owner;
        this.currency = currency;
        this.balance = balance;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        this.mustReturnDate = mustReturnDate;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayAccountInfo() {
        System.out.println(STR."Account owner: \{owner.userDetails()}");
        System.out.println(STR."Balance: \{balance} \{currency.getCode()}");
        System.out.println(STR."Must return (for money taken in credit): \{mustReturn} \{currency.getCode()} in \{mustReturnDate}");
    }

    public void convertBalance(BaseCurrency newCurrency) {
        balance *= currency.getExchangeRate() / newCurrency.getExchangeRate();
        currency = newCurrency;
    }

    public void takeInCredit(double amount) {
        if (amount <= creditLimit) {
            amount *= (1 + interestRate);
            if (balance >= mustReturn + amount) {
                balance += amount;
                mustReturn += amount;
            } else
                System.out.println("Insufficient funds!");
        } else {
            System.out.println("Credit limit exceeded!");
        }
    }
}
