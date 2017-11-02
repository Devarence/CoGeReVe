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
@Table(name = "contrat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c"),
    @NamedQuery(name = "Contrat.findByIdcontrat", query = "SELECT c FROM Contrat c WHERE c.idcontrat = :idcontrat"),
    @NamedQuery(name = "Contrat.findByNbrePiece", query = "SELECT c FROM Contrat c WHERE c.nbrePiece = :nbrePiece"),
    @NamedQuery(name = "Contrat.findByDateC", query = "SELECT c FROM Contrat c WHERE c.dateC = :dateC"),
    @NamedQuery(name = "Contrat.findByLoyerMensuel", query = "SELECT c FROM Contrat c WHERE c.loyerMensuel = :loyerMensuel"),
    @NamedQuery(name = "Contrat.findByCaution", query = "SELECT c FROM Contrat c WHERE c.caution = :caution"),
    @NamedQuery(name = "Contrat.findByAvance", query = "SELECT c FROM Contrat c WHERE c.avance = :avance")})
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontrat")
    private Long idcontrat;
    @Column(name = "nbrePiece")
    private Integer nbrePiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateC")
    @Temporal(TemporalType.DATE)
    private Date dateC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loyerMensuel")
    private float loyerMensuel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "caution")
    private Float caution;
    @Column(name = "avance")
    private Float avance;
    @JoinColumn(name = "bienImmobilierId", referencedColumnName = "id")
    @ManyToOne
    private Bienimmobilier bienImmobilierId;
    @JoinColumn(name = "locataireId", referencedColumnName = "idlocataire")
    @ManyToOne
    private Locataire locataireId;

    public Contrat() {
    }

    public Contrat(Long idcontrat) {
        this.idcontrat = idcontrat;
    }

    public Contrat(Long idcontrat, Date dateC, float loyerMensuel) {
        this.idcontrat = idcontrat;
        this.dateC = dateC;
        this.loyerMensuel = loyerMensuel;
    }

    public Long getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(Long idcontrat) {
        this.idcontrat = idcontrat;
    }

    public Integer getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(Integer nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public float getLoyerMensuel() {
        return loyerMensuel;
    }

    public void setLoyerMensuel(float loyerMensuel) {
        this.loyerMensuel = loyerMensuel;
    }

    public Float getCaution() {
        return caution;
    }

    public void setCaution(Float caution) {
        this.caution = caution;
    }

    public Float getAvance() {
        return avance;
    }

    public void setAvance(Float avance) {
        this.avance = avance;
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
        hash += (idcontrat != null ? idcontrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.idcontrat == null && other.idcontrat != null) || (this.idcontrat != null && !this.idcontrat.equals(other.idcontrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contrat[ idcontrat=" + idcontrat + " ]";
    }
    
}
