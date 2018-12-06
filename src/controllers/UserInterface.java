/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;

/**
 *
 * @author Nitani
 */
public interface UserInterface {
    public List<Object> search(String keyword);
    public boolean register(String userId, String nama, String email, String userPassword, String role);
    public boolean insertOrUpdateOrDelete(Object object,
            boolean isDelete);

    public List<Object> getAllData(Object entity, String keyword);

    public Object getById(Object entity, Object id);
}
