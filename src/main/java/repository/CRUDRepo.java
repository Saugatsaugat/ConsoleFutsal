/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entites.Futsal;
import entites.User;
import java.math.BigDecimal;
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
    public T1 getDataById(BigDecimal id) {
        BigDecimal fetchedid = null;
        T1 users = null;
        for (T1 user : list) {
            if (user instanceof User) {
                User userItem = (User) user;
                fetchedid = userItem.getId();
            } else if (user instanceof Futsal) {
                Futsal userItem = (Futsal) user;
                fetchedid = userItem.getId();
            }
            if (fetchedid != null && fetchedid.compareTo(id) == 0) {
                users = user;
            }
        }
        return users;
    }

    @Override
    public boolean deleteById(BigDecimal id) {
        BigDecimal fetchedid = null;
        for (T1 user : list) {
            if (user instanceof User) {
                User userItem = (User) user;
                fetchedid = userItem.getId();
            } else if (user instanceof Futsal) {
                Futsal userItem = (Futsal) user;
                fetchedid = userItem.getId();
            }
            if (fetchedid != null && fetchedid.compareTo(id) == 0) {
                list.remove(user);
                return true;
            }

        }

        return false;
    }

}
