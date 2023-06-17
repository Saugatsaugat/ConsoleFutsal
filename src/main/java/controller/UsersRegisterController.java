package controller;

import entites.User;
import entites.UserCRUD;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author saugat
 */
public class UsersRegisterController {

    Scanner sc = new Scanner(System.in);

    public void makeRegistration() throws SQLException {
        User registerInformation = new User();
        User user = new User();
        boolean status = false;
        boolean emailIdFlag = false;
        String email = null;
        Long id = null;
        System.out.println("Register as a\n1.Normal User\n2.Futsal Owner\n3.Admin\nSelect: ");
        try {
            int ch = sc.nextInt();
            if (ch == 1 || ch == 2 || ch == 3) {
                registerInformation = new UsersRegisterController().getRegistrationInformation();
            }
            switch (ch) {
                case 1:
                    email = registerInformation.getEmail();
                    if (new ValidationController().checkIfEmailExist(email)) {
                        System.out.println("Email already Exits!!!");
                    } else {
                        registerInformation.setUsertype("user");
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                            status = new UserCRUD(new User()).create(registerInformation);

                            if (status) {
                                System.out.println("User added Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }

                    break;
                case 2:
                    email = registerInformation.getEmail();
                    if (new ValidationController().checkIfEmailExist(email)) {
                        System.out.println("Email already Exits!!!");
                    } else {
                        registerInformation.setUsertype("futsalowner");
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                            status = new UserCRUD(new User()).create(registerInformation);
                            if (status) {
                                System.out.println("Futsal Owner added Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }
                    break;
                case 3:
                    email = registerInformation.getEmail();
                    if (new ValidationController().checkIfEmailExist(email)) {
                        System.out.println("Email already Exits!!!");
                    } else {
                        registerInformation.setUsertype("admin");
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                            status = new UserCRUD(new User()).create(registerInformation);
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
            System.out.println(ex.getMessage());
        }

    }

    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    public User getRegistrationInformation() {
        User registerInformation = new User();
        try {

//            System.out.println("Enter Id: ");
//            Long id = sc.nextLong();
//            sc.nextLine();
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
            Long mobile = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.next();

            //   registerInformation.setId(id);
            registerInformation.setFirstname(firstname);
            registerInformation.setEmail(email);
            registerInformation.setMidname(midname);
            registerInformation.setLastname(lastname);
            registerInformation.setMobile(mobile);

            String pass = new PasswordHashController().getPasswordHash(password);
            registerInformation.setUserpassword(pass);
            

            return registerInformation;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

}
