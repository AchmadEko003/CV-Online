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
@Table(name = "PERUSAHAAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perusahaan.findAll", query = "SELECT p FROM Perusahaan p")
    , @NamedQuery(name = "Perusahaan.findByPerusahaanId", query = "SELECT p FROM Perusahaan p WHERE p.perusahaanId = :perusahaanId")
    , @NamedQuery(name = "Perusahaan.findByNamaPerusahaan", query = "SELECT p FROM Perusahaan p WHERE p.namaPerusahaan = :namaPerusahaan")
    , @NamedQuery(name = "Perusahaan.findByDomisili", query = "SELECT p FROM Perusahaan p WHERE p.domisili = :domisili")})
public class Perusahaan implements Serializable {

    @OneToMany(mappedBy = "perusahaanId", fetch = FetchType.LAZY)
    private List<LowonganPekerjaan> lowonganPekerjaanList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PERUSAHAAN_ID")
    private Integer perusahaanId;
    @Column(name = "NAMA_PERUSAHAAN")
    private String namaPerusahaan;
    @Column(name = "DOMISILI")
    private String domisili;

    public Perusahaan() {
    }

    public Perusahaan(Integer perusahaanId) {
        this.perusahaanId = perusahaanId;
    }

    public Integer getPerusahaanId() {
        return perusahaanId;
    }

    public void setPerusahaanId(Integer perusahaanId) {
        this.perusahaanId = perusahaanId;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perusahaanId != null ? perusahaanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perusahaan)) {
            return false;
        }
        Perusahaan other = (Perusahaan) object;
        if ((this.perusahaanId == null && other.perusahaanId != null) || (this.perusahaanId != null && !this.perusahaanId.equals(other.perusahaanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Perusahaan[ perusahaanId=" + perusahaanId + " ]";
    }

    @XmlTransient
    public List<LowonganPekerjaan> getLowonganPekerjaanList() {
        return lowonganPekerjaanList;
    }

    public void setLowonganPekerjaanList(List<LowonganPekerjaan> lowonganPekerjaanList) {
        this.lowonganPekerjaanList = lowonganPekerjaanList;
    }
    
}
