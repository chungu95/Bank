/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import dao.CustomerDAO;
import dao.TransactionDAO;

import java.math.BigInteger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ADMIN
 */
@WebService(serviceName = "Payment")
public class Payment {

    @WebMethod(operationName = "payment")
    public String payment(@WebParam(name = "remitterID") String remitterID,
            @WebParam(name = "receiverID") String receiverID, @WebParam(name = "amount") BigInteger amount, @WebParam(name = "orderID") String orderID, @WebParam(name = "password") String password) {
        if (CustomerDAO.checkLogin(remitterID, password) != null) {
            return TransactionDAO.transaction(remitterID, receiverID, amount, orderID);
        } else {
            return "Số tài khoản hoặc mật khẩu không đúng!";
        }
    }
}
