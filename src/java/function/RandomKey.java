/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class RandomKey {

    public static String randomKey() {
        String Char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numb = "0123456789";
        String str = Char + Numb;
        Random random = new Random();
        String Key = "";
        for (int i = 0; i < 8; i++) {
            int randnum = random.nextInt(str.length());
            Key = Key + str.charAt(randnum);
        }
        return Key;
    }
    
     public static String randomKey(int length) {
        String Char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numb = "0123456789";
        String str = Char + Numb;
        Random random = new Random();
        String Key = "";
        for (int i = 0; i < length; i++) { 
            int randnum = random.nextInt(str.length());
            Key = Key + str.charAt(randnum);
        }
        return Key;
    }
    
}
