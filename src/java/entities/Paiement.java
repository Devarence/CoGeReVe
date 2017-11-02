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
@Table(name = "paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p"),
    @NamedQuery(name = "Paiement.findByIdpaiement", query = "SELECT p FROM Paiement p WHERE p.idpaiement = :idpaiement"),
    @NamedQuery(name = "Paiement.findByLoyer", query = "SELECT p FROM Paiement p WHERE p.loyer = :loyer"),
    @NamedQuery(name = "Paiement.findByDatePaiement", query = "SELECT p FROM Paiement p WHERE p.datePaiement = :datePaiement"),
    @NamedQuery(name = "Paiement.findByDateEcheance", query = "SELECT p FROM Paiement p WHERE p.dateEcheance = :dateEcheance"),
    @NamedQuery(name = "Paiement.findByFraisGardiennage", query = "SELECT p FROM Paiement p WHERE p.fraisGardiennage = :fraisGardiennage"),
    @NamedQuery(name = "Paiement.findByPenalite", query = "SELECT p FROM Paiement p WHERE p.penalite = :penalite"),
    @NamedQuery(name = "Paiement.findByPourcentage", query = "SELECT p FROM Paiement p WHERE p.pourcentage = :pourcentage"),
    @NamedQuery(name = "Paiement.findByTotal", query = "SELECT p FROM Paiement p WHERE p.total = :total"),
    @NamedQuery(name = "Paiement.findByStatutPaiement", query = "SELECT p FROM Paiement p WHERE p.statutPaiement = :statutPaiement")})
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaiement")
    private Long idpaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loyer")
    private float loyer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datePaiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateEcheance")
    @Temporal(TemporalType.DATE)
    private Date dateEcheance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fraisGardiennage")
    private Float fraisGardiennage;
    @Column(name = "penalite")
    private Float penalite;
    @Column(name = "pourcentage")
    private Float pourcentage;
    @Column(name = "total")
    private Float total;
    @Size(max = 45)
    @Column(name = "statutPaiement")
    private String statutPaiement;
    @JoinColumn(name = "locataireId", referencedColumnName = "idlocataire")
    @ManyToOne
    private Locataire locataireId;

    public Paiement() {
    }

    public Paiement(Long idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Paiement(Long idpaiement, float loyer, Date datePaiement, Date dateEcheance) {
        this.idpaiement = idpaiement;
        this.loyer = loyer;
        this.datePaiement = datePaiement;
        this.dateEcheance = dateEcheance;
    }

    public Long getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(Long idpaiement) {
        this.idpaiement = idpaiement;
    }

    public float getLoyer() {
        return loyer;
    }

    public void setLoyer(float loyer) {
        this.loyer = loyer;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Float getFraisGardiennage() {
        return fraisGardiennage;
    }

    public void setFraisGardiennage(Float fraisGardiennage) {
        this.fraisGardiennage = fraisGardiennage;
    }

    public Float getPenalite() {
        return penalite;
    }

    public void setPenalite(Float penalite) {
        this.penalite = penalite;
    }

    public Float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
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
        hash += (idpaiement != null ? idpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idpaiement == null && other.idpaiement != null) || (this.idpaiement != null && !this.idpaiement.equals(other.idpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Paiement[ idpaiement=" + idpaiement + " ]";
    }
    
}
