/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.controller;

import com.ultranet.model.CartRecord;
import com.ultranet.model.Hardware;
import com.ultranet.model.HardwareRecord;
import com.ultranet.view.GUIMain;
import com.ultranet.view.hardware.HardwareTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.ultranet.view.store.CartTable;
import com.ultranet.view.store.GUIStore;
import com.ultranet.view.store.ShoppingCart;

/**
 *
 * @author David
 */
public class StoreController implements ActionListener, MouseListener, KeyListener {

    private GUIStore guiStore;
    private HardwareRecord hardwareRecord;
    private Hardware hardware;
    private GUIMain guiMain;
    private HardwareTable hardwareTable;
    private ShoppingCart shoppingCart;
    private CartTable carTable;
    private CartRecord carRecord;

    public StoreController() {
        hardwareRecord = new HardwareRecord();
        guiStore = new GUIStore(this);
        shoppingCart = new ShoppingCart(guiStore, true);
        carRecord = new CartRecord();
        hardwareTable = guiStore.getHardwareTable();
        hardwareTable.listenMouse(this);
        hardwareTable.listenKey(this);
        carTable = shoppingCart.getCarTable();
        carTable.listenMouse(this);
        hardwareTable.setData(hardwareRecord.getDataStore(), Hardware.LABEL_STORE);
        carTable.setData(carRecord.getData(), Hardware.LABEL_STORE);
        shoppingCart.listen(this);
    }

    public void setGuiMain(GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    public GUIStore getGuiStore() {
        return guiStore;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "hdwInfo":
                if (hardware == null) {
                    guiStore.showMessage("Please select an item first.");
                    shoppingCart.dispose();
                } else {
                    guiStore.showMessage(hardware.toString());
                }
                break;

            case "buy":
                if (hardware != null) {
                    guiStore.dispose();
                    shoppingCart.setVisible(true);
                    carTable.setData(carRecord.getData(), Hardware.LABEL_STORE);
                } else {
                    guiStore.showMessage("Please select an item first to proceed with the purchase.");
                }
                break;

            case "cancel":
                shoppingCart.dispose();
                break;

            case "previous":
                shoppingCart.dispose();
                guiStore.setVisible(true);
                hardwareTable.setData(hardwareRecord.getDataStore(), Hardware.LABEL_STORE);
                break;

            case "delete":
                if (hardware != null) {

                    String message = carRecord.delete(hardware.getId());
                    guiStore.showMessage(message);
                    hardware.increaseQuantity();
                    hardwareRecord.edit(hardware);

                    carTable.setData(carRecord.getData(), Hardware.LABEL_STORE);

                    hardware = null;

                } else {
                    guiStore.showMessage("Please select an item first.");
                }
                break;

            case "addItem":
                if (hardware != null) {
                    if (hardware.disponibility()) {
                        guiStore.showMessage("An item has been added to your cart!");
                        carRecord.add(hardware);
                        carTable.setData(carRecord.getData(), Hardware.LABEL_STORE);
                        hardware.reduceQuantity();
                        hardwareRecord.edit(hardware);
                    } else {
                        guiStore.showMessage("Sorry, this item is out of stock.");
                    }
                } else {
                    guiStore.showMessage("Please select an item first.");
                }
                break;

            case "leave":
                guiStore.showMessage("Thanks for choosing us~!");
                System.exit(0);
                break;

            case "compat":
                guiStore.showMessage(carRecord.getCompatibility());
                break;

            default:
                guiStore.showMessage("Error, storeController");
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (shoppingCart.isVisible()) {
            String[] spaceRow = carTable.getRowSelected();
            if (spaceRow != null && spaceRow.length > 0) {
                String id = spaceRow[0];
                hardware = carRecord.search(id);
            }
            System.out.println("Pressed: " + hardware);
        } else {
            String[] spaceRow = hardwareTable.getRowSelected();
            if (spaceRow != null && spaceRow.length > 0) {
                String id = spaceRow[0];
                hardware = hardwareRecord.searchById(id);
            }
            System.out.println("Pressed: " + hardware);
        }//else
    }//fin

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
