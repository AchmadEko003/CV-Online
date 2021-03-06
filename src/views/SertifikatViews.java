/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.SertifikatControllers;
import controllers.UserControllers;
import entities.Sertifikat;
import interfaces.SertifikatInterface;
import interfaces.UserInterface;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import tools.getDataLogin;
import tools.getLoginData;

/**
 *
 * @author Nitani
 */
public class SertifikatViews extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    SertifikatInterface si = new SertifikatControllers(sessionFactory);
    getLoginData ld = new getLoginData(sessionFactory);
    getDataLogin dl = new getDataLogin();
    UserInterface ai = new UserControllers(sessionFactory);

    /**
     * Creates new form SertifikatViews
     */
    public SertifikatViews() {
        initComponents();
//        jLabel3.setText(String.valueOf(dl.getUsersId()));
    }

    public void clearText() {
        txtNama.setText("");
        txtLembaga.setText("");
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
        simpanBtn = new javax.swing.JToggleButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNama = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLembaga = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Sertifikat");

        jLabel1.setText("Nama");

        jLabel2.setText("Lembaga");

        simpanBtn.setText("Tambah");
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtNama.setColumns(20);
        txtNama.setRows(5);
        jScrollPane1.setViewportView(txtNama);

        txtLembaga.setColumns(20);
        txtLembaga.setRows(5);
        jScrollPane2.setViewportView(txtLembaga);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpanBtn)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanBtn)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        String idu = String.valueOf(ld.getTotal(new Sertifikat()).size() + 1);
        String nama = txtNama.getText();
        String lembaga = txtLembaga.getText();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Data akan di Tambah?",
                "Insert Data", dialogButton);
        if (dialogResult == 0) {
            if (!nama.equals("") && !lembaga.equals("")) {
                if (si.insert(idu, txtNama.getText(), lembaga, String.valueOf(dl.getUsersId()))) {
                    JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal!", "Message Alert",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Form tidak boleh Kosong!", "Message Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearText();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton simpanBtn;
    private javax.swing.JTextArea txtLembaga;
    private javax.swing.JTextArea txtNama;
    // End of variables declaration//GEN-END:variables
}
