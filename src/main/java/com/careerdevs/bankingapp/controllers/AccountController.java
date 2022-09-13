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
    public ResponseEntity<AccountModel> createAccount(@RequestBody AccountModel newAccount) {
        AccountModel savedAccount = accountRepository.save(newAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AccountModel>> getAllAccounts() {
        Iterable<AccountModel> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AccountModel> getUserById(@PathVariable ("id") Long id) {
        AccountModel foundAccount = accountRepository.findById(id).get();
        return new ResponseEntity<>(foundAccount, HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<AccountModel> updateAccount(@RequestBody AccountModel updatedAccount) {
        AccountModel updateAccount = accountRepository.save(updatedAccount);
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<AccountModel> deleteAccounts() {
        long count = accountRepository.count();
        accountRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<AccountModel> deleteById(@PathVariable("id") long id) {
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
