/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.UserProfileInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.UserProfile;
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

    @Override
    public List<Object> search(String keyword) {
        return daoid.doDDL(new Users(), keyword);
    }

    @Override
    public boolean inputdata(String id, String umur, String alamat, String tanggalLahir, String noTelepon, String foto, String cv, String ktp, String usersId) {
        boolean hasil = false;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(tanggalLahir);
            UserProfile up = new UserProfile(Integer.valueOf(id), Short.valueOf(umur), alamat, dates, Long.valueOf(noTelepon), foto, cv, ktp, new Users(Integer.valueOf(usersId)));
            if (daoid.doDML(up, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }
}
