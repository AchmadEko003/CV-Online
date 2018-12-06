/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import entities.Users;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class UsersController implements UserInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public UsersController(SessionFactory sessionFactory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    @Override
    public List<Object> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean register(String userId, String nama, String email, String userPassword, String role) {
        boolean hasil = false;
        try {
            int idUser = Integer.valueOf(userId);
            Users use = new Users(idUser, nama, email, userPassword, role);
            if (daoid.doDML(use, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

    @Override
    public boolean insertOrUpdateOrDelete(Object object, boolean isDelete) {
        return gdao.doDML(object, isDelete);
    }

    @Override
    public List<Object> getAllData(Object entity, String keyword) {
        return gdao.doDDL(entity, keyword);
    }

    @Override
    public Object getById(Object entity, Object id) {
        return gdao.getById(entity, id);
    }

}
