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
import controllers.UserProfileControllers;
import interfaces.UserProfileInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Bahasa;
import entities.LowonganPekerjaan;
import entities.Pencapaian;
import entities.Pengalaman;
import entities.Proyek;
import entities.RiwayatPendidikan;
import entities.UserProfile;
import entities.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import tools.getDataLogin;
import tools.getLoginData;

/**
 *
 * @author Nitani
 */
public class MainFrame extends javax.swing.JFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(sessionFactory);
    private UserInterface ai = new UserControllers(sessionFactory);
    private getLoginData ld = new getLoginData();
    private getDataLogin dataLogin = new getDataLogin();
    private UserProfilesView upv = new UserProfilesView();
    private UserViews uv = new UserViews();
    private SertifikatViews sv = new SertifikatViews();
    private LoginViews lv = new LoginViews();
    private KeahlianViews kv = new KeahlianViews();
    private LowonganKerjaViews lkv = new LowonganKerjaViews();
    private BahasaViews bahasas =  new BahasaViews();
    private PencapaianViews pencapaian =  new PencapaianViews();
    private PengalamanViews pengalaman = new PengalamanViews();
    private ProyekViews pv = new ProyekViews();
    private PendidikanViews pendidikanViews = new PendidikanViews();
    private ManagerViews mv = new ManagerViews();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        System.out.println(dataLogin.getUsersId());
        userId.setText(String.valueOf(dataLogin.getUsersId()));
        roleId.setText(String.valueOf(dataLogin.getRole()));
        namaUser.setText(dataLogin.getUsersName());
        if(ai.getIdProfile(dataLogin.getUsersId())){
            getUsersId();
        }
        else{
            JOptionPane.showMessageDialog(null, "Isi profile terlebih dahulu");
            upv.show();
            dsktpMain.add(upv);
        }
        
        roleId.setText(String.valueOf(dataLogin.getRole()));
        if (dataLogin.getRole() == 1) {
            jMenu6.setVisible(false);
        } else if (dataLogin.getRole() == 2) {
            jMenu5.setVisible(false);
        }
    }

    public void profile() {

    }

    public void getUsersId() {
        DateFormat formats = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
        UserProfile users = (UserProfile) ai.getById(dataLogin.getUsersId());
        dataLogin.setUserProfileId(users.getId());
        emailUser.setText(users.getUsersId().getEmail());
        universitasUser.setText("Kosong");
        jurusanUser.setText("Kosong");
        umurUser.setText(String.valueOf(users.getUmur()));
        domisiliUser.setText(users.getAlamat());
        Date birth = users.getTanggalLahir();
        tanggalLahir.setText(formats.format(birth));
        noTelp.setText(String.valueOf(users.getNoTelepon()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        dsktpMain = new javax.swing.JDesktopPane();
        logoutBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        userPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        emailUser = new javax.swing.JLabel();
        universitasUser = new javax.swing.JLabel();
        jurusanUser = new javax.swing.JLabel();
        umurUser = new javax.swing.JLabel();
        domisiliUser = new javax.swing.JLabel();
        tanggalLahir = new javax.swing.JLabel();
        noTelp = new javax.swing.JLabel();
        namaUser1 = new javax.swing.JLabel();
        namaUser = new javax.swing.JLabel();
        roleId = new javax.swing.JLabel();
        userId = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        editProfiles = new javax.swing.JMenuItem();
        sertifikatItem = new javax.swing.JMenuItem();
        lowonganItem = new javax.swing.JMenuItem();
        keahlianItem = new javax.swing.JMenuItem();
        bahasaItem = new javax.swing.JMenuItem();
        pencapaianItem = new javax.swing.JMenuItem();
        pengalamanItem = new javax.swing.JMenuItem();
        projectItem = new javax.swing.JMenuItem();
        pendidikanItem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        managerItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem3.setText("jMenuItem3");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Home");

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");
        jTextField1.setName(""); // NOI18N

        dsktpMain.setLayer(logoutBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsktpMain.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dsktpMainLayout = new javax.swing.GroupLayout(dsktpMain);
        dsktpMain.setLayout(dsktpMainLayout);
        dsktpMainLayout.setHorizontalGroup(
            dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dsktpMainLayout.createSequentialGroup()
                .addContainerGap(711, Short.MAX_VALUE)
                .addGroup(dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn))
                .addContainerGap())
        );
        dsktpMainLayout.setVerticalGroup(
            dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dsktpMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addContainerGap())
        );

        jTextField1.getAccessibleContext().setAccessibleName("");

        userPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Profil"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel2.setText("Email");

        jLabel3.setText("Universitas");

        jLabel4.setText("Jurusan");

        jLabel5.setText("Umur");

        jLabel6.setText("Alamat");

        jLabel7.setText("Tanggal Lahir");

        jLabel8.setText("No Telepon");

        emailUser.setText("Kosong");

        universitasUser.setText("Kosong");

        jurusanUser.setText("Kosong");

        umurUser.setText("Kosong");

        domisiliUser.setText("Kosong");

        tanggalLahir.setText("Kosong");

        noTelp.setText("Kosong");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noTelp)
                    .addComponent(tanggalLahir)
                    .addComponent(domisiliUser)
                    .addComponent(umurUser)
                    .addComponent(emailUser)
                    .addComponent(universitasUser)
                    .addComponent(jurusanUser))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(emailUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(universitasUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jurusanUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(umurUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(domisiliUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tanggalLahir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(noTelp)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        namaUser1.setText("Selamat datang");

        namaUser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        namaUser.setText("Nama");

        roleId.setText("Role");

        userId.setText("Id");

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roleId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userId)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(namaUser1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaUser))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaUser1)
                    .addComponent(namaUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleId)
                    .addComponent(userId))
                .addContainerGap())
        );

        jMenuBar3.setBackground(new java.awt.Color(102, 153, 255));
        jMenuBar3.setToolTipText("");

        jMenu5.setText("User");

        editProfiles.setText("Edit Profil");
        editProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfilesActionPerformed(evt);
            }
        });
        jMenu5.add(editProfiles);

        sertifikatItem.setText("Sertifikat");
        sertifikatItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sertifikatItemActionPerformed(evt);
            }
        });
        jMenu5.add(sertifikatItem);

        lowonganItem.setText("Cari Lowongan");
        lowonganItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowonganItemActionPerformed(evt);
            }
        });
        jMenu5.add(lowonganItem);

        keahlianItem.setText("Keahlian");
        keahlianItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keahlianItemActionPerformed(evt);
            }
        });
        jMenu5.add(keahlianItem);

        bahasaItem.setText("Bahasa");
        bahasaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bahasaItemActionPerformed(evt);
            }
        });
        jMenu5.add(bahasaItem);

        pencapaianItem.setText("Pencapaian");
        pencapaianItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencapaianItemActionPerformed(evt);
            }
        });
        jMenu5.add(pencapaianItem);

        pengalamanItem.setText("Pengalaman");
        pengalamanItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengalamanItemActionPerformed(evt);
            }
        });
        jMenu5.add(pengalamanItem);

        projectItem.setText("Project");
        projectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectItemActionPerformed(evt);
            }
        });
        jMenu5.add(projectItem);

        pendidikanItem.setText("Pendidikan");
        pendidikanItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendidikanItemActionPerformed(evt);
            }
        });
        jMenu5.add(pendidikanItem);

        jMenuBar3.add(jMenu5);

        jMenu6.setText("Admin");

        jMenuItem1.setText("Admin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar3.add(jMenu6);

        jMenu7.setText("Manager");

        managerItem.setText("Manager");
        managerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerItemActionPerformed(evt);
            }
        });
        jMenu7.add(managerItem);

        jMenuBar3.add(jMenu7);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dsktpMain))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dsktpMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        lkv.show();
        dsktpMain.add(lkv);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void editProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfilesActionPerformed
        // TODO add your handling code here:
        if (editProfiles.getText() == "Edit Profil") {
            upv.show();
            dsktpMain.add(upv);
        } else {
            upv.show();
            dsktpMain.add(upv);
        }
    }//GEN-LAST:event_editProfilesActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Yakin ingin logout?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            lv.show();
            this.dispose();
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void lowonganItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowonganItemActionPerformed
        // TODO add your handling code here:
        uv.show();
        dsktpMain.add(uv);
    }//GEN-LAST:event_lowonganItemActionPerformed

    private void sertifikatItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sertifikatItemActionPerformed
        // TODO add your handling code here:
        sv.show();
        dsktpMain.add(sv);
    }//GEN-LAST:event_sertifikatItemActionPerformed

    private void keahlianItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keahlianItemActionPerformed
        // TODO add your handling code here:
        kv.show();
        dsktpMain.add(kv);
    }//GEN-LAST:event_keahlianItemActionPerformed

    private void pencapaianItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencapaianItemActionPerformed
        // TODO add your handling code here:
        pencapaian.show();
        dsktpMain.add(pencapaian);
    }//GEN-LAST:event_pencapaianItemActionPerformed

    private void bahasaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bahasaItemActionPerformed
        // TODO add your handling code here:
        bahasas.show();
        dsktpMain.add(bahasas);
    }//GEN-LAST:event_bahasaItemActionPerformed

    private void pengalamanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengalamanItemActionPerformed
        // TODO add your handling code here:
        pengalaman.show();
        dsktpMain.add(pengalaman);
    }//GEN-LAST:event_pengalamanItemActionPerformed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        getUsersId();
    }//GEN-LAST:event_jPanel2MouseEntered

    private void projectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectItemActionPerformed
        // TODO add your handling code here:
        pv.show();
        dsktpMain.add(pv);
    }//GEN-LAST:event_projectItemActionPerformed

    private void pendidikanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendidikanItemActionPerformed
        // TODO add your handling code here:
        pendidikanViews.show();
        dsktpMain.add(pendidikanViews);
    }//GEN-LAST:event_pendidikanItemActionPerformed

    private void managerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerItemActionPerformed
        // TODO add your handling code here:
        mv.show();
        dsktpMain.add(mv);
    }//GEN-LAST:event_managerItemActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bahasaItem;
    private javax.swing.JLabel domisiliUser;
    private javax.swing.JDesktopPane dsktpMain;
    private javax.swing.JMenuItem editProfiles;
    private javax.swing.JLabel emailUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jurusanUser;
    private javax.swing.JMenuItem keahlianItem;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JMenuItem lowonganItem;
    private javax.swing.JMenuItem managerItem;
    private javax.swing.JLabel namaUser;
    private javax.swing.JLabel namaUser1;
    private javax.swing.JLabel noTelp;
    private javax.swing.JMenuItem pencapaianItem;
    private javax.swing.JMenuItem pendidikanItem;
    private javax.swing.JMenuItem pengalamanItem;
    private javax.swing.JMenuItem projectItem;
    private javax.swing.JLabel roleId;
    private javax.swing.JMenuItem sertifikatItem;
    private javax.swing.JLabel tanggalLahir;
    private javax.swing.JLabel umurUser;
    private javax.swing.JLabel universitasUser;
    private javax.swing.JLabel userId;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
