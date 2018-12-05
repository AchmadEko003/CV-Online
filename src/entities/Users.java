/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nitani
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId")
    , @NamedQuery(name = "Users.findByNama", query = "SELECT u FROM Users u WHERE u.nama = :nama")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword")
    , @NamedQuery(name = "Users.findByRole", query = "SELECT u FROM Users u WHERE u.role = :role")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Column(name = "ROLE")
    private String role;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Userprofile> userprofileList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<LowonganPekerjaan> lowonganPekerjaanList;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public Users(Integer idUser, String nama, String email, String userPassword, String role) {
        this.userId = idUser;
        this.nama = nama;
        this.email = email;
        this.userPassword = userPassword;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public List<Userprofile> getUserprofileList() {
        return userprofileList;
    }

    public void setUserprofileList(List<Userprofile> userprofileList) {
        this.userprofileList = userprofileList;
    }

    @XmlTransient
    public List<LowonganPekerjaan> getLowonganPekerjaanList() {
        return lowonganPekerjaanList;
    }

    public void setLowonganPekerjaanList(List<LowonganPekerjaan> lowonganPekerjaanList) {
        this.lowonganPekerjaanList = lowonganPekerjaanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ userId=" + userId + " ]";
    }
    
}
