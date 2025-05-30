/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ultranet.view;

import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Blaith
 */
public class RegisterUserData extends javax.swing.JDialog {

    /**
     * Creates new form UserData
     */
    public RegisterUserData(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public String getTxtUser() {
        return txtId.getText();
    }

    public void setTxtUser(String txtUser) {
        this.txtId.setText(txtUser);
    }

    public String getTxtId() {
        return txtId.getText();
    }

    public void setTxtId(String txtId) {
        this.txtId.setText(txtId);
    }

    public String getTxtEmail() {
        return txtEmail.getText();
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public String getTxtName() {
        return txtName.getText();
    }

    public void setTxtName(String txtName) {
        this.txtName.setText(txtName);
    }

    public String getJcbType() {
        return jcbType.getSelectedItem().toString();
    }

    public void setJcbType(String type) {
        this.jcbType.setSelectedItem(type);
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword.setText(txtPassword);
    }
    
    public void listen(ActionListener controller) {
        btnAccept.addActionListener(controller);
        btnExit.addActionListener(controller);
    }

    public void clean() {
        setTxtUser("");
        setTxtName("");
        setTxtId("");
        setTxtEmail("");
        setTxtPassword("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jcbType = new javax.swing.JComboBox<>();
        btnAccept = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 48)); // NOI18N
        jLabel1.setText("UltraNet");

        jLabel2.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel3.setText("Type");

        jLabel4.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel4.setText("Identification");

        txtId.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N

        txtName.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N

        jcbType.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jcbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Administrator" }));

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accept.png"))); // NOI18N
        btnAccept.setActionCommand("accept");
        btnAccept.setBorderPainted(false);
        btnAccept.setContentAreaFilled(false);
        btnAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnExit.setActionCommand("exitData");
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel5.setText("Email");

        txtEmail.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel6.setText("Password");

        txtPassword.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnAccept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbType, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAccept)
                    .addComponent(btnExit))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                LoginData dialog = new LoginData(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jcbType;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
