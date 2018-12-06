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
    public boolean register(String userId, String name, String email, String password, String role);
    public boolean login(Object nama, String password);
    public Integer getUser(Object user);
}
