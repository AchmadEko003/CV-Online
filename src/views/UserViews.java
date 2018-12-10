/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ApplyControllers;
import controllers.LowonganKerjaControllers;
import controllers.SertifikatControllers;
import controllers.UserControllers;
import controllers.UserProfileControllers;
import interfaces.LowonganKerjaInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Apply;
import entities.LowonganPekerjaan;
import interfaces.ApplyInterface;
import interfaces.SertifikatInterface;
import interfaces.UserInterface;
import interfaces.UserProfileInterface;
import java.awt.BorderLayout;
import java.awt.Container;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import tools.getDataLogin;
import tools.getLoginData;

/**
 *
 * @author Nitani
 */
public class UserViews extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private SertifikatInterface si = new SertifikatControllers(sessionFactory);
    private getLoginData ld = new getLoginData(sessionFactory);
    private getDataLogin dl = new getDataLogin();
    private ApplyInterface ai = new ApplyControllers(sessionFactory);
    private LowonganKerjaInterface lki = new LowonganKerjaControllers(sessionFactory);
    private UserInterface ui = new UserControllers(sessionFactory);
    private UserProfileInterface uip = new UserProfileControllers(sessionFactory);
    private UserProfilesView upv = new UserProfilesView();

    /**
     * Creates new form UserViews
     */
    public UserViews() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        tambahTxt = new javax.swing.JButton();
        lowonganTxt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reqTxt = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        deskripsiTxt = new javax.swing.JTextArea();
        perusahaanTxt = new javax.swing.JLabel();
        role1 = new javax.swing.JLabel();
        tanggalMulaiTxt = new javax.swing.JLabel();
        role2 = new javax.swing.JLabel();
        tanggalSelesaiTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        getIdTable = new javax.swing.JTable();
        searchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cari Lowongan");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lowongan"));

        jLabel1.setText("Deskripsi");

        email.setText("Requirements");

        role.setText("Perusahaan");

        username.setText("Judul Lowongan");

        tambahTxt.setText("Apply");
        tambahTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahTxtActionPerformed(evt);
            }
        });

        lowonganTxt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lowonganTxt.setText("Kosong");

        reqTxt.setColumns(20);
        reqTxt.setRows(5);
        reqTxt.setEnabled(false);
        jScrollPane2.setViewportView(reqTxt);

        deskripsiTxt.setColumns(20);
        deskripsiTxt.setRows(5);
        deskripsiTxt.setEnabled(false);
        jScrollPane3.setViewportView(deskripsiTxt);

        perusahaanTxt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        perusahaanTxt.setText("Kosong");

        role1.setText("Tanggal Mulai");

        tanggalMulaiTxt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tanggalMulaiTxt.setText("Kosong");

        role2.setText("Tanggal Selesai");

        tanggalSelesaiTxt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tanggalSelesaiTxt.setText("Kosong");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lowonganTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(perusahaanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tanggalMulaiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tanggalSelesaiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(jLabel1)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(role)
                            .addComponent(role1)
                            .addComponent(role2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowonganTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(role)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(perusahaanTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(role1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalMulaiTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(role2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalSelesaiTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambahTxt)
                .addContainerGap())
        );

        getIdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Lowongan", "Deskripsi", "Requirements", "Perusahaan", "Tanggal Mulai", "Tanggal Selesai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        getIdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getIdTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(getIdTable);

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        jLabel2.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahTxtActionPerformed
        // TODO add your handling code here:
        int i = getIdTable.getSelectedRow();
        TableModel model = getIdTable.getModel();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Ingin apply lowongan ini?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (ai.Apply(String.valueOf(ld.getTotal(new Apply()).size() + 1), "Apply", model.getValueAt(i, 0).toString(), String.valueOf(dl.getUsersId()))) {
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
                tambahTxt.setEnabled(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Data masih kosong");
            }
        }
    }//GEN-LAST:event_tambahTxtActionPerformed

    private void getIdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getIdTableMouseClicked
        // TODO add your handling code here:
        int i = getIdTable.getSelectedRow();
        TableModel model = getIdTable.getModel();
        lowonganTxt.setText(model.getValueAt(i, 1).toString());
        deskripsiTxt.setText(model.getValueAt(i, 2).toString());
        reqTxt.setText(model.getValueAt(i, 3).toString());
        perusahaanTxt.setText(model.getValueAt(i, 4).toString());
        tanggalMulaiTxt.setText(model.getValueAt(i, 5).toString());
        tanggalSelesaiTxt.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_getIdTableMouseClicked

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
        bindingTable(uip.search(searchTxt.getText()));
    }//GEN-LAST:event_searchTxtKeyReleased

    public void bindingTable(List<Object> apply) {
        Object[] header = {"No", "Judul Lowongan", "Deskripsi", "Requirements", "Perusahaan", "Tanggal Mulai", "Tanggal Selesai"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getIdTable.setModel(model);
        DateFormat formats = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH);
        try {
            for (Object low : apply) {
                LowonganPekerjaan emp = (LowonganPekerjaan) low;
                String isi1 = String.valueOf(emp.getId());
                String isi2 = String.valueOf(emp.getJudul());
                String isi3 = emp.getDeskripsi();
                String isi4 = emp.getRequirements();
                String isi5 = emp.getPerusahaan();
                String isi6 = formats.format(emp.getTanggal()) + "";
                String isi7 = formats.format(emp.getTanggalSelesai()) + "";

                String kolom[] = {isi1, isi2, isi3, isi4, isi5, isi6, isi7};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea deskripsiTxt;
    private javax.swing.JLabel email;
    private javax.swing.JTable getIdTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lowonganTxt;
    private javax.swing.JLabel perusahaanTxt;
    private javax.swing.JTextArea reqTxt;
    private javax.swing.JLabel role;
    private javax.swing.JLabel role1;
    private javax.swing.JLabel role2;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton tambahTxt;
    private javax.swing.JLabel tanggalMulaiTxt;
    private javax.swing.JLabel tanggalSelesaiTxt;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
