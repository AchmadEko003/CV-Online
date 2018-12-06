/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
    , @NamedQuery(name = "Userprofile.findByUserProfileId", query = "SELECT u FROM Userprofile u WHERE u.userProfileId = :userProfileId")
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
    @Column(name = "USER_PROFILE_ID")
    private Integer userProfileId;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IPK")
    private BigDecimal ipk;
    @Column(name = "SKILL")
    private String skill;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    public Userprofile() {
    }

    public Userprofile(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Userprofile(Integer userProfileId, Serializable cvUpload, Serializable uploadPhoto, Serializable uploadKtp, String namaUniversitas, String jurusan, Short umur, String domisili, Date tanggalLahir, Long noTelepon, String pengalaman, BigDecimal ipk, String skill, Users userId) {
        this.userProfileId = userProfileId;
        this.cvUpload = cvUpload;
        this.uploadPhoto = uploadPhoto;
        this.uploadKtp = uploadKtp;
        this.namaUniversitas = namaUniversitas;
        this.jurusan = jurusan;
        this.umur = umur;
        this.domisili = domisili;
        this.tanggalLahir = tanggalLahir;
        this.noTelepon = noTelepon;
        this.pengalaman = pengalaman;
        this.ipk = ipk;
        this.skill = skill;
        this.userId = userId;
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
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

    public BigDecimal getIpk() {
        return ipk;
    }

    public void setIpk(BigDecimal ipk) {
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
        hash += (userProfileId != null ? userProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userprofile)) {
            return false;
        }
        Userprofile other = (Userprofile) object;
        if ((this.userProfileId == null && other.userProfileId != null) || (this.userProfileId != null && !this.userProfileId.equals(other.userProfileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userprofile[ userProfileId=" + userProfileId + " ]";
    }
    
}
