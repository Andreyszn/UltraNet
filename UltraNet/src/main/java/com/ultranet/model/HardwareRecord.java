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
public class HardwareRecord {

    private GenericDAOJSon components;
    private Hardware hardware;

    public HardwareRecord() {
        Type hardwareType = new TypeToken<Hardware[]>() {
        }.getType();
        components = new GenericDAOJSon("hardware.json", hardwareType);
    }

    public String add(Hardware hardware) {
        return components.add(hardware);
    }

    public Hardware search(String id) {
        ArrayList<Hardware> localHardware = components.getAll();
        for (int index = 0; index < localHardware.size(); index++) {
            Hardware hardware = localHardware.get(index);
            if (hardware.getId().equals(id)) {
                return hardware;
            }
        }
        return null;
    }

    public Hardware searchById(String id) {
        ArrayList<Hardware> localHardware = components.getAll();
        for (int index = 0; index < localHardware.size(); index++) {
            Hardware hardware = localHardware.get(index);
            if (hardware.getId().equals(id)) {
                return hardware;
            }
        }
        return null;
    }

    public String edit(Hardware hardware) {
        return components.edit(hardware);
    }

    public String delete(String id) {
        hardware = searchById(id);
        if (hardware != null) {
            return components.delete(hardware);
        }
        return "No se encontro";
    }

    public String[][] getData() {
        ArrayList<Hardware> localHardware = components.getAll();
        String[][] data = new String[localHardware.size()][Hardware.LABEL_HARDWARE.length];
        for (int row = 0; row < localHardware.size(); row++) {
            for (int column = 0; column < Hardware.LABEL_HARDWARE.length; column++) {
                data[row][column] = localHardware.get(row).getProperty(column);
            }
        }
        return data;
    }

    public String[][] getDataStore() {
        ArrayList<Hardware> localHardware = components.getAll();
        String[][] data = new String[localHardware.size()][Hardware.LABEL_STORE.length];
        for (int row = 0; row < localHardware.size(); row++) {
            for (int column = 0; column < Hardware.LABEL_STORE.length; column++) {
                data[row][column] = localHardware.get(row).getPropertyStore(column);
            }
        }
        return data;
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
