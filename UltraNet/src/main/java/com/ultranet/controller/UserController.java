/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.controller;

import com.ultranet.model.User;
import com.ultranet.model.UserRecord;
import com.ultranet.view.GUIMain;
import com.ultranet.view.RegisterUserData;
import com.ultranet.view.user.GUIUser;
import com.ultranet.view.user.UserTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserController implements ActionListener, MouseListener, KeyListener {

    private GUIUser guiUser;
    private UserRecord userRegister;
    private User user;
    private GUIMain guiMain;
    private UserTable userTable;
    private RegisterUserData registerData;
    private StoreController storeController;
    private int option;
    private int entry;

    public UserController() {
        userRegister = new UserRecord();
        guiUser = new GUIUser(this);
        storeController = new StoreController();
        userTable = guiUser.getUserTable();
        userTable.listenMouse(this);
        userTable.listenKey(this);
        registerData = new RegisterUserData(guiUser, true);
        userTable.setData(userRegister.getData(), User.LABEL_USER);
        registerData.listen(this);
        option = 1;
        entry = 1;
    }

    public void setGuiMain(GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    public GUIUser getGuiUser() {
        return guiUser;
    }

    public RegisterUserData getRegisterUser() {
        return registerData;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "edit":
                option = 2;
                entry = 2;
                if (user == null) {
                    guiUser.showMessage("No existe el ID seleccionado.");
                    registerData.dispose();
                } else {
                    registerData.setTxtId(user.getId());
                    registerData.setTxtName(user.getName());
                    registerData.setTxtEmail(user.getEmail());
                    registerData.setJcbType(user.getType());
                    registerData.setTxtPassword(user.getPassword());
                    registerData.setVisible(true);
                }
                break;

            case "delete":
                if (user != null) {
                    guiUser.showMessage(userRegister.delete(user.getId()));
                    userTable.setData(userRegister.getData(), User.LABEL_USER);
                    user = null;
                } else {
                    guiUser.showMessage("Error, por favor seleccione un usuario valido.");
                }
                break;

            case "add":
                option = 1;
                entry = 2;
                registerData.clean();
                registerData.setVisible(true);
                break;

            case "leave":
                guiUser.dispose();
                if (guiMain != null) {
                    guiMain.setVisible(true);
                }
                break;
            case "accept":
                if (option == 1) {
                    String id = registerData.getTxtId();
                    String name = registerData.getTxtName();
                    String email = registerData.getTxtEmail();
                    String type = registerData.getJcbType();
                    String password = registerData.getTxtPassword();
                    user = new User(id, name, email, type, password);
                    guiUser.showMessage("Usuario " + userRegister.add(user));
                    registerData.clean();
                } else if (option == 2) {
                    user.setName(registerData.getTxtName());
                    user.setEmail(registerData.getTxtEmail());
                    user.setType(registerData.getJcbType());
                    user.setPassword(registerData.getTxtPassword());
                    guiUser.showMessage(userRegister.edit(user));
                    registerData.clean();
                }
                userTable.setData(userRegister.getData(), User.LABEL_USER);
                registerData.clean();
                registerData.dispose();
                String idUser = user.getId();
                if (userRegister.userType(idUser) == 1 && entry==1) {
                    if (guiMain != null) {
                        guiMain.setVisible(true);
                    }
                } else if (userRegister.userType(idUser) == 1 && entry==2) {
                    guiUser.setVisible(true);
                } else if (userRegister.userType(idUser) == 2 && entry==2){
                    guiUser.setVisible(true);
                } else{
                    storeController.getGuiStore().setVisible(true);
                }
                break;
            case "exitData":
                registerData.dispose();
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String[] row = userTable.getRowSelected();
        if (row != null && row.length > 0) {
            String id = row[0];
            user = userRegister.searchById(id);
        }
        System.out.println("Selecciono: " + user);
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
        userTable.filterById();
    }
}
