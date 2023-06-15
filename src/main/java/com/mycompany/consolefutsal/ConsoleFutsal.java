
package com.mycompany.consolefutsal;

import controller.RegisterController;
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
        while(flag){
        System.out.println("\nWhat do you want?\n1.Register\n2.Login\n3.Exit\nSelect: ");
        try {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                  new RegisterController().makeRegistration();
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    }
}
