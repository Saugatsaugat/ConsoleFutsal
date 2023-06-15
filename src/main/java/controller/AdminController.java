/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entites.User;
import entites.UserCRUD;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class AdminController {

    public void adminPage(User user) {
        boolean flag = true;
        String firstname = user.getFirstname();
        String midname = user.getMidname();
        String lastname = user.getLastname();
        String name = null;
        if (midname == null) {
            name = firstname + " " + lastname;
        } else {
            name = firstname + " " + midname + " " + lastname;
        }
        System.out.println("**************************\n");
        System.out.println("  ADMIN PAGE   \n");
        System.out.println("**************************\n");
        System.out.println("Welcome Admin: " + name);
        while (flag) {
            System.out.println("\nAdmin Panel Options\n1.Manage Users\n2.Manage Futsals\n3.Logout\nSelect:");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }

        }
    }

    public void manageUsers() {
        List<User> userList = new UserCRUD().getUserList();
        System.out.println("ID\tType\tFirstname\tMidName\tLastName\t\tEmail\t\t\tMobile");
        for (User user : userList) {
            BigDecimal id = user.getId();
            String type = user.getType();
            String firstname = user.getFirstname();
            String midname = user.getMidname();
            String lastname = user.getLastname();
            String email = user.getEmail();
            BigInteger mobile = user.getMobile();
            if (midname != null) {
                System.out.println(id + "\t" + type + "\t" + firstname + "\t\t" + midname + "\t" + lastname + "\t\t\t" + email + "\t" + mobile);

            } else {
                System.out.println(id + "\t" + type + "\t" + firstname + "\t\t" + lastname + "\t\t" + email + "\t\t\t" + mobile);

            }

        }
        System.out.println("\nNote: Please use email for EDIT and DELTE");
        System.out.print("\nAvailable Operations\n1.Edit User\n2.Delete User\n3.Exit\nSelect:");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:

                break;
            case 2:
                new AdminController().removeUser();

                break;
            case 3:
                break;
            default:
                break;
        }

    }
public void removeUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the email of the user to delete:\n");
        String email = sc.next();
        if (new UserCRUD().deleteDataByEmail(email)) {
            System.out.println("Deleted Successfully");
            manageUsers();
        } else {
            System.out.println("Something went wrong");

        }
    }
}
