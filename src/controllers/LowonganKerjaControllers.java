/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.LowonganKerjaInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
import entities.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    public boolean insert(String id, String judul, String deskripsi, String requirements, String tanggal, String tanggalSelesai, String userId) {
        boolean hasil = false;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(tanggal);
            Date dates1 = format.parse(tanggalSelesai);
            LowonganPekerjaan lp = new LowonganPekerjaan(Integer.valueOf(id), judul, deskripsi, requirements, dates, dates1, new Users(Integer.valueOf(userId)));
            System.out.println(lp);
            if (daoid.doDML(lp, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

    @Override
    public List<Object> getAllData(Object entity, String keyword) {
        List<Object> data = new ArrayList<>();
        data = gdao.doDDL(entity, keyword);
        return data;
    }
}
