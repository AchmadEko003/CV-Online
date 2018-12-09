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
@Table(name = "PENCAPAIAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pencapaian.findAll", query = "SELECT p FROM Pencapaian p")
    , @NamedQuery(name = "Pencapaian.findById", query = "SELECT p FROM Pencapaian p WHERE p.id = :id")
    , @NamedQuery(name = "Pencapaian.findByNama", query = "SELECT p FROM Pencapaian p WHERE p.nama = :nama")
    , @NamedQuery(name = "Pencapaian.findByDeskripsi", query = "SELECT p FROM Pencapaian p WHERE p.deskripsi = :deskripsi")})
public class Pencapaian implements Serializable {

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

    public Pencapaian() {
    }

    public Pencapaian(Integer id, String nama, String deskripsi, UserProfile userProfileId) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.userProfileId = userProfileId;
    }

    public Pencapaian(Integer id) {
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
        if (!(object instanceof Pencapaian)) {
            return false;
        }
        Pencapaian other = (Pencapaian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pencapaian[ id=" + id + " ]";
    }
    
}
