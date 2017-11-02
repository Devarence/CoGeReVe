/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author devarence
 */
@Entity
@Table(name = "immeuble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Immeuble.findAll", query = "SELECT i FROM Immeuble i"),
    @NamedQuery(name = "Immeuble.findByIdimmeuble", query = "SELECT i FROM Immeuble i WHERE i.idimmeuble = :idimmeuble"),
    @NamedQuery(name = "Immeuble.findByNom", query = "SELECT i FROM Immeuble i WHERE i.nom = :nom"),
    @NamedQuery(name = "Immeuble.findByLocalisation", query = "SELECT i FROM Immeuble i WHERE i.localisation = :localisation")})
public class Immeuble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimmeuble")
    private Long idimmeuble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "localisation")
    private String localisation;
    @OneToMany(mappedBy = "immeubleId")
    private List<Bienimmobilier> bienimmobilierList;

    public Immeuble() {
    }

    public Immeuble(Long idimmeuble) {
        this.idimmeuble = idimmeuble;
    }

    public Immeuble(Long idimmeuble, String nom) {
        this.idimmeuble = idimmeuble;
        this.nom = nom;
    }

    public Long getIdimmeuble() {
        return idimmeuble;
    }

    public void setIdimmeuble(Long idimmeuble) {
        this.idimmeuble = idimmeuble;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @XmlTransient
    public List<Bienimmobilier> getBienimmobilierList() {
        return bienimmobilierList;
    }

    public void setBienimmobilierList(List<Bienimmobilier> bienimmobilierList) {
        this.bienimmobilierList = bienimmobilierList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimmeuble != null ? idimmeuble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Immeuble)) {
            return false;
        }
        Immeuble other = (Immeuble) object;
        if ((this.idimmeuble == null && other.idimmeuble != null) || (this.idimmeuble != null && !this.idimmeuble.equals(other.idimmeuble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Immeuble[ idimmeuble=" + idimmeuble + " ]";
    }
    
}
