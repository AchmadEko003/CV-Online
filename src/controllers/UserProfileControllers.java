/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Userprofile;
import entities.Users;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class UserProfileControllers implements UserProfileInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public UserProfileControllers() {
    }

    public UserProfileControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    public boolean inputdata(String cvId, String cvUpload, String uploadPhoto, String uploadKtp, String namaUniversitas, String jurusan, String umur, String domisili, String tanggalLahir, String noTelepon, String pengalaman, String ipk, String skill) {
        boolean hasil = false;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(tanggalLahir);
            double ip = Double.valueOf(ipk);
            Userprofile use = new Userprofile(Integer.valueOf(cvId), cvUpload, uploadPhoto, uploadKtp, namaUniversitas, jurusan, Short.valueOf(umur), domisili, dates, Long.valueOf(noTelepon), pengalaman, BigDecimal.valueOf(ip), skill, new Users(Integer.valueOf(cvId)));

            if (daoid.doDML(use, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

    @Override
    public List<Object> search(String keyword) {
        return daoid.doDDL(new Users(), keyword);
    }
}
