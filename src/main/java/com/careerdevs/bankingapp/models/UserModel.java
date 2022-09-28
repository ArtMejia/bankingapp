package com.careerdevs.bankingapp.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class UserModel {

    // User should be linked to Checking and Savings accounts
    // User can have multiple accounts of each account type
    // Each account should only have one user/owner

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String phoneNum;
    private String address;

    @OneToMany(mappedBy = "accounts", fetch=FetchType.LAZY)
    @JsonIncludeProperties("accountNumber")
    private Set<AccountModel> accountModelSet;


    public UserModel() {
    }

    public UserModel(Long id, String name, int age, String phoneNum, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
