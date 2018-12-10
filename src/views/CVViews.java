/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.BahasaControllers;
import controllers.KeahlianControllers;
import controllers.LowonganKerjaControllers;
import controllers.PencapaianControllers;
import controllers.PendidikanControllers;
import controllers.PengalamanControllers;
import controllers.ProyekControllers;
import controllers.UserControllers;
import entities.Bahasa;
import entities.Pengalaman;
import entities.RiwayatPendidikan;
import entities.Keahlian;
import entities.Pencapaian;
import entities.Proyek;
import entities.UserProfile;
import interfaces.BahasaInterface;
import interfaces.KeahlianInterface;
import interfaces.LowonganKerjaInterface;
import interfaces.PencapaianInterface;
import interfaces.PendidikanInterface;
import interfaces.PengalamanInterface;
import interfaces.ProyekInterface;
import interfaces.UserInterface;
import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class CVViews extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private getLoginData data = new getLoginData(sessionFactory);
    private getDataLogin dataLogin = new getDataLogin();
    private LowonganKerjaInterface lki = new LowonganKerjaControllers(sessionFactory);
    private PendidikanInterface pi = new PendidikanControllers(sessionFactory);
    private PengalamanInterface pin = new PengalamanControllers(sessionFactory);
    private KeahlianInterface ki = new KeahlianControllers(sessionFactory);
    private PencapaianInterface pint = new PencapaianControllers(sessionFactory);
    private BahasaInterface bi = new BahasaControllers(sessionFactory);
    private ProyekInterface p = new ProyekControllers(sessionFactory);
    private UserInterface ai = new UserControllers(sessionFactory);

    /**
     * Creates new form CVViews
     */
    public CVViews() {
        initComponents();
        getUsersId();
        bindingTableBahasa(bi.search(String.valueOf(dataLogin.getUsersId())));
        bindingTableKeahlian(ki.search(String.valueOf(dataLogin.getUsersId())));
        bindingTablePencapaian(pint.search(String.valueOf(dataLogin.getUsersId())));
        bindingTablePendidikan(pi.search(String.valueOf(dataLogin.getUsersId())));
        bindingTablePengalaman(pin.search(String.valueOf(dataLogin.getUsersId())));
        bindingTableProyek(p.search(String.valueOf(dataLogin.getUsersId())));
    }

    public void getUsersId() {
        DateFormat formats = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
        UserProfile users = (UserProfile) ai.getById(dataLogin.getUsersId());
//        dataLogin.setUserProfileId(users.getId());
//        emailUser1.setText(users.getUsersId().getEmail());
//        umurUser1.setText(String.valueOf(users.getUmur()));
//        domisiliUser1.setText(users.getAlamat());
//        Date birth = users.getTanggalLahir();
//        tanggalLahir1.setText(formats.format(birth));
//        noTelp1.setText(String.valueOf(users.getNoTelepon()));
//        gambar.setText(String.valueOf(users.getCv()));

    }

    public void bindingTablePendidikan(List<Object> lowongan) {
        Object[] header = {"Nama", "Jurusan", "Organisasi", "IPK"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getPendidikan.setModel(model);
        try {
            for (Object low : lowongan) {
                RiwayatPendidikan emp = (RiwayatPendidikan) low;

                String kolom[] = {emp.getNama(), emp.getJurusan(), emp.getOrganisasi(), String.valueOf(emp.getIpk())};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    public void bindingTablePengalaman(List<Object> lowongan) {
        Object[] header = {"Judul", "Perusahaan", "Lama Bekerja"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getPengalaman.setModel(model);
        try {
            for (Object low : lowongan) {
                Pengalaman emp = (Pengalaman) low;

                String kolom[] = {emp.getNama(), emp.getPerusahaan(), emp.getLamaBekerja()};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    public void bindingTableKeahlian(List<Object> lowongan) {
        Object[] header = {"Nama", "Deskripsi"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getKeahlian.setModel(model);
        try {
            for (Object low : lowongan) {
                Keahlian emp = (Keahlian) low;

                String kolom[] = {emp.getNama(), emp.getDeskripsi()};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    public void bindingTablePencapaian(List<Object> lowongan) {
        Object[] header = {"Nama", "Deskripsi"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getPencapaian.setModel(model);
        try {
            for (Object low : lowongan) {
                Pencapaian emp = (Pencapaian) low;

                String kolom[] = {emp.getNama(), emp.getDeskripsi()};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    public void bindingTableProyek(List<Object> lowongan) {
        Object[] header = {"Judul", "Deskripsi", "Lama Bekerja"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getProyek.setModel(model);
        try {
            for (Object low : lowongan) {
                Proyek emp = (Proyek) low;

                String kolom[] = {emp.getNama(), emp.getDeskripsi(), emp.getStatus()};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    public void bindingTableBahasa(List<Object> bahasa) {
        Object[] header = {"Bahasa"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getBahasa.setModel(model);
        try {
            for (Object low : bahasa) {
                Bahasa emp = (Bahasa) low;

                String kolom[] = {emp.getNama()};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        emailUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        umurUser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        domisiliUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tanggalLahir = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        noTelp = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        gambar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailUser1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        umurUser1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        domisiliUser1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tanggalLahir1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        noTelp1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dwa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        getPendidikan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        getPengalaman = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        getKeahlian = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        getPencapaian = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        getProyek = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        getBahasa = new javax.swing.JTable();

        jLabel2.setText("Email");

        emailUser.setText("Kosong");

        jLabel5.setText("Umur");

        umurUser.setText("Kosong");

        jLabel6.setText("Alamat");

        domisiliUser.setText("Kosong");

        jLabel7.setText("Tanggal Lahir");

        tanggalLahir.setText("Kosong");

        jLabel8.setText("No Telepon");

        noTelp.setText("Kosong");

        setClosable(true);
        setResizable(true);
        setTitle("Curriculum Vitae");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Profile"));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        gambar.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambar, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setText("Email");

        emailUser1.setText("Kosong");

        jLabel9.setText("Umur");

        umurUser1.setText("Kosong");

        jLabel10.setText("Alamat");

        domisiliUser1.setText("Kosong");

        jLabel11.setText("Tanggal Lahir");

        tanggalLahir1.setText("Kosong");

        jLabel12.setText("No Telepon");

        noTelp1.setText("Kosong");

        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noTelp1)
                            .addComponent(tanggalLahir1)
                            .addComponent(domisiliUser1)
                            .addComponent(umurUser1)
                            .addComponent(emailUser1))
                        .addGap(149, 149, 149))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(emailUser1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(umurUser1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(domisiliUser1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tanggalLahir1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noTelp1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dwa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pendidikan"));

        getPendidikan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jurusan", "Organisasi", "IPK"
            }
        ));
        jScrollPane2.setViewportView(getPendidikan);
        if (getPendidikan.getColumnModel().getColumnCount() > 0) {
            getPendidikan.getColumnModel().getColumn(2).setHeaderValue("Organisasi");
            getPendidikan.getColumnModel().getColumn(3).setHeaderValue("IPK");
        }

        javax.swing.GroupLayout dwaLayout = new javax.swing.GroupLayout(dwa);
        dwa.setLayout(dwaLayout);
        dwaLayout.setHorizontalGroup(
            dwaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dwaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        dwaLayout.setVerticalGroup(
            dwaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dwaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pengalaman"));
        jPanel3.setToolTipText("");

        getPengalaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Judul", "Perusahaan", "Lama Bekerja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(getPengalaman);
        if (getPengalaman.getColumnModel().getColumnCount() > 0) {
            getPengalaman.getColumnModel().getColumn(1).setHeaderValue("Perusahaan");
            getPengalaman.getColumnModel().getColumn(2).setHeaderValue("Lama Bekerja");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Keahlian"));
        jPanel6.setToolTipText("");

        getKeahlian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama", "Deskripsi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(getKeahlian);
        if (getKeahlian.getColumnModel().getColumnCount() > 0) {
            getKeahlian.getColumnModel().getColumn(1).setHeaderValue("Perusahaan");
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencapaian"));

        getPencapaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama", "Deskripsi"
            }
        ));
        jScrollPane6.setViewportView(getPencapaian);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyek"));
        jPanel9.setToolTipText("");

        getProyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Judul", "Perusahaan", "Lama Bekerja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(getProyek);
        if (getProyek.getColumnModel().getColumnCount() > 0) {
            getProyek.getColumnModel().getColumn(1).setHeaderValue("Perusahaan");
            getProyek.getColumnModel().getColumn(2).setHeaderValue("Lama Bekerja");
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Bahasa"));
        jPanel11.setToolTipText("");

        getBahasa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(getBahasa);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dwa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dwa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        ImageIcon icon = new ImageIcon(filename);
        gambar.setIcon(icon);
        Image image = icon.getImage().getScaledInstance(gambar.getWidth(), gambar.getHeight(), Image.SCALE_SMOOTH);
        gambar.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel domisiliUser;
    private javax.swing.JLabel domisiliUser1;
    private javax.swing.JPanel dwa;
    private javax.swing.JLabel emailUser;
    private javax.swing.JLabel emailUser1;
    private javax.swing.JLabel gambar;
    private javax.swing.JTable getBahasa;
    private javax.swing.JTable getKeahlian;
    private javax.swing.JTable getPencapaian;
    private javax.swing.JTable getPendidikan;
    private javax.swing.JTable getPengalaman;
    private javax.swing.JTable getProyek;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel noTelp;
    private javax.swing.JLabel noTelp1;
    private javax.swing.JLabel tanggalLahir;
    private javax.swing.JLabel tanggalLahir1;
    private javax.swing.JLabel umurUser;
    private javax.swing.JLabel umurUser1;
    // End of variables declaration//GEN-END:variables
}
