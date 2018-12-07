/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Role;
import entities.UserProfile;
import java.util.List;

/**
 *
 * @author Nitani
 */
public interface UserInterface {
    public List<Object> search(String keyword);
    public boolean register(String id, String nama, String email, String password, String roleId);
    public boolean login(Object nama, String password);
    public Integer getUser(Object user);
}
