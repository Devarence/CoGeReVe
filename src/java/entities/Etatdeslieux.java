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
@Table(name = "etatdeslieux")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etatdeslieux.findAll", query = "SELECT e FROM Etatdeslieux e"),
    @NamedQuery(name = "Etatdeslieux.findById", query = "SELECT e FROM Etatdeslieux e WHERE e.id = :id"),
    @NamedQuery(name = "Etatdeslieux.findByDateE", query = "SELECT e FROM Etatdeslieux e WHERE e.dateE = :dateE"),
    @NamedQuery(name = "Etatdeslieux.findByCuisine", query = "SELECT e FROM Etatdeslieux e WHERE e.cuisine = :cuisine"),
    @NamedQuery(name = "Etatdeslieux.findByChambre", query = "SELECT e FROM Etatdeslieux e WHERE e.chambre = :chambre"),
    @NamedQuery(name = "Etatdeslieux.findBySalleEauxWC", query = "SELECT e FROM Etatdeslieux e WHERE e.salleEauxWC = :salleEauxWC"),
    @NamedQuery(name = "Etatdeslieux.findByTypeEtat", query = "SELECT e FROM Etatdeslieux e WHERE e.typeEtat = :typeEtat"),
    @NamedQuery(name = "Etatdeslieux.findBySalon", query = "SELECT e FROM Etatdeslieux e WHERE e.salon = :salon")})
public class Etatdeslieux implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateE")
    @Temporal(TemporalType.DATE)
    private Date dateE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cuisine")
    private String cuisine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "chambre")
    private String chambre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "salleEauxWC")
    private String salleEauxWC;
    @Size(max = 45)
    @Column(name = "typeEtat")
    private String typeEtat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "salon")
    private String salon;
    @JoinColumn(name = "bienImmobilierId", referencedColumnName = "id")
    @ManyToOne
    private Bienimmobilier bienImmobilierId;

    public Etatdeslieux() {
    }

    public Etatdeslieux(Long id) {
        this.id = id;
    }

    public Etatdeslieux(Long id, Date dateE, String cuisine, String chambre, String salleEauxWC, String salon) {
        this.id = id;
        this.dateE = dateE;
        this.cuisine = cuisine;
        this.chambre = chambre;
        this.salleEauxWC = salleEauxWC;
        this.salon = salon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateE() {
        return dateE;
    }

    public void setDateE(Date dateE) {
        this.dateE = dateE;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getChambre() {
        return chambre;
    }

    public void setChambre(String chambre) {
        this.chambre = chambre;
    }

    public String getSalleEauxWC() {
        return salleEauxWC;
    }

    public void setSalleEauxWC(String salleEauxWC) {
        this.salleEauxWC = salleEauxWC;
    }

    public String getTypeEtat() {
        return typeEtat;
    }

    public void setTypeEtat(String typeEtat) {
        this.typeEtat = typeEtat;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public Bienimmobilier getBienImmobilierId() {
        return bienImmobilierId;
    }

    public void setBienImmobilierId(Bienimmobilier bienImmobilierId) {
        this.bienImmobilierId = bienImmobilierId;
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
        if (!(object instanceof Etatdeslieux)) {
            return false;
        }
        Etatdeslieux other = (Etatdeslieux) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Etatdeslieux[ id=" + id + " ]";
    }
    
}
