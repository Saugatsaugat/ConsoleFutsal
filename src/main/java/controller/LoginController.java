/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entites.User;
import entites.UserCRUD;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class LoginController {

    public List<String> getLoginInformation() {
        List<String> loginInformation = new ArrayList<>();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Username: ");
            String username = sc.next();
            System.out.println("Enter Password: ");
            String password = sc.next();
            loginInformation.add(username);
            loginInformation.add(password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return loginInformation;
    }

    /////////////////////
    public boolean verifylogin(String username, String password) {
        User user = UserCRUD.obj.getDataByEmail(username);
        password = new PasswordHashController().getPasswordHash(password);
        if((user.getEmail().equals(username)) && (user.getPassword().equals(password))){
              return true;
        }
        return false;
        }

}
