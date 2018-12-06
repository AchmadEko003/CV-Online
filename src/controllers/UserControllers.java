/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Users;
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
    public boolean register(String userId, String name, String email, String password, String role) {
        boolean hasil = false;
        try {
            int idUser = Integer.valueOf(userId);
            Users use = new Users(idUser, name, email, password, role);
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
        return this.daoid.doDDL(new Users(), keyword);
    }
    
    @Override
    public boolean login(Object nama, String password){
        return this.daoid.login(nama, password);
    }
}
