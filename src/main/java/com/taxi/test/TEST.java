/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxi.test;

import com.taxi.util.AESCrypt;

/**
 *
 * @author santopat
 */
public class TEST {

    public static void main(String[] args) throws java.lang.Exception {
        /* System.out.println("com.taxi.test.TEST.main()" + new Date());
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
        System.out.println("ourJavaTimestampObject {}" + ourJavaTimestampObject);*/
        try {
            String password = "KumarPatil";
            System.out.println("plain pass=" + password);
            String encryptedPassword = AESCrypt.encrypt(password);
            System.out.println("encrypted pass=" + encryptedPassword);
            String decryptedPassword = AESCrypt.decrypt(encryptedPassword);
            System.out.println("decrypted pass=" + decryptedPassword);
        } catch (Exception e) {
            System.out.println("bug" + e.getMessage());
        }
    }
}
