package controller;

import entites.Futsal;
import entites.FutsalCRUD;
import entites.User;
import entites.UserCRUD;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class FutsalController {

    public void mainPage(User user) {
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        BigDecimal userId = user.getId();
        System.out.println("**************************\n  Futsal Registration Page\n***********************");
        System.out.println("Welcome " + firstname + " " + lastname);
        System.out.println("Register your futsal");
        futsalRegister(userId);

    }

    public void futsalRegister(BigDecimal userId) {
        Futsal futsalInformation = getRegistrationInformation();
        if (futsalInformation == null) {
            System.out.println("Futsal Registration Failed");
        } 
        else {
            futsalInformation.setUserId(userId);
            if (new FutsalCRUD().addFutsal(futsalInformation)) {
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
            System.out.println("Enter Id: ");
            BigDecimal id = sc.nextBigDecimal();
            sc.nextLine();

            System.out.println("Enter name: ");
            String name = sc.next();
            sc.nextLine();

            System.out.println("Enter Pan: ");
            BigInteger pan = sc.nextBigInteger();
            sc.nextLine();

            System.out.println("Enter address: ");
            String address = sc.next();
            sc.nextLine();

            System.out.println("Enter mobile: ");
            BigInteger mobile = sc.nextBigInteger();
            sc.nextLine();

            System.out.println("Enter rate (per hour): ");
            BigDecimal rate = sc.nextBigDecimal();
            sc.nextLine();

            if (new ValidationController().checkIfIdExistForFutsal(id)) {
                System.out.println("Id already Exits");

                return null;
            }
            

            futsal.setId(id);
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
    
    
   public void removeFutsal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the futsal to delete:\n");
        BigDecimal id = sc.nextBigDecimal();
        if (new FutsalCRUD().deleteFutsalDataById(id)) {
            System.out.println("Deleted Successfully");
            new AdminController().manageFutsals();
        } else {
            System.out.println("Something went wrong");

        }
    }
}
