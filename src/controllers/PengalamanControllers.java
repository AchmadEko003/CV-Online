/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Pengalaman;
import entities.UserProfile;
import interfaces.PengalamanInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class PengalamanControllers implements PengalamanInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public PengalamanControllers() {
    }

    public PengalamanControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public List<Object> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(String id, String nama, String perusahaan, String lamaBekerja, String userProfileId) {
        boolean hasil = false;
        try {
            Pengalaman use = new Pengalaman(Integer.valueOf(id), nama, perusahaan, lamaBekerja, new UserProfile(Integer.valueOf(userProfileId)));
            if (daoid.doDML(use, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

}
