/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.model;

/**
 *
 * @author Blaith
 */
public class Hardware {

    private String id;
    private String name;
    private String quantity;
    private String price;
    private String description;
    private String type;
    private String brand;
    private String conection;

    // MotherBoard
    private String cpuPort;
    private String pciePort;
    private String ramPort;
    private String storagePort;

    public static final String LABEL_HARDWARE[] = {"ID", "Name", "Quantity", "Price", "Description", "Type", "Brand", "Conection"};
    public static final String LABEL_MOTHERBOARD[] = {};
    public static final String LABEL_STORE[] = {"ID", "Name", "Price"};

    public Hardware(String id, String name, String quantity, String price, String description, String type, String brand, String conection, String cpuPort, String pciePort, String ramPort, String storagePort) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.conection = conection;
        this.cpuPort = cpuPort;
        this.pciePort = pciePort;
        this.ramPort = ramPort;
        this.storagePort = storagePort;

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

    public String getConection() {
        return conection;
    }

    public void setConection(String conection) {
        this.conection = conection;
    }

    public String getCpuPort() {
        return cpuPort;
    }

    public void setCpuPort(String cpuPort) {
        this.cpuPort = cpuPort;
    }

    public String getPciePort() {
        return pciePort;
    }

    public void setPciePort(String pciePort) {
        this.pciePort = pciePort;
    }

    public String getRamPort() {
        return ramPort;
    }

    public void setRamPort(String ramPort) {
        this.ramPort = ramPort;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }

    public boolean reduceQuantity() {
        int amount = Integer.parseInt(this.quantity);
        if (amount > 0) {
            setQuantity(String.valueOf(amount - 1));  // Disminuye la cantidad y convierte de nuevo a String
            amount = 0;
            return true;
        }
        return false;
    }

    public boolean increaseQuantity() {
        int amount = Integer.parseInt(this.quantity);
        if (amount >= 0) {
            setQuantity(String.valueOf(amount + 1));  // Disminuye la cantidad y convierte de nuevo a String
            amount = 0;
            return true;
        }
        return false;
    }

    public boolean disponibility() {
        int amount = Integer.parseInt(this.quantity);
        return amount > 0;  // Si la cantidad es mayor que 0, esta disponible
    }

    public String getProperty(int index) {
        switch (index) {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return quantity;
            case 3:
                return price;
            case 4:
                return description;
            case 5:
                return type;
            case 6:
                return brand;
            case 7:
                return conection;
            case 8:
                return cpuPort;
            case 9:
                return pciePort;
            case 10:
                return ramPort;
            case 11:
                return storagePort;
            default:
                throw new AssertionError("Index fuera de rango: " + index);
        }
    }

    public String getPropertyStore(int index) {
        switch (index) {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return price;
            default:
                throw new AssertionError("Index fuera de rango: " + index);
        }
    }

    @Override
    public String toString() {
        if (type.equalsIgnoreCase("MotherBoard")) {
            return "Hardware\n"
                    + "-------------------------------\n"
                    + "  Id: " + id + "\n"
                    + "  Name: " + name + "\n"
                    + "  Quantity: " + quantity + "\n"
                    + "  Price: " + price + "\n"
                    + "  Description: " + description + "\n"
                    + "  Type: " + type + "\n"
                    + "  Brand: " + brand + "\n"
                    + "  Conection: " + conection + "\n"
                    + "  CpuPort: " + cpuPort + "\n"
                    + "  PciePort: " + pciePort + "\n"
                    + "  RamPort: " + ramPort + "\n"
                    + "  StoragePort: " + storagePort + "\n"
                    + "-------------------------------";
        } else {
            return "Hardware\n"
                    + "-------------------------------\n"
                    + "  Id: " + id + "\n"
                    + "  Name: " + name + "\n"
                    + "  Quantity: " + quantity + "\n"
                    + "  Price: " + price + "\n"
                    + "  Description: " + description + "\n"
                    + "  Type: " + type + "\n"
                    + "  Brand: " + brand + "\n"
                    + "  Conection: " + conection + "\n"
                    + "-------------------------------";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Hardware hardware = (Hardware) obj;
        return id.equalsIgnoreCase(hardware.id);
    }
}
