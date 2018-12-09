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
@Table(name = "KEAHLIAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keahlian.findAll", query = "SELECT k FROM Keahlian k")
    , @NamedQuery(name = "Keahlian.findById", query = "SELECT k FROM Keahlian k WHERE k.id = :id")
    , @NamedQuery(name = "Keahlian.findByNama", query = "SELECT k FROM Keahlian k WHERE k.nama = :nama")
    , @NamedQuery(name = "Keahlian.findByDeskripsi", query = "SELECT k FROM Keahlian k WHERE k.deskripsi = :deskripsi")})
public class Keahlian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "DESKRIPSI")
    private String deskripsi;
    @JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserProfile userProfileId;

    public Keahlian() {
    }

    public Keahlian(Integer id) {
        this.id = id;
    }

    public Keahlian(Integer id, String nama, String deskripsi, UserProfile userProfileId) {
        this.id = id;
        this.nama = nama;
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
        if (!(object instanceof Keahlian)) {
            return false;
        }
        Keahlian other = (Keahlian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Keahlian[ id=" + id + " ]";
    }
    
}
