/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.UserInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
import entities.Role;
import entities.UserProfile;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class UserControllers implements UserInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public UserControllers() {
    }

    public UserControllers(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public boolean register(String id, String nama, String email, String password) {
        boolean hasil = false;
        try {
            Integer a = daoid.doDDL(new Users(), "").size()+1;
            Users use = new Users(a, nama, email, password, new Role(1));
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
        return this.daoid.doDDL(new LowonganPekerjaan(), keyword);
    }
    
    @Override
    public boolean login(Object nama, String password){
        return this.daoid.login(nama, password);
    }

    @Override
    public Integer getUser(Object user) {
        return this.daoid.getUser(user);
    }

    @Override
    public Object getById(Object id) {
        return this.daoid.getById(new UserProfile(), id);
    }

    @Override
    public boolean getIdProfile(Object id) {
        return this.daoid.getIdProfile(id);
    }

    @Override
    public List<Object> getAllData(Object entity, String keyword) {
        List<Object> data = new ArrayList<>();
        data = gdao.doDDL(entity, keyword);
        return data;
    }
}
