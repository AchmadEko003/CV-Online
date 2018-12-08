/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.RiwayatPendidikan;
import entities.UserProfile;
import interfaces.PendidikanInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class PendidikanControllers implements PendidikanInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public PendidikanControllers() {
    }

    public PendidikanControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public List<Object> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(String id, String nama, String jurusan, String organisasi, String userProfileId) {
        boolean hasil = false;
        try {
            RiwayatPendidikan use = new RiwayatPendidikan(Integer.valueOf(id), nama, jurusan, organisasi, new UserProfile(Integer.valueOf(userProfileId)));
            if (daoid.doDML(use, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

}
