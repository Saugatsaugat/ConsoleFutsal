package controller;

import entites.Futsal;
import entites.FutsalCRUD;
import entites.User;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
        List<String> errorMessage = new ArrayList<String>();
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
                futsal = null;
                return null;
            }
            
            if((name==null)||(pan==null)||(mobile==null)||(rate==null)||(address==null)){
                errorMessage.add("All fields are necessary");
            }
            String ms1 = new ValidationController().checkNumber(mobile);
            String ms2 = new ValidationController().checkNumber(pan);
            String ms3 = new ValidationController().checkNumber(rate);
            if(ms1!=null||ms2!=null||ms3!=null){
                System.out.println("Mobile, pan and Rate must be integer");
                futsal =  null;
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
   
   public void editFutsal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id you want to edit:\n");
        BigDecimal id1 = sc.nextBigDecimal();
        Futsal futsal = new FutsalCRUD().getFutsalDataById(id1);
        System.out.println(futsal);

        BigDecimal id = futsal.getId();
        BigInteger pan = futsal.getPan();
        String name = futsal.getName();
        String address = futsal.getAddress();
        BigInteger mobile = futsal.getMobile();
        BigDecimal rate = futsal.getRate();
        BigDecimal ownerId = futsal.getUserId();

        System.out.println("Update the futsal details");
        System.out.println("Edit pan? Y/N");
        String input1 = sc.next();
        sc.nextLine();
        char char1 = input1.charAt(0);
        if (char1 == 'Y' || char1 == 'y') {
            System.out.println("Enter pan:");
            pan = sc.nextBigInteger();
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
            mobile = sc.nextBigInteger();
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
        newFutsal.setId(id);
        newFutsal.setPan(pan);
        newFutsal.setName(name);
        newFutsal.setAddress(address);
        newFutsal.setMobile(mobile);
        newFutsal.setRate(rate);
        newFutsal.setUserId(ownerId);


        if (new FutsalCRUD().deleteFutsalDataById(id)) {
            if (new FutsalCRUD().addFutsal(newFutsal)) {
                System.out.println("Updated Successfully");

            } else {
                System.out.println("Can not be updated");
            }
        } else {
            System.out.println("Something went wrong");

        }

   }
}
