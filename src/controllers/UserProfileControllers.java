/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class UserProfileControllers implements UserProfileInterface{
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

    public boolean register(Integer cvId, Serializable cvUpload, Serializable uploadPhoto, Serializable uploadKtp, String namaUniversitas, String jurusan, Short umur, String domisili, Date tanggalLahir, Long noTelepon, String pengalaman, Short ipk, String skill, Users userId) {
        boolean hasil = false;
        
        return hasil;
    }

    @Override
    public List<Object> search(String keyword) {
        return daoid.doDDL(new Users(), keyword);
    }
}
