/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author ADMIN
 */
public class Customer implements Serializable{
    
    BigInteger accountID;
    String customerName;
    BigInteger passport;
    String address;
    String email;
    String phoneNumber;
    BigInteger balance;
    String password;

    public Customer() {
    }

    public Customer(BigInteger accountID, String customerName, BigInteger passport, String address, String email, String phoneNumber, BigInteger balance, String password) {
        this.accountID = accountID;
        this.customerName = customerName;
        this.passport = passport;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.password = password;
    }

    public BigInteger getAccountID() {
        return accountID;
    }

    public void setAccountID(BigInteger accountID) {
        this.accountID = accountID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigInteger getPassport() {
        return passport;
    }

    public void setPassport(BigInteger passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
