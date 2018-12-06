/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
    public boolean inputdata(String cvId, String cvUpload, String uploadPhoto, String uploadKtp, String namaUniversitas, String jurusan, String umur, String domisili, String tanggalLahir, String noTelepon, String pengalaman, String ipk, String skill);
}
