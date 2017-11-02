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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devarence
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdlocation", query = "SELECT l FROM Location l WHERE l.idlocation = :idlocation"),
    @NamedQuery(name = "Location.findByDateL", query = "SELECT l FROM Location l WHERE l.dateL = :dateL")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocation")
    private Long idlocation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateL")
    @Temporal(TemporalType.DATE)
    private Date dateL;
    @JoinColumn(name = "bienImmobilierId", referencedColumnName = "id")
    @ManyToOne
    private Bienimmobilier bienImmobilierId;
    @JoinColumn(name = "locataireId", referencedColumnName = "idlocataire")
    @ManyToOne
    private Locataire locataireId;

    public Location() {
    }

    public Location(Long idlocation) {
        this.idlocation = idlocation;
    }

    public Location(Long idlocation, Date dateL) {
        this.idlocation = idlocation;
        this.dateL = dateL;
    }

    public Long getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(Long idlocation) {
        this.idlocation = idlocation;
    }

    public Date getDateL() {
        return dateL;
    }

    public void setDateL(Date dateL) {
        this.dateL = dateL;
    }

    public Bienimmobilier getBienImmobilierId() {
        return bienImmobilierId;
    }

    public void setBienImmobilierId(Bienimmobilier bienImmobilierId) {
        this.bienImmobilierId = bienImmobilierId;
    }

    public Locataire getLocataireId() {
        return locataireId;
    }

    public void setLocataireId(Locataire locataireId) {
        this.locataireId = locataireId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocation != null ? idlocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idlocation == null && other.idlocation != null) || (this.idlocation != null && !this.idlocation.equals(other.idlocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Location[ idlocation=" + idlocation + " ]";
    }
    
}
