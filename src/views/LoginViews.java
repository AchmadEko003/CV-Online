/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.UserControllers;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Users;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import tools.BCrypt;
import tools.HibernateUtil;
import interfaces.UserInterface;
import tools.Mail;
import tools.getDataLogin;
import tools.getLoginData;

/**
 *
 * @author Nitani
 */
public class LoginViews extends javax.swing.JFrame {

    private JButton buttons;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(sessionFactory);
    private UserInterface ai = new UserControllers(sessionFactory);
    getLoginData ld = new getLoginData(sessionFactory);
    getDataLogin dataLogin = new getDataLogin();
    Mail m = new Mail();
    getLoginData data = new getLoginData(sessionFactory);

    /**
     * Creates new form LoginViews
     */
    public LoginViews() {
        initComponents();
        emailTxt.setVisible(false);
        emails.setVisible(false);
        email.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        email = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        btnLogReg = new javax.swing.JButton();
        passwordTxt = new javax.swing.JPasswordField();
        namaTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        notifEmail = new javax.swing.JLabel();
        emails = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CV Online");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        email.setText("E-Mail");

        username.setText("Username");

        btnLogReg.setText("Login");
        btnLogReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogRegActionPerformed(evt);
            }
        });

        passwordTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        namaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        emailTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTxtKeyReleased(evt);
            }
        });

        jLabel1.setText("Password");

        emails.setText("Format harus E-mail");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(username)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(namaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(btnLogReg, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(notifEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(emails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notifEmail)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyReleased
        // TODO add your handling code here:
        if (ld.emailMatch(emailTxt.getText())) {
            emails.setVisible(false);
        } else {
            emails.setVisible(true);
        }
    }//GEN-LAST:event_emailTxtKeyReleased

    private void btnLogRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogRegActionPerformed
        // TODO add your handling code here:
        String name = namaTxt.getText();
        String emails = emailTxt.getText();
        String password = passwordTxt.getText();
        if (btnLogReg.getText() == "Login") {
            if (ai.login(name, password)) {
                Integer a = ld.getUserId(name);
                dataLogin.setUsersId(a);
                dataLogin.setUsersName(name);
                dataLogin.setRole(data.getRoleId(name));
                JOptionPane.showMessageDialog(null, "Berhasil login");
                MainFrame mf = new MainFrame();
                mf.show();
                this.dispose();
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Gagal, ingin membuat akun?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    btnLogReg.setText("Register");
                    jPanel1.setName("Register");
                    emailTxt.setVisible(true);
                    email.setVisible(true);
                }
            }
        } else {
//            String edu = String.valueOf(data.getTotal(new Users()).size() + 1);
            if (ai.register("", name, emails, BCrypt.hashpw(password, BCrypt.gensalt()))) {
                JOptionPane.showMessageDialog(null, "Berhasil register");
                m.Send(emails, password);
                btnLogReg.setText("Login");
                namaTxt.setText("");
                emailTxt.setText("");
                passwordTxt.setText("");
                emailTxt.setVisible(false);
                email.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            }
        }
        //JOptionPane.showMessageDialog(null, result);
    }//GEN-LAST:event_btnLogRegActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginViews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogReg;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel emails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField namaTxt;
    private javax.swing.JLabel notifEmail;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
