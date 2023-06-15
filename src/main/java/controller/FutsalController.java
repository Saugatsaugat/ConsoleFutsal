package controller;

import entites.Futsal;
import entites.FutsalCRUD;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class FutsalController {
    
    public void futsalRegister(){
        Futsal futsalInformation = getRegistrationInformation();
        if(new FutsalCRUD().addFutsal(futsalInformation)){
            System.out.println("Futsal registered");
        }
        else{
            System.out.println("Futsal Registration Failed");
        }
        
    }
   
    public Futsal getRegistrationInformation() {
        Scanner sc = new Scanner(System.in);
        Futsal registerInformation = new Futsal();
        try {
            System.out.println("Enter Id: ");
            BigDecimal id = sc.nextBigDecimal();
            sc.nextLine();

            System.out.println("Enter name: ");
            String name = sc.next();

            System.out.println("Enter Pan: ");
            BigInteger pan = sc.nextBigInteger();
            sc.nextLine();

            System.out.println("Enter address: ");
            String address = sc.next();

            System.out.println("Enter mobile: ");
            BigInteger mobile = sc.nextBigInteger();
            sc.nextLine();

            System.out.println("Enter rate (per hour): ");
            BigDecimal rate = sc.nextBigDecimal();
            sc.nextLine();
            Futsal futsal = new Futsal();
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
        return registerInformation;
    }
}
