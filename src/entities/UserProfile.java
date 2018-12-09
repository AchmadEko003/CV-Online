/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igaz
 */
@Entity
@Table(name = "USER_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
    , @NamedQuery(name = "UserProfile.findById", query = "SELECT u FROM UserProfile u WHERE u.id = :id")
    , @NamedQuery(name = "UserProfile.findByUmur", query = "SELECT u FROM UserProfile u WHERE u.umur = :umur")
    , @NamedQuery(name = "UserProfile.findByAlamat", query = "SELECT u FROM UserProfile u WHERE u.alamat = :alamat")
    , @NamedQuery(name = "UserProfile.findByTanggalLahir", query = "SELECT u FROM UserProfile u WHERE u.tanggalLahir = :tanggalLahir")
    , @NamedQuery(name = "UserProfile.findByNoTelepon", query = "SELECT u FROM UserProfile u WHERE u.noTelepon = :noTelepon")})
public class UserProfile implements Serializable {

    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<Sertifikat> sertifikatList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "UMUR")
    private Short umur;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "TANGGAL_LAHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalLahir;
    @Column(name = "NO_TELEPON")
    private Long noTelepon;
    @Lob
    @Column(name = "CV")
    private Serializable cv;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @Lob
    @Column(name = "KTP")
    private Serializable ktp;
    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<Keahlian> keahlianList;
    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<Bahasa> bahasaList;
    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<Pengalaman> pengalamanList;
    @JoinColumn(name = "USERS_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users usersId;
    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<Pencapaian> pencapaianList;
    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<Proyek> proyekList;
    @OneToMany(mappedBy = "userProfileId", fetch = FetchType.LAZY)
    private List<RiwayatPendidikan> riwayatPendidikanList;

    public UserProfile() {
    }

    public UserProfile(Integer id) {
        this.id = id;
    }

    public UserProfile(Integer id, Short umur, String alamat, Date tanggalLahir, Long noTelepon, Serializable cv, Serializable foto, Serializable ktp, Users usersId) {
        this.id = id;
        this.umur = umur;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.noTelepon = noTelepon;
        this.cv = cv;
        this.foto = foto;
        this.ktp = ktp;
        this.usersId = usersId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getUmur() {
        return umur;
    }

    public void setUmur(Short umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Long getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(Long noTelepon) {
        this.noTelepon = noTelepon;
    }

    public Serializable getCv() {
        return cv;
    }

    public void setCv(Serializable cv) {
        this.cv = cv;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    public Serializable getKtp() {
        return ktp;
    }

    public void setKtp(Serializable ktp) {
        this.ktp = ktp;
    }

    @XmlTransient
    public List<Keahlian> getKeahlianList() {
        return keahlianList;
    }

    public void setKeahlianList(List<Keahlian> keahlianList) {
        this.keahlianList = keahlianList;
    }

    @XmlTransient
    public List<Bahasa> getBahasaList() {
        return bahasaList;
    }

    public void setBahasaList(List<Bahasa> bahasaList) {
        this.bahasaList = bahasaList;
    }

    @XmlTransient
    public List<Pengalaman> getPengalamanList() {
        return pengalamanList;
    }

    public void setPengalamanList(List<Pengalaman> pengalamanList) {
        this.pengalamanList = pengalamanList;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @XmlTransient
    public List<Pencapaian> getPencapaianList() {
        return pencapaianList;
    }

    public void setPencapaianList(List<Pencapaian> pencapaianList) {
        this.pencapaianList = pencapaianList;
    }

    @XmlTransient
    public List<Proyek> getProyekList() {
        return proyekList;
    }

    public void setProyekList(List<Proyek> proyekList) {
        this.proyekList = proyekList;
    }

    @XmlTransient
    public List<RiwayatPendidikan> getRiwayatPendidikanList() {
        return riwayatPendidikanList;
    }

    public void setRiwayatPendidikanList(List<RiwayatPendidikan> riwayatPendidikanList) {
        this.riwayatPendidikanList = riwayatPendidikanList;
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
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserProfile[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Sertifikat> getSertifikatList() {
        return sertifikatList;
    }

    public void setSertifikatList(List<Sertifikat> sertifikatList) {
        this.sertifikatList = sertifikatList;
    }
    
}
