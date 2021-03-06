/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entities.Keahlian;
import entities.Role;
import entities.Users;
import entities.UserProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Nitani
 */
public class getLoginData {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public getLoginData() {
    }

    public getLoginData(SessionFactory factory) {
        this.factory = factory;
    }

    public Users login(Object user) {
        Users object = null;
        String query = "from Users where nama= '" + user + "'";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = (Users) session.createQuery(query).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return object;
    }

    public UserProfile logina(Object user) {
        UserProfile object = null;
        String query = "from UserProfile where USERS_ID= '" + user + "'";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = (UserProfile) session.createQuery(query).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return object;
    }

    public Integer getProfileId(Object user) {
        Integer a;
        UserProfile e = this.logina(user);
        a = e.getId();
        return a;
    }

    public Integer getUserId(Object user) {
        Integer a;
        Users e = this.login(user);
        a = e.getId();
        return a;
    }

    public Integer getRoleId(Object user) {
        Integer a;
        Users e = this.login(user);
        a = e.getRoleId().getId();
        return a;
    }

    public List<Object> getUserProfileId(String key) {
        List<Object> rs = new ArrayList<>();
        String className = new Keahlian().getClass().getSimpleName();
        className = className.substring(className.indexOf(".") + 1);
        String query = "From " + className + " where USER_PROFILE_ID= " + key;
        System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }

    public List<Object> getTotal(Object entity) {
        List<Object> rs = new ArrayList<>();
        String className = entity.getClass().getSimpleName();
        className = className.substring(className.indexOf(".") + 1);
        String query = "From " + className;
        System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }

    public boolean emailMatch(String email) {
        boolean hasil = false;
        String a = email;
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        if (matcher.matches()) {
            hasil = true;
        }
        return hasil;
    }
}
