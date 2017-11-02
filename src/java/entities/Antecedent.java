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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devarence
 */
@Entity
@Table(name = "antecedent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedent.findAll", query = "SELECT a FROM Antecedent a"),
    @NamedQuery(name = "Antecedent.findByIdantecedent", query = "SELECT a FROM Antecedent a WHERE a.idantecedent = :idantecedent"),
    @NamedQuery(name = "Antecedent.findByDateA", query = "SELECT a FROM Antecedent a WHERE a.dateA = :dateA"),
    @NamedQuery(name = "Antecedent.findByDescription", query = "SELECT a FROM Antecedent a WHERE a.description = :description")})
public class Antecedent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idantecedent")
    private Long idantecedent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateA")
    @Temporal(TemporalType.DATE)
    private Date dateA;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "locataireId", referencedColumnName = "idlocataire")
    @ManyToOne
    private Locataire locataireId;

    public Antecedent() {
    }

    public Antecedent(Long idantecedent) {
        this.idantecedent = idantecedent;
    }

    public Antecedent(Long idantecedent, Date dateA) {
        this.idantecedent = idantecedent;
        this.dateA = dateA;
    }

    public Long getIdantecedent() {
        return idantecedent;
    }

    public void setIdantecedent(Long idantecedent) {
        this.idantecedent = idantecedent;
    }

    public Date getDateA() {
        return dateA;
    }

    public void setDateA(Date dateA) {
        this.dateA = dateA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (idantecedent != null ? idantecedent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedent)) {
            return false;
        }
        Antecedent other = (Antecedent) object;
        if ((this.idantecedent == null && other.idantecedent != null) || (this.idantecedent != null && !this.idantecedent.equals(other.idantecedent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Antecedent[ idantecedent=" + idantecedent + " ]";
    }
    
}
