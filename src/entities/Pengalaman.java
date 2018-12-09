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
 * @author Igaz
 */
@Entity
@Table(name = "PENGALAMAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pengalaman.findAll", query = "SELECT p FROM Pengalaman p")
    , @NamedQuery(name = "Pengalaman.findById", query = "SELECT p FROM Pengalaman p WHERE p.id = :id")
    , @NamedQuery(name = "Pengalaman.findByNama", query = "SELECT p FROM Pengalaman p WHERE p.nama = :nama")
    , @NamedQuery(name = "Pengalaman.findByPerusahaan", query = "SELECT p FROM Pengalaman p WHERE p.perusahaan = :perusahaan")
    , @NamedQuery(name = "Pengalaman.findByLamaBekerja", query = "SELECT p FROM Pengalaman p WHERE p.lamaBekerja = :lamaBekerja")})
public class Pengalaman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "PERUSAHAAN")
    private String perusahaan;
    @Column(name = "LAMA_BEKERJA")
    private String lamaBekerja;
    @JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserProfile userProfileId;

    public Pengalaman() {
    }

    public Pengalaman(Integer id, String nama, String perusahaan, String lamaBekerja, UserProfile userProfileId) {
        this.id = id;
        this.nama = nama;
        this.perusahaan = perusahaan;
        this.lamaBekerja = lamaBekerja;
        this.userProfileId = userProfileId;
    }

    public Pengalaman(Integer id) {
        this.id = id;
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

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getLamaBekerja() {
        return lamaBekerja;
    }

    public void setLamaBekerja(String lamaBekerja) {
        this.lamaBekerja = lamaBekerja;
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
        if (!(object instanceof Pengalaman)) {
            return false;
        }
        Pengalaman other = (Pengalaman) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pengalaman[ id=" + id + " ]";
    }
    
}
