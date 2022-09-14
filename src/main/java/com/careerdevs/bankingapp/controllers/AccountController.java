package com.careerdevs.bankingapp.controllers;

import com.careerdevs.bankingapp.models.AccountModel;
import com.careerdevs.bankingapp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/add")
    public ResponseEntity<?> createAccount(@RequestBody AccountModel newAccount) {
        try {
            AccountModel savedAccount = accountRepository.save(newAccount);
            return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAccounts() {
        try {
            Iterable<AccountModel> allAccounts = accountRepository.findAll();
            return new ResponseEntity<>(allAccounts, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable ("id") Long id) {
        try {
            AccountModel foundAccount = accountRepository.findById(id).get();
            return new ResponseEntity<>(foundAccount, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateAccount(@RequestBody AccountModel updatedAccount) {
        try {
            AccountModel updateAccount = accountRepository.save(updatedAccount);
            return new ResponseEntity<>(updateAccount, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAccounts() {
        try {
            long count = accountRepository.count();
            accountRepository.deleteAll();
            return new ResponseEntity("Deleted Users: " + count, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
        try {
            accountRepository.deleteById(id);
            return new ResponseEntity("Deleted User With ID: " + id, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
