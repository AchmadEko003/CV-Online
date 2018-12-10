/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Role;
import entities.Sertifikat;
import entities.UserProfile;
import entities.Users;
import interfaces.SertifikatInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class SertifikatControllers implements SertifikatInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public SertifikatControllers() {
    }

    public SertifikatControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public List<Object> search(String keyword) {
        return daoid.doDatasId(new Sertifikat(), keyword);
    }

    @Override
    public boolean insert(String id, String nama, String lembaga, String userProfileId) {
        boolean hasil = false;
        try {
            Sertifikat use = new Sertifikat(Integer.valueOf(id), nama, lembaga, new UserProfile(Integer.valueOf(userProfileId)));
            if (daoid.doDML(use, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

}
