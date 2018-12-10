/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.PendidikanControllers;
import entities.RiwayatPendidikan;
import interfaces.PendidikanInterface;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import tools.getDataLogin;
import tools.getLoginData;

/**
 *
 * @author Nitani
 */
public class PendidikanViews extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private getLoginData data = new getLoginData(sessionFactory);
    private getDataLogin dataLogin = new getDataLogin();
    private PendidikanInterface pi = new PendidikanControllers(sessionFactory);

    /**
     * Creates new form PendidikanViews
     */
    public PendidikanViews() {
        initComponents();
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
        pendidikanTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        programStudi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        organisasiTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ipkTxt = new javax.swing.JTextField();
        tambahBtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Pendidikan");

        jLabel1.setText("Nama Universitas");

        jLabel2.setText("Program Studi");

        jLabel3.setText("Organisasi");

        jLabel4.setText("IPK");

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(programStudi, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(pendidikanTxt)
                    .addComponent(organisasiTxt)
                    .addComponent(ipkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendidikanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programStudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(organisasiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tambahBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Ingin menambah data?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (pi.insert(String.valueOf(data.getTotal(new RiwayatPendidikan()).size() + 1), pendidikanTxt.getText(), programStudi.getText(), organisasiTxt.getText(), ipkTxt.getText(), String.valueOf(dataLogin.getUserProfileId()))) {
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
                pendidikanTxt.setText("");
                programStudi.setText("");
                organisasiTxt.setText("");
                ipkTxt.setText("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Data masih kosong");
            }
        }
    }//GEN-LAST:event_tambahBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ipkTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField organisasiTxt;
    private javax.swing.JTextField pendidikanTxt;
    private javax.swing.JTextField programStudi;
    private javax.swing.JButton tambahBtn;
    // End of variables declaration//GEN-END:variables
}
