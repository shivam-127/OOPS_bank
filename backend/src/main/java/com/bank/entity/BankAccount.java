package com.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String accountName;
    
    @Column(nullable = false)
    private Double balance;
    
    @Column(nullable = false)
    private Integer pin;
    
    // Constructors
    public BankAccount() {}
    
    public BankAccount(String accountName, Double balance, Integer pin) {
        this.accountName = accountName;
        this.balance = balance;
        this.pin = pin;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public Double getBalance() {
        return balance;
    }
    
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public Integer getPin() {
        return pin;
    }
    
    public void setPin(Integer pin) {
        this.pin = pin;
    }
    
    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", pin=" + pin +
                '}';
    }
}
