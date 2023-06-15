/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entites.User;
import entites.UserCRUD;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author saugat
 */
public class ValidationController {

    public String checkEmail(String email) {
        String msg = null;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            msg = "Wrong Email Format";
        }
        return msg;
    }
    /////////////////////////////////////

    public String checkName(String name) {
        String msg = null;
        String nameRegex = "[A-Za-z]+";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            msg = "Name must be in alphabets";
        }
        return msg;
    }
    ///////////////////////////////////////////

    public String checkMobile(BigInteger mobile) {
        String msg = null;
        String numRegex = "[0-9]+";
        Pattern pattern = Pattern.compile(numRegex);
        Matcher matcher = pattern.matcher(mobile.toString());
        if (!matcher.matches()) {
            msg = "mobile must be in integer";
        }
        return msg;
    }
    public List<String> validateUserRegistration(HashMap<String,String> registerInformation){
        List<String> errorMessage = new ArrayList<String>();
        BigDecimal id = new BigDecimal(registerInformation.get("id"));
        String type = registerInformation.get("type");
        String firstname = registerInformation.get("firstname");
        String lastname = registerInformation.get("lastname");
        String email = registerInformation.get("email");
        String password = registerInformation.get("password");
        BigInteger mobile = new BigInteger(registerInformation.get("mobile"));
        
        if((id==null)||(firstname==null)||(lastname==null)||(email==null)||(password==null)||(mobile==null)){
            errorMessage.add("Only midname can be null");
        }
        String msg1 = checkEmail(email);
        String msg2 = checkMobile(mobile);
        String msg3 = checkName(firstname);
        String msg4 = checkName(lastname);
        if(msg1!=null){
            errorMessage.add(msg1);
            
        }
        if(msg2!=null){
            errorMessage.add(msg2);
        }
        if((msg3!=null)||(msg4!=null)){
            errorMessage.add(msg3);
        }
        return errorMessage;
        
    }
    public boolean checkIfEmailExist(String email) {
        List<User> userList = new UserCRUD().getUserList();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }

        }
        return false;
    }
    public boolean checkIfIdExist(BigDecimal id) {
        List<User> userList = new UserCRUD().getUserList();
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    
        
}
