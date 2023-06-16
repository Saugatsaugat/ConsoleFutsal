/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entites.Futsal;
import entites.FutsalCRUD;
import entites.User;
import entites.UserCRUD;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import repository.CRUDRepo;

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
                    manageFutsals();
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
        List<User> userList = UserCRUD.obj.getAllData();
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
        System.out.println("\nNote: Please use id for EDIT and DELTE");
        System.out.print("\nAvailable Operations\n1.Edit User\n2.Delete User\n3.Go Back\nSelect:");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                new AdminController().editUser();
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
        System.out.println("Enter the id of the user to delete:\n");
        BigDecimal id = sc.nextBigDecimal();
        if (UserCRUD.obj.deleteById(id)) {
            System.out.println("Deleted Successfully");
            manageUsers();
        } else {
            System.out.println("Something went wrong");

        }
    }

 public void editUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id you want to edit:\n");
        BigDecimal id1 = sc.nextBigDecimal();
        User user = UserCRUD.obj.getDataById(id1);
        System.out.println(user);

        BigDecimal id = user.getId();
        String type = user.getType();
        String firstname = user.getFirstname();
        String midname = user.getMidname();
        String lastname = user.getLastname();
        String email = user.getEmail();
        String oldEmail = email;
        BigInteger mobile = user.getMobile();

        System.out.println("Update the details");
        System.out.println("Edit firstname? Y/N");
        String input1 = sc.next();
        sc.nextLine();
        char char1 = input1.charAt(0);
        if (char1 == 'Y' || char1 == 'y') {
            System.out.println("Enter firstname:");
            firstname = sc.next();
            sc.nextLine();
        }

        System.out.println("Edit midname? Y/N");
        String input2 = sc.next();
        sc.nextLine();
        char char2 = input2.charAt(0);
        if (char2 == 'Y' || char2 == 'y') {
            System.out.println("Enter midname:");
            midname = sc.next();
            sc.nextLine();
        }

        System.out.println("Edit lastname? Y/N");
        String input3 = sc.next();
        sc.nextLine();
        char char3 = input3.charAt(0);
        if (char3 == 'Y' || char3 == 'y') {
            System.out.println("Enter lastname:");
            lastname = sc.next();
            sc.nextLine();
        }
        System.out.println("Edit email? Y/N");
        String input4 = sc.next();
        char char4 = input4.charAt(0);
        if (char4 == 'Y' || char4 == 'y') {
            System.out.println("Enter email:");
            email = sc.next();
            sc.nextLine();
        }

        System.out.println("Edit mobile? Y/N");
        String input5 = sc.next();
        sc.nextLine();
        char char5 = input5.charAt(0);
        if (char5 == 'Y' || char5 == 'y') {
            System.out.println("Enter mobile:");
            mobile = sc.nextBigInteger();
            sc.nextLine();
        }

        User newUser = new User();
        newUser.setId(id);
        newUser.setType(type);
        newUser.setFirstname(firstname);
        newUser.setMidname(midname);
        newUser.setLastname(lastname);
        newUser.setMobile(mobile);
        newUser.setPassword(user.getPassword());
        newUser.setEmail(email);


        if (UserCRUD.obj.deleteById(id)) {
           
            if (UserCRUD.obj.create(newUser)) {
                System.out.println("Updated Successfully");

            } else {
                System.out.println("Can not be updated");
            }
        } else {
            System.out.println("Something went wrong");

        }

    }
 
 
 public void manageFutsals(){
     System.out.println("Id\tpan\tName\t\tAddress\tmobile\trate\tOwnerId\n");
     List<Futsal> futsalList = FutsalCRUD.obj.getAllData();
     for(Futsal futsal : futsalList){
         BigDecimal id = futsal.getId();
         BigInteger pan = futsal.getPan();
         String name = futsal.getName();
         String address = futsal.getAddress();
         BigInteger mobile = futsal.getMobile();
         BigDecimal rate = futsal.getRate();
         BigDecimal ownerId = futsal.getUserId();
         System.out.println(id+"\t"+pan+"\t"+name+"\t\t"+address+"\t"+mobile+"\t"+rate+"\t"+ownerId);

     }
      System.out.print("\nAvailable Operations\n1.Edit Futsal\n2.Delete Futsa\n3.Go Back\nSelect:");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                new FutsalController().editFutsal();
                break;
            case 2:
                new FutsalController().removeFutsal();
                break;
            case 3:
                break;
            default:
                break;
        }
 }

}
