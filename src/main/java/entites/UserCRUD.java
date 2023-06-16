/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import java.util.List;
import repository.CRUDRepo;

/**
 *
 * @author saugat
 */
public class UserCRUD extends CRUDRepo<User> {

    public static UserCRUD obj = new UserCRUD();

    public User getDataByEmail(String email) {
        List<User> userList = obj.getAllData();
        for (User user : userList) {
            if (user.getEmail().contains(email)) {
                return user;
            }
        }
        return null;
    }

}
