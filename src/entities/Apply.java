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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nitani
 */
@Entity
@Table(name = "APPLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apply.findAll", query = "SELECT a FROM Apply a")
    , @NamedQuery(name = "Apply.findByApplyId", query = "SELECT a FROM Apply a WHERE a.applyId = :applyId")
    , @NamedQuery(name = "Apply.findByUserId", query = "SELECT a FROM Apply a WHERE a.userId = :userId")})
public class Apply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "APPLY_ID")
    private Integer applyId;
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private int userId;

    public Apply() {
    }

    public Apply(Integer applyId) {
        this.applyId = applyId;
    }

    public Apply(Integer applyId, int userId) {
        this.applyId = applyId;
        this.userId = userId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applyId != null ? applyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apply)) {
            return false;
        }
        Apply other = (Apply) object;
        if ((this.applyId == null && other.applyId != null) || (this.applyId != null && !this.applyId.equals(other.applyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Apply[ applyId=" + applyId + " ]";
    }
    
}
