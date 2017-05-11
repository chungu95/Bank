/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.Connect;
import function.DateConverter;
import function.RandomKey;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Transaction;

public class TransactionDAO {

    public static boolean insertTransation(Transaction transaction) {
        int result = 0;
        Connection con = Connect.getConnect();
        String sql = "INSERT INTO Deal (TransactionID,Amount,TransactionDate,RemitterID,ReceiverID,TransactionType,OrderID) VALUES (?,?,?,?,?,?,?);";
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, transaction.getTransactionID());
            pr.setString(2, transaction.getAmount() + "");
            pr.setDate(3, transaction.getTransactionDate());
            pr.setString(4, transaction.getRemitterID() + "");
            pr.setString(5, transaction.getReceiverID() + "");
            pr.setString(6, transaction.getTransactionType());
            pr.setString(7, transaction.getOrderID());
            result = pr.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            Connect.closeCon(con);
        }
        return (result != 0);
    }

    public static String transaction(String remitterID, String receiverID, BigInteger amount, String orderID) {
        String result = orderID;
        Transaction transaction = new Transaction();
        transaction.setOrderID(orderID);
        transaction.setTransactionID(RandomKey.randomKey());
        transaction.setTransactionDate(DateConverter.getCurrentDate());
        transaction.setTransactionType("payment");
        transaction.setReceiverID(new BigInteger(receiverID));
        transaction.setRemitterID(new BigInteger(remitterID));
        transaction.setAmount(amount);
        BigInteger remitterBalance = CustomerDAO.getBalanceByAccountID(remitterID);
        if (remitterBalance.intValue() >= amount.intValue()) {
            BigInteger receiverBalance = CustomerDAO.getBalanceByAccountID(receiverID);
            receiverBalance = receiverBalance.add(amount);
            remitterBalance = remitterBalance.subtract(amount);
            if (!CustomerDAO.updateBalance(remitterID, remitterBalance) || !CustomerDAO.updateBalance(receiverID, receiverBalance)) {
                result = "Có lỗi xảy ra";
            }
        } else {
            result = "Số dư không đủ";
        }
        TransactionDAO.insertTransation(transaction);
        return result;
    }

    public static void main(String[] args) {
        
    }
}
