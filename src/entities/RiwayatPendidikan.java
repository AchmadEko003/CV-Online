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
@Table(name = "RIWAYAT_PENDIDIKAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RiwayatPendidikan.findAll", query = "SELECT r FROM RiwayatPendidikan r")
    , @NamedQuery(name = "RiwayatPendidikan.findById", query = "SELECT r FROM RiwayatPendidikan r WHERE r.id = :id")
    , @NamedQuery(name = "RiwayatPendidikan.findByNama", query = "SELECT r FROM RiwayatPendidikan r WHERE r.nama = :nama")
    , @NamedQuery(name = "RiwayatPendidikan.findByJurusan", query = "SELECT r FROM RiwayatPendidikan r WHERE r.jurusan = :jurusan")
    , @NamedQuery(name = "RiwayatPendidikan.findByOrganisasi", query = "SELECT r FROM RiwayatPendidikan r WHERE r.organisasi = :organisasi")})
public class RiwayatPendidikan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JURUSAN")
    private String jurusan;
    @Column(name = "ORGANISASI")
    private String organisasi;
    @JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserProfile userProfileId;

    public RiwayatPendidikan() {
    }

    public RiwayatPendidikan(Integer id, String nama, String jurusan, String organisasi, UserProfile userProfileId) {
        this.id = id;
        this.nama = nama;
        this.jurusan = jurusan;
        this.organisasi = organisasi;
        this.userProfileId = userProfileId;
    }

    public RiwayatPendidikan(Integer id) {
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

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getOrganisasi() {
        return organisasi;
    }

    public void setOrganisasi(String organisasi) {
        this.organisasi = organisasi;
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
        if (!(object instanceof RiwayatPendidikan)) {
            return false;
        }
        RiwayatPendidikan other = (RiwayatPendidikan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RiwayatPendidikan[ id=" + id + " ]";
    }
    
}
