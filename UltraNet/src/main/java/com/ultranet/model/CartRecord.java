/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.model;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class CartRecord {

    private ArrayList<Hardware> hardwares;
    private Hardware hardware;

    public CartRecord() {
        hardwares = new ArrayList<>();
    }//Constructor

    public String add(Hardware hardware) {
        hardwares.add(hardware);
        return "Elemento agregado con exito.";
    }//Add

    public Hardware search(String id) {
        for (int element = 0; element < hardwares.size(); element++) {
            hardware = hardwares.get(element);
            if (hardware.getId().equalsIgnoreCase(id)) {
                return hardware;
            }
        }
        return null;
    }//search
    
    

    public String delete(String id) {
        hardware = search(id);
        if (hardware != null) {
            if (hardwares.remove(hardware)) {
                return "El elemento ha sido eliminado";
            }
        }
        return "no se ha encontrado ningún elemento";
    }//delete

    public String[][] getData() {
        String data[][] = new String[hardwares.size()][Hardware.LABEL_STORE.length];
        for (int row = 0; row < hardwares.size(); row++) {
            for (int column = 0; column < Hardware.LABEL_STORE.length; column++) {
                data[row][column] = hardwares.get(row).getPropertyStore(column);
            }
        }
        return data;
    }

    public String getCompatibility(){
//    return getData();
    return toString();
    }
    
    @Override
    public String toString() {
        String data = "";
        for (int element = 0; element < hardwares.size(); element++) {
            hardware = hardwares.get(element);
            data += hardware;
        }
        return data;
    }//toString
}
