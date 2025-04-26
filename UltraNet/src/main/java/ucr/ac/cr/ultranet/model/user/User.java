/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.ultranet.model.user;

import ucr.ac.cr.ultranet.model.*;

/**
 *
 * @author grupo05
 */
public class User {

    private String id;
    private String name;
    private String email;
    private String type;

    public User(String id, String name, String email, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
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

    @Override
    public String toString() {
        return "User {\n"
                + "  id: " + id + ",\n"
                + "  name: '" + name + "',\n"
                + "  email: '" + email + "',\n"
                + "  type: '" + type + "'\n"
                + '}';
    }

}
