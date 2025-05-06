/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.controller;

import com.ultranet.model.Hardware;
import com.ultranet.model.HardwareRecord;
import com.ultranet.view.hardware.HardwareData;
import com.ultranet.view.GUIMain;
import com.ultranet.view.hardware.GUIHardware;
import com.ultranet.view.hardware.HardwareTable;
import com.ultranet.view.hardware.MotherBoardData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Blaith
 */
public class HardwareController implements ActionListener, MouseListener, KeyListener {

    private GUIHardware guiHardware;
    private HardwareRecord hardwareRecord;
    private Hardware hardware;
    private GUIMain guiMain;
    private HardwareTable hardwareTable;
    private HardwareData hardwareData;
    private MotherBoardData motherBoardData;
    private int option;

    public HardwareController() {
        hardwareRecord = new HardwareRecord();
        guiHardware = new GUIHardware(this);
        hardwareTable = guiHardware.getHardwareTable();
        hardwareTable.listenMouse(this);
        hardwareTable.listenKey(this);
        hardwareData = new HardwareData(guiHardware, true);
        motherBoardData = new MotherBoardData(guiHardware, true);
        hardwareTable.setData(hardwareRecord.getData(), Hardware.LABEL_HARDWARE);
        hardwareData.listen(this);
        motherBoardData.listen(this);
        option = 0;
    }

    public void setGuiMain(GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    public GUIHardware getGuiHardware() {
        return guiHardware;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "accept":
                if (option == 1) {
                    // Obtener datos 
                    String id = hardwareData.getTxtId();
                    String name = hardwareData.getTxtName();
                    String quantity = hardwareData.getTxtQuantity();
                    String price = hardwareData.getTxtPrice();
                    String type = hardwareData.getTxtType();
                    String brand = hardwareData.getTxtBrand();
                    String description = hardwareData.getTxtDescription();
                    String conection = hardwareData.getTxtConection();

                    // Crear el nuevo hardware
                    if (type.equalsIgnoreCase("MotherBoard")) {
                        motherBoardData.setVisible(true);
                        String cpuPort = motherBoardData.getTxtCpuPort();
                        String pciePort = motherBoardData.getTxtPciePort();
                        String ramPort = motherBoardData.getTxtRamPort();
                        String storagePort = motherBoardData.getTxtStoragePort();
                        hardware = new Hardware(id, name, quantity, price, description, type, brand, conection, cpuPort, pciePort, ramPort, storagePort);
                    } else {
                        hardware = new Hardware(id, name, quantity, price, description, type, brand, conection, null, null, null, null);
                    }
                    guiHardware.showMessage(" Hardware " + hardwareRecord.add(hardware));
                    motherBoardData.cleanM();
                    hardwareData.clean();

                } else if (option == 2) {
                    // Actualiza el hardware existente
                    hardware.setName(hardwareData.getTxtName());
                    hardware.setQuantity(hardwareData.getTxtQuantity());
                    hardware.setPrice(hardwareData.getTxtPrice());
                    hardware.setType(hardwareData.getTxtType());
                    hardware.setBrand(hardwareData.getTxtBrand());
                    hardware.setDescription(hardwareData.getTxtDescription());
                    hardware.setConection(hardwareData.getTxtConection());
                    guiHardware.showMessage(hardwareRecord.edit(hardware));
                }

                hardwareTable.setData(hardwareRecord.getData(), Hardware.LABEL_HARDWARE);
                hardware = null;
                break;

            case "edit":
                option = 2;
                if (hardware == null) {
                    guiHardware.showMessage("No existe el ID seleccionado.");
                    hardwareData.dispose();
                } else {
                    hardwareData.setTxtId(hardware.getId());
                    hardwareData.setTxtName(hardware.getName());
                    hardwareData.setTxtQuantity(hardware.getQuantity());
                    hardwareData.setTxtPrice(hardware.getPrice());
                    hardwareData.setTxtType(hardware.getType());
                    hardwareData.setTxtBrand(hardware.getBrand());
                    hardwareData.setTxtDescription(hardware.getDescription());
                    hardwareData.setTxtConection(hardware.getConection());
                    hardwareData.setVisible(true);
                }
                break;
            case "delete":
                if (hardware != null) {
                    guiHardware.showMessage(hardwareRecord.delete(hardware.getId()));
                    hardwareTable.setData(hardwareRecord.getData(), Hardware.LABEL_HARDWARE);
                    hardware = null;
                } else {
                    guiHardware.showMessage("Error, por favor seleccione un espacio valido para eliminar");
                }
                break;

            case "cancel":
                hardwareData.dispose();
                motherBoardData.dispose();
                break;
            case "cancelM":
                motherBoardData.dispose();
                break;

            case "add":
                option = 1;
                hardwareData.clean();
                hardwareData.setVisible(true);
                break;

            case "leave":
                guiHardware.dispose();
                if (guiMain != null) {
                    guiMain.setVisible(true);
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String[] spaceRow = hardwareTable.getRowSelected();
        if (spaceRow != null && spaceRow.length > 0) {
            String id = spaceRow[0];
            hardware = hardwareRecord.searchById(id);
        }
        System.out.println("Presiono: " + hardware);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hardwareTable.filterByUsername();
    }

}
