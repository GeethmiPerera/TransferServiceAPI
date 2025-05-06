package com.example.TransferService.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.TransferService.model.Account;

@Service
public class TransferService {
	private final Map<String, Account> accounts = new HashMap<>();

	// Initialize with sample accounts.
	public TransferService() {
        accounts.put("123", new Account("123", 1500.0));
        accounts.put("4565", new Account("4565", 5050.0));
        accounts.put("1891", new Account("1891", 2020.0));
    }

    public String transfer(String source, String destination, double amount) {
        if (amount <= 0) {
            return "Amount must be positive.";
        }
        if (source.equals(destination)) {
            return "Source and destination accounts must be different.";
        }

        Account src = accounts.get(source);
        Account desti = accounts.get(destination);

        if (src == null || desti == null) {
            return "Accounts not found.";
        }

        synchronized (src) { 
            if (src.getBalance() < amount) {
                return "Insufficient balance.";
            }
            src.setBalance(src.getBalance() - amount);
            desti.setBalance(desti.getBalance() + amount);
        }

        return "Transfer successful.";
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}


