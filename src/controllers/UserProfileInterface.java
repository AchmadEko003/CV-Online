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
    public boolean register(Integer cvId, Serializable cvUpload, Serializable uploadPhoto, Serializable uploadKtp, String namaUniversitas, String jurusan, Short umur, String domisili, Date tanggalLahir, Long noTelepon, String pengalaman, Short ipk, String skill, Users userId);
}
