/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.model;

import com.google.gson.reflect.TypeToken;
import com.ultranet.dao.GenericDAOJSon;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Blaith
 */
public class UserRecord {

    private GenericDAOJSon users;
    private User user;

    public UserRecord() {
        Type userType = new TypeToken<User[]>() {
        }.getType();
        users = new GenericDAOJSon("users.json", userType);
    }

    public String add(User user) {
        return users.add(user);
    }

    public User search(String id) {
        ArrayList<User> localUsers = users.getAll();
        for (int index = 0; index < localUsers.size(); index++) {
            user = (User) localUsers.get(index);
            if (user.getId().equalsIgnoreCase(id)) {
                return user;
            }
        }
        return null;
    }

    public User searchById(String id) {
        ArrayList<User> localUsers = users.getAll();
        for (int index = 0; index < localUsers.size(); index++) {
            User user = localUsers.get(index);
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public String edit(User user) {
        return users.edit(user);
    }

    public String delete(String id) {
        user = search(id);
        if (user != null) {
            return users.delete(user);
        }
        return "No se encontro";
    }

    public int userType(String id){
        user= search(id);
        System.out.println(user.getType());
        if(!user.getType().equalsIgnoreCase("User")){
            System.out.println("userType Admin");
            return 1;
        }else{
            System.out.println("userType cliente");
            return 2;
        }
    }

    public String[][] getData() {
        ArrayList<User> localUsers = users.getAll();
        String data[][] = new String[localUsers.size()][User.LABEL_USER.length];
        for (int row = 0; row < localUsers.size(); row++) {
            for (int column = 0; column < User.LABEL_USER.length; column++) {
                data[row][column] = localUsers.get(row).getProperty(column);
            }
        }
        return data;
    }
    
//// hay que ver si se implementa siempre /////////// 
//    public void logout() {
//        user = null; 
//    }
//
//    public User getCurrentUser() {
//        return user;
//    }
//
//    public void setCurrentUser(User user) {
//        this.user = user; 
//    }
    
    @Override
    public String toString() {
        return users.toString();
    }

}
