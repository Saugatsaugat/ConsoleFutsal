package com.mycompany.consolefutsal;

import controller.AdminController;
import controller.LoginController;
import controller.RegisterController;
import entites.User;
import entites.UserCRUD;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class ConsoleFutsal {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************\n\n");
        System.out.println("!!! WELCOME TO  FUTSAL !!!\n\n");
        System.out.println("*******************************\n");
        while (flag) {
            System.out.println("\nWhat do you want?\n1.Register\n2.Login\n3.Exit\nSelect: ");
            try {
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        new RegisterController().makeRegistration();
                        break;
                    case 2:
                        List<String> loginInformation = new ArrayList<>();
                        loginInformation = new LoginController().getLoginInformation();
                        String username = loginInformation.get(0);
                        String password = loginInformation.get(1);
                        username = username.toLowerCase();
                        boolean status = new LoginController().verifylogin(username, password);
                        if (status) {
                            User user = new UserCRUD().getDataByEmail(username);
                            String type = user.getType();
                            if ("admin".equals(type)) {
                                new AdminController().adminPage(user);
                            }
                        } else {
                            System.out.println("Invalid Credentials");
                        }

                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
