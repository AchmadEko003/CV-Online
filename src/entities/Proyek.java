/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nitani
 */
@Entity
@Table(name = "PROYEK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyek.findAll", query = "SELECT p FROM Proyek p")
    , @NamedQuery(name = "Proyek.findById", query = "SELECT p FROM Proyek p WHERE p.id = :id")
    , @NamedQuery(name = "Proyek.findByNama", query = "SELECT p FROM Proyek p WHERE p.nama = :nama")
    , @NamedQuery(name = "Proyek.findByStatus", query = "SELECT p FROM Proyek p WHERE p.status = :status")
    , @NamedQuery(name = "Proyek.findByDeskripsi", query = "SELECT p FROM Proyek p WHERE p.deskripsi = :deskripsi")})
public class Proyek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DESKRIPSI")
    private String deskripsi;
    @JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserProfile userProfileId;

    public Proyek() {
    }

    public Proyek(Integer id) {
        this.id = id;
    }

    public Proyek(Integer id, String nama, String status, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.status = status;
        this.deskripsi = deskripsi;
    }

    public Proyek(Integer id, String nama, String status, String deskripsi, UserProfile userProfileId) {
        this.id = id;
        this.nama = nama;
        this.status = status;
        this.deskripsi = deskripsi;
        this.userProfileId = userProfileId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public UserProfile getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UserProfile userProfileId) {
        this.userProfileId = userProfileId;
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
        if (!(object instanceof Proyek)) {
            return false;
        }
        Proyek other = (Proyek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proyek[ id=" + id + " ]";
    }
    
}
