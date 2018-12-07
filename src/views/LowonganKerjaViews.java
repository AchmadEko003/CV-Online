/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.LowonganKerjaControllers;
import interfaces.LowonganKerjaInterface;
import controllers.UserControllers;
import interfaces.UserInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
import entities.Users;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Nitani
 */
public class LowonganKerjaViews extends javax.swing.JInternalFrame {

    private JButton buttons;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(sessionFactory);
    private LowonganKerjaInterface lki = new LowonganKerjaControllers(sessionFactory);

    /**
     * Creates new form LowonganKerjaViews
     */
    public LowonganKerjaViews() {
        initComponents();
        bindingTable(lki.search(""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        perusahaanTxt = new javax.swing.JTextField();
        judulLowonganTxt = new javax.swing.JTextField();
        requirementsTxt = new javax.swing.JTextField();
        lowonganIdTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tambahBtn = new javax.swing.JButton();
        deskripsiTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        getIdTable = new javax.swing.JTable();
        searchTxt = new javax.swing.JTextField();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setTitle("Admin");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Input Lowongan"));

        id.setText("ID");

        email.setText("Requirements");

        role.setText("Perusahaan");

        username.setText("Judul Lowongan");

        perusahaanTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perusahaanTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Deskripsi Pekerjaan");

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(username)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lowonganIdTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(judulLowonganTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(role)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(perusahaanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(requirementsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deskripsiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowonganIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judulLowonganTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deskripsiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requirementsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(role)
                    .addComponent(perusahaanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tambahBtn)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        getIdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Judul Lowongan", "Deskripsi", "Requirements", "Perusahaan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(getIdTable);
        if (getIdTable.getColumnModel().getColumnCount() > 0) {
            getIdTable.getColumnModel().getColumn(0).setResizable(false);
            getIdTable.getColumnModel().getColumn(1).setResizable(false);
            getIdTable.getColumnModel().getColumn(2).setResizable(false);
            getIdTable.getColumnModel().getColumn(3).setResizable(false);
            getIdTable.getColumnModel().getColumn(4).setResizable(false);
        }

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perusahaanTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perusahaanTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perusahaanTxtActionPerformed

    public void bindingTable(List<Object> lowongan) {
        Object[] header = {"No", "Judul Lowongan", "Deskripsi", "Requirements", "Perusahaan"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getIdTable.setModel(model);
        
        try {
            for (Object low : lowongan) {
                LowonganPekerjaan emp = (LowonganPekerjaan) low;
//                String isi1 = String.valueOf(emp.getLowonganPekerjaanId());
//                String isi2 = emp.getJudulLowongan();
//                String isi3 = emp.getDeskripsiPekerjaan();
//                String isi4 = emp.getRequirements();
//                String isi5 = emp.getPerusahaanId().getNamaPerusahaan();
                
//                String kolom[] = {isi1, isi2, isi3, isi4, isi5};
//                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }
    
    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        String id = lowonganIdTxt.getText();
        String judul = judulLowonganTxt.getText();
        String deskripsi = deskripsiTxt.getText();
        String requirements = requirementsTxt.getText();
        String perusahaan = perusahaanTxt.getText();
//        String userId = idUser.getText();
        
//        if(lki.insert(id, judul, deskripsi, requirements, perusahaan)){
//            JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Gagal menambahkan");
//        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
        bindingTable(lki.search(searchTxt.getText()));
    }//GEN-LAST:event_searchTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField deskripsiTxt;
    private javax.swing.JLabel email;
    private javax.swing.JTable getIdTable;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judulLowonganTxt;
    private javax.swing.JTextField lowonganIdTxt;
    private java.awt.Panel panel1;
    private javax.swing.JTextField perusahaanTxt;
    private javax.swing.JTextField requirementsTxt;
    private javax.swing.JLabel role;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
