/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.security.MessageDigest;

/**
 *
 * @author saugat
 */
public class PasswordHashController {
    public String getPasswordHash(String password) {
        MessageDigest messageDigest;
        String stringHash=null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            stringHash = new String(messageDigest.digest());
            return stringHash;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return stringHash;

    }

}
