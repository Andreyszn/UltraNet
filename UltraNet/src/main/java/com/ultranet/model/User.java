/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.model;

/**
 *
 * @author luisa
 */
public class User {

    private String id;
    private String name;
    private String email;
    private String type;
    private String password;

    public static final String LABEL_USER[] = {"ID", "Name", "Email", "Type"};

    public User(String id, String name, String email, String type, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.password = password;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProperty(int index) {
        switch (index) {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return email;
            case 3:
                return type;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "User \n"
                + "  id: " + id + ",\n"
                + "  name: '" + name + "',\n"
                + "  email: '" + email + "',\n"
                + "  type: '" + type + "'\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return id.equals(user.id);
    }

}
