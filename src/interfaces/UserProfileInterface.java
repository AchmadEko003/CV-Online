/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nitani
 */
public interface UserProfileInterface {
    public List<Object> search(String keyword);
    public boolean inputdata(String id, String umur, String alamat, String tanggalLahir, String noTelepon, String foto, String cv, String ktp, String usersId);
     public Object getById(Object id);
}
