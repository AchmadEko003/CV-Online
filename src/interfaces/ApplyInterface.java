/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Nitani
 */
public interface ApplyInterface {
    public List<Object> search(String keyword);
    public boolean Apply(String id, String status, String lowonganId, String userId);
}
