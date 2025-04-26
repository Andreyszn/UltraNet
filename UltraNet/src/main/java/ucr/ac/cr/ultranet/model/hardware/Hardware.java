/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.ultranet.model.hardware;

import ucr.ac.cr.ultranet.model.*;

/**
 *
 * @author grupo05
 */
public class Hardware {

    private String id;
    private String name;
    private String quantity;
    private String price;
    private String description;
    private String type;
    private String brand;
    private String compatibility;

    public Hardware(String id, String name, String quantity, String price, String description, String type, String brand, String compatibility) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.compatibility = compatibility;
    }

    public Hardware() {

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    @Override
    public String toString() {
        return "Hardware {\n"
                + "  id: " + id + ",\n"
                + "  name: '" + name + "',\n"
                + "  quantity: " + quantity + ",\n"
                + "  price: " + price + ",\n"
                + "  description: '" + description + "',\n"
                + "  type: '" + type + "',\n"
                + "  brand: '" + brand + "',\n"
                + "  compatibility: '" + compatibility + "'\n"
                + '}';
    }

}
