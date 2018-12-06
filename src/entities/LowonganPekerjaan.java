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
@Table(name = "LOWONGAN_PEKERJAAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LowonganPekerjaan.findAll", query = "SELECT l FROM LowonganPekerjaan l")
    , @NamedQuery(name = "LowonganPekerjaan.findByLowonganPekerjaanId", query = "SELECT l FROM LowonganPekerjaan l WHERE l.lowonganPekerjaanId = :lowonganPekerjaanId")
    , @NamedQuery(name = "LowonganPekerjaan.findByJudulLowongan", query = "SELECT l FROM LowonganPekerjaan l WHERE l.judulLowongan = :judulLowongan")
    , @NamedQuery(name = "LowonganPekerjaan.findByDeskripsiPekerjaan", query = "SELECT l FROM LowonganPekerjaan l WHERE l.deskripsiPekerjaan = :deskripsiPekerjaan")
    , @NamedQuery(name = "LowonganPekerjaan.findByRequirements", query = "SELECT l FROM LowonganPekerjaan l WHERE l.requirements = :requirements")})
public class LowonganPekerjaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOWONGAN_PEKERJAAN_ID")
    private Integer lowonganPekerjaanId;
    @Column(name = "JUDUL_LOWONGAN")
    private String judulLowongan;
    @Column(name = "DESKRIPSI_PEKERJAAN")
    private String deskripsiPekerjaan;
    @Column(name = "REQUIREMENTS")
    private String requirements;
    @JoinColumn(name = "PERUSAHAAN_ID", referencedColumnName = "PERUSAHAAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perusahaan perusahaanId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    public LowonganPekerjaan() {
    }

    public LowonganPekerjaan(Integer lowonganPekerjaanId) {
        this.lowonganPekerjaanId = lowonganPekerjaanId;
    }

    public LowonganPekerjaan(Integer lowonganPekerjaanId, String judulLowongan, String deskripsiPekerjaan, String requirements, Perusahaan perusahaanId) {
        this.lowonganPekerjaanId = lowonganPekerjaanId;
        this.judulLowongan = judulLowongan;
        this.deskripsiPekerjaan = deskripsiPekerjaan;
        this.requirements = requirements;
        this.perusahaanId = perusahaanId;
        this.userId = userId;
    }

    public Integer getLowonganPekerjaanId() {
        return lowonganPekerjaanId;
    }

    public void setLowonganPekerjaanId(Integer lowonganPekerjaanId) {
        this.lowonganPekerjaanId = lowonganPekerjaanId;
    }

    public String getJudulLowongan() {
        return judulLowongan;
    }

    public void setJudulLowongan(String judulLowongan) {
        this.judulLowongan = judulLowongan;
    }

    public String getDeskripsiPekerjaan() {
        return deskripsiPekerjaan;
    }

    public void setDeskripsiPekerjaan(String deskripsiPekerjaan) {
        this.deskripsiPekerjaan = deskripsiPekerjaan;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Perusahaan getPerusahaanId() {
        return perusahaanId;
    }

    public void setPerusahaanId(Perusahaan perusahaanId) {
        this.perusahaanId = perusahaanId;
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
        hash += (lowonganPekerjaanId != null ? lowonganPekerjaanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LowonganPekerjaan)) {
            return false;
        }
        LowonganPekerjaan other = (LowonganPekerjaan) object;
        if ((this.lowonganPekerjaanId == null && other.lowonganPekerjaanId != null) || (this.lowonganPekerjaanId != null && !this.lowonganPekerjaanId.equals(other.lowonganPekerjaanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LowonganPekerjaan[ lowonganPekerjaanId=" + lowonganPekerjaanId + " ]";
    }
    
}
