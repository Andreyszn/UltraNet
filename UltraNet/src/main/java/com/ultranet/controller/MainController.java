/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.controller;

import com.ultranet.model.User;
import com.ultranet.model.UserRecord;
import com.ultranet.view.GUIMain;
import com.ultranet.view.LoginData;
import com.ultranet.view.RegisterUserData;
import com.ultranet.view.user.GUIUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Blaith
 */
public class MainController implements ActionListener {

    private GUIMain guiMain;
    private HardwareController hardwareController;
    private UserController userController;
    private GUIUser guiUser;
    private LoginData loginData;
    private RegisterUserData registerData;
    private User user;
    private UserRecord userRegister;
    private StoreController storeController;

    public MainController() {
        userRegister = new UserRecord();
        guiMain = new GUIMain(this);
        hardwareController = new HardwareController();
        hardwareController.setGuiMain(guiMain);
        guiUser = new GUIUser(this);
        storeController = new StoreController();
        storeController.setGuiMain(guiMain);
        userController = new UserController();
        userController.setGuiMain(guiMain);
        registerData = new RegisterUserData(guiMain, true);
        registerData.listen(this);
        loginData = new LoginData(guiMain, true);
        loginData.listen(this);
        loginData.setVisible(true);
    }

    public GUIMain getGuiMain() {
        return guiMain;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "loginUser":            
                String id = loginData.getTxtId();
                String name = loginData.getTxtName();
                String password = loginData.getTxtPassword();
                if (validation()) {
                    if (validationLogin(id, name, password)) {
                        if (userRegister.userType(id) == 1) {
                            loginData.dispose();
                            guiMain.setVisible(true);
                        } else if (userRegister.userType(id) == 2) {
                            loginData.dispose();
                            storeController.getGuiStore().setVisible(true);
                        }
                    }
                }
                break;
            case "exitSystem":
                System.exit(0);
                break;
            case "adminLogin":
                guiMain.dispose();
                hardwareController.getGuiHardware().setVisible(true);
                break;
            case "usersLogin":
                guiMain.dispose();
                userController.getGuiUser().setVisible(true);
                break;
            case "login":
                guiMain.dispose();
                userController.getRegisterUser().setVisible(true);
                break;
            case "accept":
                id = registerData.getTxtId();
                name = registerData.getTxtName();
                String email = registerData.getTxtEmail();
                String type = registerData.getJcbType();
                password = registerData.getTxtPassword();
                user = new User(id, name, email, type, password);
                guiUser.showMessage(userRegister.add(user));
                registerData.clean();
                break;
            case "exitData":
                registerData.dispose();
                guiMain.setVisible(true);
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public boolean validation() {
        if (loginData.getTxtId().equalsIgnoreCase("")) {
            guiMain.showMessage("Por favor rellene el espacio de ID");
            return false;
        } else if (loginData.getTxtName().equalsIgnoreCase("")) {
            guiMain.showMessage("Por favor rellene el espacio de Username");
            return false;
        } else if (loginData.getTxtPassword().equalsIgnoreCase("")) {
            guiMain.showMessage("Por favor rellene el espacio de Password");
            return false;
        } else {
            return true;
        }
    }

    public boolean validationLogin(String id, String name, String password) {
        user = userRegister.search(id);
        if (user != null) {
            if (!user.getName().equalsIgnoreCase(name)) {
                guiMain.showMessage("El id no coincide con el nombre de usuario");
                return false;
            } else if (!user.getPassword().equals(password)) {
                guiMain.showMessage("La contraseña ingresada no es correcta");
                return false;
            } else {
                guiMain.showMessage("Bienvenido " + user.getName());
                return true;
            }
        } else {
            guiMain.showMessage("No se encontro ningun usuario relacionado al ID");
            return false;
        }
    }
}
