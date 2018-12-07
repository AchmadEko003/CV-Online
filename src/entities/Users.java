/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByNama", query = "SELECT u FROM Users u WHERE u.nama = :nama")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<LowonganPekerjaan> lowonganPekerjaanList;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Apply> applyList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId", fetch = FetchType.LAZY)
    private List<UserProfile> userProfileList;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role roleId;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String nama, String email, String password, Role roleId) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Users(Integer id, String nama, String email, String password, List<UserProfile> userProfileList, Role roleId) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.userProfileList = userProfileList;
        this.roleId = roleId;
    }

    public Users(List<Apply> applyList, Integer id, String nama, String email, String password, List<UserProfile> userProfileList, Role roleId) {
        this.applyList = applyList;
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.userProfileList = userProfileList;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<UserProfile> getUserProfileList() {
        return userProfileList;
    }

    public void setUserProfileList(List<UserProfile> userProfileList) {
        this.userProfileList = userProfileList;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Apply> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<Apply> applyList) {
        this.applyList = applyList;
    }

    @XmlTransient
    public List<LowonganPekerjaan> getLowonganPekerjaanList() {
        return lowonganPekerjaanList;
    }

    public void setLowonganPekerjaanList(List<LowonganPekerjaan> lowonganPekerjaanList) {
        this.lowonganPekerjaanList = lowonganPekerjaanList;
    }
    
}
