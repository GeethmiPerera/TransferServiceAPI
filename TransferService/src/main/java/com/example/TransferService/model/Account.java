package com.example.TransferService.model;

public class Account {
    private String accountNumber;
    private double balance;

    public Account() {}

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
   // Getters and Setters
    public String getAccountNumber() {
    	return accountNumber; 
    }
    public void setAccountNumber(String accountNumber) {
    	this.accountNumber = accountNumber; 
    }

    public double getBalance() {
        return balance; 
     }
    public void setBalance(double balance) { 
    	this.balance = balance; 
    }
}


