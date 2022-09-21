package com.careerdevs.bankingapp.controllers;

import com.careerdevs.bankingapp.models.UserModel;
import com.careerdevs.bankingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody UserModel newAccount) {
        try {
            UserModel savedAccount = userRepository.save(newAccount);
            return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser() {
        try {
            Iterable<UserModel> allAccounts = userRepository.findAll();
            return new ResponseEntity<>(allAccounts, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable ("id") Long id) {
        try {
            UserModel foundAccount = userRepository.findById(id).get();
//            if (foundAccount.isEmpty()) return ResponseEntity.status(404).body("User Not Found With ID: " + id);
            return new ResponseEntity<>(foundAccount, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UserModel updatedAccount) {
        try {
            UserModel updateAccount = userRepository.save(updatedAccount);
            return new ResponseEntity<>(updateAccount, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteUser() {
        try {
            long count = userRepository.count();
            userRepository.deleteAll();
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
            userRepository.deleteById(id);
            return new ResponseEntity("Deleted User With ID: " + id, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
