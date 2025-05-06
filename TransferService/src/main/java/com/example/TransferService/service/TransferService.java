package com.example.TransferService.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.TransferService.model.Account;



@Service
public class TransferService {
	private final Map<String, Account> accounts = new HashMap<>();

    public TransferService() {
        accounts.put("123", new Account("123", 1000.0));
        accounts.put("456", new Account("456", 500.0));
        accounts.put("789", new Account("789", 2000.0));
    }

    public String transfer(String source, String destination, double amount) {
        if (!accounts.containsKey(source) || !accounts.containsKey(destination)) {
            return "One or both accounts not found.";
        }

        Account src = accounts.get(source);
        Account dest = accounts.get(destination);

        if (src.getBalance() < amount) {
            return "Insufficient balance.";
        }

        src.setBalance(src.getBalance() - amount);
        dest.setBalance(dest.getBalance() + amount);

        return "Transfer successful.";
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}


