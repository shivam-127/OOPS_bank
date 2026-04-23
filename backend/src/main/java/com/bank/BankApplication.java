package com.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.entity.BankAccount;
import com.bank.repository.BankAccountRepository;

@SpringBootApplication
public class BankApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
    
    // Initialize with sample data
    @Bean
    public CommandLineRunner init(BankAccountRepository repository) {
        return args -> {
            repository.save(new BankAccount("Account 1", 1000.0, 1111));
            repository.save(new BankAccount("Account 2", 5000.0, 2222));
            repository.save(new BankAccount("Account 3", 3000.0, 3333));
            
            System.out.println("Sample accounts created!");
        };
    }
}
