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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bienimmobilier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bienimmobilier.findAll", query = "SELECT b FROM Bienimmobilier b"),
    @NamedQuery(name = "Bienimmobilier.findById", query = "SELECT b FROM Bienimmobilier b WHERE b.id = :id"),
    @NamedQuery(name = "Bienimmobilier.findByStatut", query = "SELECT b FROM Bienimmobilier b WHERE b.statut = :statut"),
    @NamedQuery(name = "Bienimmobilier.findByLoyer", query = "SELECT b FROM Bienimmobilier b WHERE b.loyer = :loyer"),
    @NamedQuery(name = "Bienimmobilier.findByTypeBien", query = "SELECT b FROM Bienimmobilier b WHERE b.typeBien = :typeBien"),
    @NamedQuery(name = "Bienimmobilier.findByNbrePiece", query = "SELECT b FROM Bienimmobilier b WHERE b.nbrePiece = :nbrePiece"),
    @NamedQuery(name = "Bienimmobilier.findByNom", query = "SELECT b FROM Bienimmobilier b WHERE b.nom = :nom")})
public class Bienimmobilier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 45)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loyer")
    private float loyer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "typeBien")
    private String typeBien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbrePiece")
    private int nbrePiece;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "bienImmobilierId")
    private List<Etatdeslieux> etatdeslieuxList;
    @OneToMany(mappedBy = "bienImmobilierId")
    private List<Contrat> contratList;
    @OneToMany(mappedBy = "bienImmobilierId")
    private List<Location> locationList;
    @JoinColumn(name = "immeubleId", referencedColumnName = "idimmeuble")
    @ManyToOne
    private Immeuble immeubleId;
    @JoinColumn(name = "locataireId", referencedColumnName = "idlocataire")
    @ManyToOne
    private Locataire locataireId;

    public Bienimmobilier() {
    }

    public Bienimmobilier(Long id) {
        this.id = id;
    }

    public Bienimmobilier(Long id, float loyer, String typeBien, int nbrePiece, String nom) {
        this.id = id;
        this.loyer = loyer;
        this.typeBien = typeBien;
        this.nbrePiece = nbrePiece;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public float getLoyer() {
        return loyer;
    }

    public void setLoyer(float loyer) {
        this.loyer = loyer;
    }

    public String getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(String typeBien) {
        this.typeBien = typeBien;
    }

    public int getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(int nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Etatdeslieux> getEtatdeslieuxList() {
        return etatdeslieuxList;
    }

    public void setEtatdeslieuxList(List<Etatdeslieux> etatdeslieuxList) {
        this.etatdeslieuxList = etatdeslieuxList;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public Immeuble getImmeubleId() {
        return immeubleId;
    }

    public void setImmeubleId(Immeuble immeubleId) {
        this.immeubleId = immeubleId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bienimmobilier)) {
            return false;
        }
        Bienimmobilier other = (Bienimmobilier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bienimmobilier[ id=" + id + " ]";
    }
    
}
