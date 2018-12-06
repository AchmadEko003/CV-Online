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
public interface LowonganKerjaInterface {
    public List<Object> search(String keyword);
    public boolean insert(String lowonganId, String judulLowongan, String deskripsiPekerjaan, String requirements, String idPerusahaan);
}
