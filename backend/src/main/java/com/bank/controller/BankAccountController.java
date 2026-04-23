package com.bank.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.BankAccount;
import com.bank.service.BankAccountService;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class BankAccountController {
    
    @Autowired
    private BankAccountService service;
    
    // Create a new account
    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account) {
        BankAccount created = service.createAccount(account);
        return ResponseEntity.ok(created);
    }
    
    // Get all accounts
    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllAccounts() {
        List<BankAccount> accounts = service.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    
    // Get account by ID
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable Long id) {
        Optional<BankAccount> account = service.getAccountById(id);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Deposit money
    @PostMapping("/{id}/deposit")
    public ResponseEntity<?> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        try {
            Double amount = request.get("amount");
            BankAccount updated = service.deposit(id, amount);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    // Withdraw money
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        try {
            Double amount = Double.parseDouble(request.get("amount").toString());
            Integer pin = Integer.parseInt(request.get("pin").toString());
            BankAccount updated = service.withdraw(id, amount, pin);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    // Change PIN
    @PostMapping("/{id}/change-pin")
    public ResponseEntity<?> changePin(@PathVariable Long id, @RequestBody Map<String, Integer> request) {
        try {
            Integer oldPin = request.get("oldPin");
            Integer newPin = request.get("newPin");
            BankAccount updated = service.changePin(id, oldPin, newPin);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
