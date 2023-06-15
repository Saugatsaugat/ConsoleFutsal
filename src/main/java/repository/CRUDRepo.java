/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saugat
 * @param <T1> : entity
 */
public abstract class CRUDRepo<T1> implements CRUDInterface<T1> {

    private List<T1> list;

    public CRUDRepo() {
        list = new ArrayList<>();
    }

    @Override
    public T1 create(T1 data) {
        if (list.add(data)) {
            return data;
        }
        return null;
    }

    @Override
    public List<T1> getAllData() {
        return list;
    }

    @Override
    public T1 getDataById(String email) {
        T1 user = null;
        for (T1 items : list) {
            if (items.equals(email)) {
                user = items;
            }
        }
        return user;
    }

    @Override
    public boolean deleteById(String email) {
     
        for (T1 user : list) {
            if (user.toString().contains(email)) {
                list.remove(user);
                return true;
            }
        }
        
        return false;
    }

}
