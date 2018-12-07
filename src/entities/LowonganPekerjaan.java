/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nitani
 */
@Entity
@Table(name = "LOWONGAN_PEKERJAAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LowonganPekerjaan.findAll", query = "SELECT l FROM LowonganPekerjaan l")
    , @NamedQuery(name = "LowonganPekerjaan.findById", query = "SELECT l FROM LowonganPekerjaan l WHERE l.id = :id")
    , @NamedQuery(name = "LowonganPekerjaan.findByJudul", query = "SELECT l FROM LowonganPekerjaan l WHERE l.judul = :judul")
    , @NamedQuery(name = "LowonganPekerjaan.findByDeskripsi", query = "SELECT l FROM LowonganPekerjaan l WHERE l.deskripsi = :deskripsi")
    , @NamedQuery(name = "LowonganPekerjaan.findByRequirements", query = "SELECT l FROM LowonganPekerjaan l WHERE l.requirements = :requirements")
    , @NamedQuery(name = "LowonganPekerjaan.findByTanggal", query = "SELECT l FROM LowonganPekerjaan l WHERE l.tanggal = :tanggal")})
public class LowonganPekerjaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "JUDUL")
    private String judul;
    @Column(name = "DESKRIPSI")
    private String deskripsi;
    @Column(name = "REQUIREMENTS")
    private String requirements;
    @Column(name = "TANGGAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    public LowonganPekerjaan() {
    }

    public LowonganPekerjaan(Integer id) {
        this.id = id;
    }

    public LowonganPekerjaan(Integer id, String judul, String deskripsi, String requirements, Date tanggal) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.requirements = requirements;
        this.tanggal = tanggal;
    }

    public LowonganPekerjaan(Integer id, String judul, String deskripsi, String requirements, Date tanggal, Users userId) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.requirements = requirements;
        this.tanggal = tanggal;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof LowonganPekerjaan)) {
            return false;
        }
        LowonganPekerjaan other = (LowonganPekerjaan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LowonganPekerjaan[ id=" + id + " ]";
    }
    
}
