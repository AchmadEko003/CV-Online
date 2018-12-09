/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Keahlian;
import entities.UserProfile;
import interfaces.KeahlianInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class KeahlianControllers implements KeahlianInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public KeahlianControllers() {
    }

    public KeahlianControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public List<Object> search(String keyword) {
        return daoid.doDDL(new Keahlian(), keyword);
    }

    @Override
    public boolean insert(String id, String nama, String deskripsi, String userProfileId) {
        boolean hasil = false;
        try {
            Keahlian use = new Keahlian(Integer.valueOf(id), nama, deskripsi, new UserProfile(Integer.valueOf(userProfileId)));
            if (daoid.doDML(use, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

}
