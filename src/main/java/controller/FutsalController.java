package controller;

import entites.Futsal;
import entites.FutsalCRUD;
import entites.User;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class FutsalController {
    
    public void mainPage(User user) throws SQLException {
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        Long userId = user.getId();
        System.out.println("**************************\n  Futsal Registration Page\n***********************");
        System.out.println("Welcome " + firstname + " " + lastname);
        if (new FutsalCRUD(new Futsal()).checkIfFutsalRegistered(userId)) {
            System.out.println("Your Futsal Detail\n");
            Futsal futsal = new FutsalCRUD(new Futsal()).getFutsalDataByOwnerId(userId);
            System.out.println("\nPan: " + futsal.getPan() + "\n Name: " + futsal.getName() + "\nAddress: " + futsal.getAddress() + "\nMobile: " + futsal.getMobile() + "\nRate: " + futsal.getRate());
            
        } else {
            System.out.println("Register your futsal");
            futsalRegister(userId);
        }
    }
    
    public void futsalRegister(Long userId) throws SQLException {
        Futsal futsalInformation = getRegistrationInformation();
        if (futsalInformation == null) {
            System.out.println("Futsal Registration Failed");
        } else {
            futsalInformation.setUserId(userId);
            
            if (new FutsalCRUD(new Futsal()).create(futsalInformation)) {
                System.out.println("Futsal registered");
            } else {
                System.out.println("Futsal Registration Failed");
                
            }
            
        }
    }
    
    public Futsal getRegistrationInformation() {
        Scanner sc = new Scanner(System.in);
        Futsal futsal = new Futsal();
        try {
            
            System.out.println("Enter name: ");
            String name = sc.next();
            sc.nextLine();
            
            System.out.println("Enter Pan: ");
            Long pan = sc.nextLong();
            sc.nextLine();
            
            System.out.println("Enter address: ");
            String address = sc.next();
            sc.nextLine();
            
            System.out.println("Enter mobile: ");
            Long mobile = sc.nextLong();
            sc.nextLine();
            
            System.out.println("Enter rate (per hour): ");
            BigDecimal rate = sc.nextBigDecimal();
            sc.nextLine();
            
            if ((name == null) || (pan == 0) || (mobile == 0) || (rate == null) || (address == null)) {
                System.out.println("All fields are necessary");
                return null;
            }
            
            futsal.setName(name);
            futsal.setPan(pan);
            futsal.setMobile(mobile);
            futsal.setRate(rate);
            futsal.setAddress(address);
            return futsal;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
        return futsal;
    }
    
    public void removeFutsal() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the futsal to delete:\n");
        Long id = sc.nextLong();
        if (new FutsalCRUD(new Futsal()).deleteById(id)) {
            System.out.println("Deleted Successfully");
            new AdminController().manageFutsals();
        } else {
            System.out.println("Something went wrong");
            
        }
    }
    
    public void editFutsal() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id you want to edit:\n");
        Long id1 = sc.nextLong();
        ResultSet futsal = new FutsalCRUD(new Futsal()).getDataById(id1);
        System.out.println(futsal);
        
        Long id = null;
        Long pan = null;
        String name = null;
        String address = null;
        Long mobile = null;
        BigDecimal rate = null;
        Long ownerId = null;
        while (futsal.next()) {
            id = futsal.getLong("id");
            pan = futsal.getLong("pan");
            name = futsal.getString("name");
            address = futsal.getString("address");
            mobile = futsal.getLong("mobile");
            rate = futsal.getBigDecimal("rate");
            ownerId = futsal.getLong("ownerid");
        }
        System.out.println("Update the futsal details");
        System.out.println("Edit pan? Y/N");
        String input1 = sc.next();
        sc.nextLine();
        char char1 = input1.charAt(0);
        if (char1 == 'Y' || char1 == 'y') {
            System.out.println("Enter pan:");
            pan = sc.nextLong();
            sc.nextLine();
        }
        
        System.out.println("Edit name? Y/N");
        String input2 = sc.next();
        sc.nextLine();
        char char2 = input2.charAt(0);
        if (char2 == 'Y' || char2 == 'y') {
            System.out.println("Enter name:");
            name = sc.next();
            sc.nextLine();
        }
        
        System.out.println("Edit address? Y/N");
        String input3 = sc.next();
        sc.nextLine();
        char char3 = input3.charAt(0);
        if (char3 == 'Y' || char3 == 'y') {
            System.out.println("Enter new address:");
            address = sc.next();
            sc.nextLine();
        }
        System.out.println("Edit mobile? Y/N");
        String input4 = sc.next();
        char char4 = input4.charAt(0);
        if (char4 == 'Y' || char4 == 'y') {
            System.out.println("Enter mobile:");
            mobile = sc.nextLong();
            sc.nextLine();
        }
        
        System.out.println("Edit rate? Y/N");
        String input5 = sc.next();
        sc.nextLine();
        char char5 = input5.charAt(0);
        if (char5 == 'Y' || char5 == 'y') {
            System.out.println("Enter rate:");
            rate = sc.nextBigDecimal();
            sc.nextLine();
        }
        
        Futsal newFutsal = new Futsal();
        newFutsal.setPan(pan);
        newFutsal.setName(name);
        newFutsal.setAddress(address);
        newFutsal.setMobile(mobile);
        newFutsal.setRate(rate);
        newFutsal.setUserId(ownerId);
        
        if (new FutsalCRUD(new Futsal()).updateFutsal(newFutsal, id)) {
            System.out.println("Updated Successfully");
            
        } else {
            System.out.println("Can not be updated");
        }
        
    }
    
}
