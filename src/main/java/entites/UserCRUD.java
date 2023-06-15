/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import controller.PasswordHashController;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import repository.CRUDRepo;

/**
 *
 * @author saugat
 */
public class UserCRUD extends CRUDRepo<User> {

    public static UserCRUD obj = new UserCRUD();

    public boolean addUser(HashMap<String, String> registerInformation) {
        User user = new User();
        user.setId(new BigDecimal(registerInformation.get("id")));
        user.setType(registerInformation.get("type"));
        user.setEmail(registerInformation.get("email"));
        user.setFirstname(registerInformation.get("firstname"));
        user.setMidname(registerInformation.get("midname"));
        user.setLastname(registerInformation.get("lastname"));
        user.setMobile(new BigInteger(registerInformation.get("mobile")));
        String pass = registerInformation.get("password");
        String password = new PasswordHashController().getPasswordHash(pass);
        user.setPassword(password);
        if ((obj.create(user)) == null) {
            return false;
        }
        return true;
    }

    ////////////////////////////////////
    public List<User> getUserList() {
        return obj.getAllData();
    }

//    //////////////////////////////////////
    public User getDataByEmail(String email) {
        List<User> userList = obj.getAllData();
        for (User user : userList) {
            if (user.getEmail().contains(email)) {
                return user;
            } 
        }
        return null;
    }
    
    public boolean deleteDataByEmail(BigDecimal id)
    {
        if(obj.deleteById(id)){
            return true;
        }
        return false;

    }
    public boolean addUser(User user){
        Object object = obj.create(user);
        if(object!=null)
        {
            return true;
        }
        return false;
    }

}