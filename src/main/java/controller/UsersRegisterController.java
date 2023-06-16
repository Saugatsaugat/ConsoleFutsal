
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
public class UsersRegisterController {
    
    Scanner sc = new Scanner(System.in);

    public void makeRegistration() {
        User registerInformation = new User();
        User user = new User();
        boolean status = false;
        boolean emailIdFlag = false;
        String email = null;
        BigDecimal id = null;
        System.out.println("Register as a\n1.Normal User\n2.Futsal Owner\n3.Admin\nSelect: ");
        try {
            int ch = sc.nextInt();
            if (ch == 1 || ch == 2 || ch == 3) {
                registerInformation = new UsersRegisterController().getRegistrationInformation();
            }
            switch (ch) {
                case 1:
                    registerInformation.setType("user");

                    id = registerInformation.getId();
                    if (new ValidationController().checkIfIdExistForUser(id)) {

                    } else {
                        if (new ValidationController().checkIfEmailExist(email)) {
                             System.out.println("Id already Exits!!!");
                        } else {
                            List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                            if ((messages.size()) > 0) {
                                for (String msg : messages) {
                                    System.out.println(msg);
                                }
                            } else {
                               status = UserCRUD.obj.create(registerInformation);
                               
                                if (status) {
                                    System.out.println("User added Successfully");
                                } else {
                                    System.out.println("User registration failed");
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    registerInformation.setType("futsalowner");
                    id = registerInformation.getId();
                    if (new ValidationController().checkIfIdExistForUser(id)) {
                         System.out.println("Id already Exits!!!");
                    } else {
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                                status = UserCRUD.obj.create(registerInformation);
                            if (status) {
                                System.out.println("Futsal Owner Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }
                    break;
                case 3:
                    registerInformation.setType("admin");
                    id = registerInformation.getId();
                    if (new ValidationController().checkIfIdExistForUser(id)) {
                        System.out.println("Id already Exits!!!");
                    } else {
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                                status = UserCRUD.obj.create(registerInformation);
                            if (status) {
                                System.out.println("Admin added Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }
                    break;

            }

        } catch (Exception ex) {

        }

    }

    /////////////////////////////////////////////////
    public User getRegistrationInformation() {
        User registerInformation = new User();
        try {

            System.out.println("Enter Id: ");
            BigDecimal id = sc.nextBigDecimal();
            sc.nextLine();

            System.out.println("Enter Email: ");
            String email = sc.next();

            System.out.println("Enter firstname: ");
            String firstname = sc.next();
            sc.nextLine();

            System.out.println("Enter midname: ");
            String midname = sc.nextLine();
            if (midname.equalsIgnoreCase("null")) {
                midname = null;
            }

            System.out.println("Enter lastname: ");
            String lastname = sc.next();

            System.out.println("Enter mobile: ");
            BigInteger mobile = sc.nextBigInteger();
            sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.next();
            
            registerInformation.setId(id);
            registerInformation.setFirstname(firstname);
            registerInformation.setEmail(email);
            registerInformation.setMidname(midname);
            registerInformation.setLastname(lastname);
            registerInformation.setMobile(mobile);
            
            String pass = new PasswordHashController().getPasswordHash(password);
            registerInformation.setPassword(pass);

            return registerInformation;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

}
