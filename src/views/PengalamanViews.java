/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.PencapaianControllers;
import controllers.PengalamanControllers;
import entities.Pencapaian;
import entities.Pengalaman;
import interfaces.PencapaianInterface;
import interfaces.PengalamanInterface;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import tools.getDataLogin;
import tools.getLoginData;

/**
 *
 * @author Nitani
 */
public class PengalamanViews extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private getLoginData data = new getLoginData(sessionFactory);
    private getDataLogin dataLogin = new getDataLogin();
    private PengalamanInterface pi = new PengalamanControllers(sessionFactory);

    /**
     * Creates new form PengalamanViews
     */
    public PengalamanViews() {
        initComponents();
    }

    public void clearText() {
        txtJudul.setText("");
        txtPerusahaan.setText("");
        lamaBekerjaCmbBx.setSelectedItem("Pilih lama bekerja");
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
        lamaBekerjaCmbBx = new javax.swing.JComboBox<>();
        tambahBtn = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtJudul = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPerusahaan = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pengalaman");

        jLabel1.setText("Judul");

        jLabel2.setText("Perusahaan");

        jLabel3.setText("Lama Bekerja");

        lamaBekerjaCmbBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 1 Tahun", "1 Tahun", "2 Tahun", "3 Tahun", "> 3 Tahun" }));
        lamaBekerjaCmbBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamaBekerjaCmbBxActionPerformed(evt);
            }
        });

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtJudul.setColumns(20);
        txtJudul.setRows(5);
        jScrollPane1.setViewportView(txtJudul);

        txtPerusahaan.setColumns(20);
        txtPerusahaan.setRows(5);
        jScrollPane2.setViewportView(txtPerusahaan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahBtn)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(lamaBekerjaCmbBx, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lamaBekerjaCmbBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahBtn)
                    .addComponent(btnClear))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        String nama = txtJudul.getText();
        String perusahaan = txtPerusahaan.getText();
        String lamaBekerja = String.valueOf(lamaBekerjaCmbBx.getSelectedItem());

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Data akan di tambah?",
                "Insert Data", dialogButton);
        if (dialogResult == 0) {
            if (!nama.equals("") && !perusahaan.equals("") && !lamaBekerja.isEmpty()) {
                if (pi.insert(String.valueOf(data.getTotal(new Pengalaman()).size() + 1), txtJudul.getText(), txtPerusahaan.getText(),
                        String.valueOf(lamaBekerjaCmbBx.getSelectedItem()), String.valueOf(dataLogin.getUsersId()))) {
                    JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal!", "Message Alert",
                        JOptionPane.WARNING_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(null, "form tidak boleh kosong!", "Message Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        } 
        clearText();
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void lamaBekerjaCmbBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamaBekerjaCmbBxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lamaBekerjaCmbBxActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearText();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> lamaBekerjaCmbBx;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JTextArea txtJudul;
    private javax.swing.JTextArea txtPerusahaan;
    // End of variables declaration//GEN-END:variables
}
