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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devarence
 */
@Entity
@Table(name = "dossierpersonnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossierpersonnel.findAll", query = "SELECT d FROM Dossierpersonnel d"),
    @NamedQuery(name = "Dossierpersonnel.findByIddossierPersonnel", query = "SELECT d FROM Dossierpersonnel d WHERE d.iddossierPersonnel = :iddossierPersonnel"),
    @NamedQuery(name = "Dossierpersonnel.findByAbsence", query = "SELECT d FROM Dossierpersonnel d WHERE d.absence = :absence"),
    @NamedQuery(name = "Dossierpersonnel.findByMotif", query = "SELECT d FROM Dossierpersonnel d WHERE d.motif = :motif"),
    @NamedQuery(name = "Dossierpersonnel.findByDateD", query = "SELECT d FROM Dossierpersonnel d WHERE d.dateD = :dateD"),
    @NamedQuery(name = "Dossierpersonnel.findByDuree", query = "SELECT d FROM Dossierpersonnel d WHERE d.duree = :duree"),
    @NamedQuery(name = "Dossierpersonnel.findBySanction", query = "SELECT d FROM Dossierpersonnel d WHERE d.sanction = :sanction")})
public class Dossierpersonnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddossierPersonnel")
    private Long iddossierPersonnel;
    @Size(max = 45)
    @Column(name = "absence")
    private String absence;
    @Size(max = 45)
    @Column(name = "motif")
    private String motif;
    @Column(name = "dateD")
    @Temporal(TemporalType.DATE)
    private Date dateD;
    @Size(max = 45)
    @Column(name = "duree")
    private String duree;
    @Size(max = 50)
    @Column(name = "sanction")
    private String sanction;
    @JoinColumn(name = "idPersonnel", referencedColumnName = "id")
    @ManyToOne
    private Personnel idPersonnel;

    public Dossierpersonnel() {
    }

    public Dossierpersonnel(Long iddossierPersonnel) {
        this.iddossierPersonnel = iddossierPersonnel;
    }

    public Long getIddossierPersonnel() {
        return iddossierPersonnel;
    }

    public void setIddossierPersonnel(Long iddossierPersonnel) {
        this.iddossierPersonnel = iddossierPersonnel;
    }

    public String getAbsence() {
        return absence;
    }

    public void setAbsence(String absence) {
        this.absence = absence;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateD() {
        return dateD;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getSanction() {
        return sanction;
    }

    public void setSanction(String sanction) {
        this.sanction = sanction;
    }

    public Personnel getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Personnel idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddossierPersonnel != null ? iddossierPersonnel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dossierpersonnel)) {
            return false;
        }
        Dossierpersonnel other = (Dossierpersonnel) object;
        if ((this.iddossierPersonnel == null && other.iddossierPersonnel != null) || (this.iddossierPersonnel != null && !this.iddossierPersonnel.equals(other.iddossierPersonnel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dossierpersonnel[ iddossierPersonnel=" + iddossierPersonnel + " ]";
    }
    
}
