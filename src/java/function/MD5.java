/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ADMIN
 */
public class MD5 {

    /**
     * @param input
     * @return 
     */
    public static String encryptMD5(String input) {
        MessageDigest MD;
        byte[] messageDigest;
        BigInteger number;
        String outPut = null;
        try {
            MD = MessageDigest.getInstance("MD5");
            messageDigest = MD.digest(input.getBytes());
            number = new BigInteger(1, messageDigest);
            outPut = number.toString(16);
            while (outPut.length() < 32) {
                outPut = "0" + outPut;
            }
        } catch (NoSuchAlgorithmException ex) {
        }
        return outPut;
    }
    
}
