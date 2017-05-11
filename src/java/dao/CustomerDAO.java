/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.Connect;
import function.MD5;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO {

    public static Customer checkLogin(String accountID, String password) {
        Customer customer = null;
        String sql = "SELECT * FROM Customer WHERE AccountID = ? AND Password = ?";
        Connection con = Connect.getConnect();
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, accountID);
            pr.setString(2, MD5.encryptMD5(password));
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setAccountID(new BigInteger(rs.getString("AccountID")));
                    String[] balance;
                    balance = rs.getString("Balance").split("\\.", 2);
                    System.out.println(balance[0]);
                    customer.setBalance(new BigInteger(balance[0]));
                }
            }
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            Connect.closeCon(con);
        }
        return customer;
    }

    public static BigInteger getBalanceByAccountID(String accountID) {
        String sql = "SELECT Balance FROM Customer WHERE AccountID = ?";
        BigInteger result = null;
        Connection con = Connect.getConnect();
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, accountID);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    String[] balance;
                    balance = rs.getString("Balance").split("\\.", 2);
                    result = new BigInteger(balance[0]);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Connect.closeCon(con);
        }
        return result;
    }

    public static boolean updateBalance(String accountID, BigInteger balance) {
        int result = 0;
        String sql = "UPDATE Customer SET Balance = ? WHERE AccountID = ?";
        Connection con = Connect.getConnect();
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, balance + "");
            pr.setString(2, accountID);
            result = pr.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Connect.closeCon(con);
        }
        return (result != 0);
    }

}
