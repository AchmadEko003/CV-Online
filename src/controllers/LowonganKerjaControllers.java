/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
import entities.Perusahaan;
import entities.Users;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class LowonganKerjaControllers implements LowonganKerjaInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public LowonganKerjaControllers() {
    }

    public LowonganKerjaControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public List<Object> search(String keyword) {
    return this.daoid.doDDL(new LowonganPekerjaan(), keyword);
    }

    @Override
    public boolean insert(String lowonganId, String judulLowongan, String deskripsiPekerjaan, String requirements, String idPerusahaan) {
        boolean hasil = false;
        try {
            LowonganPekerjaan lp = new LowonganPekerjaan(Integer.valueOf(lowonganId), judulLowongan, deskripsiPekerjaan, requirements, new Perusahaan(Integer.valueOf(idPerusahaan)));
            System.out.println(lp);
            if (daoid.doDML(lp, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }
}
