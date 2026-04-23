package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.BankAccount;
import com.bank.repository.BankAccountRepository;

@Service
public class BankAccountService {
    
    @Autowired
    private BankAccountRepository repository;
    
    // Create account
    public BankAccount createAccount(BankAccount account) {
        return repository.save(account);
    }
    
    // Get all accounts
    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }
    
    // Get account by id
    public Optional<BankAccount> getAccountById(Long id) {
        return repository.findById(id);
    }
    
    // Deposit (synchronized)
    public synchronized BankAccount deposit(Long id, Double amount) {
        Optional<BankAccount> account = repository.findById(id);
        if (account.isPresent()) {
            BankAccount acc = account.get();
            acc.setBalance(acc.getBalance() + amount);
            System.out.println("Deposited: " + amount + " | New Balance: " + acc.getBalance());
            return repository.save(acc);
        }
        return null;
    }
    
    // Withdraw (synchronized)
    public synchronized BankAccount withdraw(Long id, Double amount, Integer enteredPin) {
        Optional<BankAccount> account = repository.findById(id);
        if (account.isPresent()) {
            BankAccount acc = account.get();
            
            if (!acc.getPin().equals(enteredPin)) {
                System.out.println("Wrong PIN!");
                throw new RuntimeException("Wrong PIN!");
            }
            
            if (amount > acc.getBalance()) {
                System.out.println("Insufficient Balance!");
                throw new RuntimeException("Insufficient Balance!");
            }
            
            acc.setBalance(acc.getBalance() - amount);
            System.out.println("Withdrawn: " + amount + " | New Balance: " + acc.getBalance());
            return repository.save(acc);
        }
        return null;
    }
    
    // Change PIN (synchronized)
    public synchronized BankAccount changePin(Long id, Integer oldPin, Integer newPin) {
        Optional<BankAccount> account = repository.findById(id);
        if (account.isPresent()) {
            BankAccount acc = account.get();
            
            if (!acc.getPin().equals(oldPin)) {
                System.out.println("Wrong old PIN!");
                throw new RuntimeException("Wrong old PIN!");
            }
            
            acc.setPin(newPin);
            System.out.println("PIN changed successfully!");
            return repository.save(acc);
        }
        return null;
    }
}
