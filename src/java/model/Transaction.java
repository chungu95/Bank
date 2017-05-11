/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Transaction implements Serializable{
    
    String transactionID;
    BigInteger amount;
    Date transactionDate;
    BigInteger remitterID;
    BigInteger receiverID;
    String transactionType;
    String orderID;

    public Transaction() {
    }
    
    public Transaction(String transactionID, BigInteger amount, Date transactionDate, BigInteger remitterID, BigInteger receiverID, String transactionType, String orderID) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.remitterID = remitterID;
        this.receiverID = receiverID;
        this.transactionType = transactionType;
        this.orderID = orderID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigInteger getRemitterID() {
        return remitterID;
    }

    public void setRemitterID(BigInteger remitterID) {
        this.remitterID = remitterID;
    }

    public BigInteger getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(BigInteger receiverID) {
        this.receiverID = receiverID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    
    
}
