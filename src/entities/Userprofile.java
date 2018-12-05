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
import javax.persistence.Lob;
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
@Table(name = "USERPROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userprofile.findAll", query = "SELECT u FROM Userprofile u")
    , @NamedQuery(name = "Userprofile.findByCvId", query = "SELECT u FROM Userprofile u WHERE u.cvId = :cvId")
    , @NamedQuery(name = "Userprofile.findByNamaUniversitas", query = "SELECT u FROM Userprofile u WHERE u.namaUniversitas = :namaUniversitas")
    , @NamedQuery(name = "Userprofile.findByJurusan", query = "SELECT u FROM Userprofile u WHERE u.jurusan = :jurusan")
    , @NamedQuery(name = "Userprofile.findByUmur", query = "SELECT u FROM Userprofile u WHERE u.umur = :umur")
    , @NamedQuery(name = "Userprofile.findByDomisili", query = "SELECT u FROM Userprofile u WHERE u.domisili = :domisili")
    , @NamedQuery(name = "Userprofile.findByTanggalLahir", query = "SELECT u FROM Userprofile u WHERE u.tanggalLahir = :tanggalLahir")
    , @NamedQuery(name = "Userprofile.findByNoTelepon", query = "SELECT u FROM Userprofile u WHERE u.noTelepon = :noTelepon")
    , @NamedQuery(name = "Userprofile.findByPengalaman", query = "SELECT u FROM Userprofile u WHERE u.pengalaman = :pengalaman")
    , @NamedQuery(name = "Userprofile.findByIpk", query = "SELECT u FROM Userprofile u WHERE u.ipk = :ipk")
    , @NamedQuery(name = "Userprofile.findBySkill", query = "SELECT u FROM Userprofile u WHERE u.skill = :skill")})
public class Userprofile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CV_ID")
    private Integer cvId;
    @Lob
    @Column(name = "CV_UPLOAD")
    private Serializable cvUpload;
    @Lob
    @Column(name = "UPLOAD_PHOTO")
    private Serializable uploadPhoto;
    @Lob
    @Column(name = "UPLOAD_KTP")
    private Serializable uploadKtp;
    @Column(name = "NAMA_UNIVERSITAS")
    private String namaUniversitas;
    @Column(name = "JURUSAN")
    private String jurusan;
    @Column(name = "UMUR")
    private Short umur;
    @Column(name = "DOMISILI")
    private String domisili;
    @Column(name = "TANGGAL_LAHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalLahir;
    @Column(name = "NO_TELEPON")
    private Long noTelepon;
    @Column(name = "PENGALAMAN")
    private String pengalaman;
    @Column(name = "IPK")
    private Short ipk;
    @Column(name = "SKILL")
    private String skill;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    public Userprofile() {
    }

    public Userprofile(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Serializable getCvUpload() {
        return cvUpload;
    }

    public void setCvUpload(Serializable cvUpload) {
        this.cvUpload = cvUpload;
    }

    public Serializable getUploadPhoto() {
        return uploadPhoto;
    }

    public void setUploadPhoto(Serializable uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }

    public Serializable getUploadKtp() {
        return uploadKtp;
    }

    public void setUploadKtp(Serializable uploadKtp) {
        this.uploadKtp = uploadKtp;
    }

    public String getNamaUniversitas() {
        return namaUniversitas;
    }

    public void setNamaUniversitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Short getUmur() {
        return umur;
    }

    public void setUmur(Short umur) {
        this.umur = umur;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
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

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public Short getIpk() {
        return ipk;
    }

    public void setIpk(Short ipk) {
        this.ipk = ipk;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
        hash += (cvId != null ? cvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userprofile)) {
            return false;
        }
        Userprofile other = (Userprofile) object;
        if ((this.cvId == null && other.cvId != null) || (this.cvId != null && !this.cvId.equals(other.cvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userprofile[ cvId=" + cvId + " ]";
    }
    
}
