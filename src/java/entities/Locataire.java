/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author devarence
 */
@Entity
@Table(name = "locataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locataire.findAll", query = "SELECT l FROM Locataire l"),
    @NamedQuery(name = "Locataire.findByIdlocataire", query = "SELECT l FROM Locataire l WHERE l.idlocataire = :idlocataire"),
    @NamedQuery(name = "Locataire.findByNom", query = "SELECT l FROM Locataire l WHERE l.nom = :nom"),
    @NamedQuery(name = "Locataire.findByPrenom", query = "SELECT l FROM Locataire l WHERE l.prenom = :prenom"),
    @NamedQuery(name = "Locataire.findByDateNaiss", query = "SELECT l FROM Locataire l WHERE l.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "Locataire.findByNationalite", query = "SELECT l FROM Locataire l WHERE l.nationalite = :nationalite"),
    @NamedQuery(name = "Locataire.findBySituationMatri", query = "SELECT l FROM Locataire l WHERE l.situationMatri = :situationMatri"),
    @NamedQuery(name = "Locataire.findByProfession", query = "SELECT l FROM Locataire l WHERE l.profession = :profession"),
    @NamedQuery(name = "Locataire.findByNbreEnfant", query = "SELECT l FROM Locataire l WHERE l.nbreEnfant = :nbreEnfant"),
    @NamedQuery(name = "Locataire.findByTelephone", query = "SELECT l FROM Locataire l WHERE l.telephone = :telephone"),
    @NamedQuery(name = "Locataire.findByAdresse", query = "SELECT l FROM Locataire l WHERE l.adresse = :adresse"),
    @NamedQuery(name = "Locataire.findByEmail", query = "SELECT l FROM Locataire l WHERE l.email = :email"),
    @NamedQuery(name = "Locataire.findByPersAppelUrgence", query = "SELECT l FROM Locataire l WHERE l.persAppelUrgence = :persAppelUrgence"),
    @NamedQuery(name = "Locataire.findByTelephonePAU", query = "SELECT l FROM Locataire l WHERE l.telephonePAU = :telephonePAU"),
    @NamedQuery(name = "Locataire.findByEmailPAU", query = "SELECT l FROM Locataire l WHERE l.emailPAU = :emailPAU"),
    @NamedQuery(name = "Locataire.findByEmployeur", query = "SELECT l FROM Locataire l WHERE l.employeur = :employeur"),
    @NamedQuery(name = "Locataire.findByTelBureau", query = "SELECT l FROM Locataire l WHERE l.telBureau = :telBureau"),
    @NamedQuery(name = "Locataire.findByDomiciliation", query = "SELECT l FROM Locataire l WHERE l.domiciliation = :domiciliation"),
    @NamedQuery(name = "Locataire.findByNumCompte", query = "SELECT l FROM Locataire l WHERE l.numCompte = :numCompte"),
    @NamedQuery(name = "Locataire.findByCni", query = "SELECT l FROM Locataire l WHERE l.cni = :cni")})
public class Locataire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocataire")
    private Long idlocataire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "dateNaiss")
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    @Size(max = 45)
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 45)
    @Column(name = "situationMatri")
    private String situationMatri;
    @Size(max = 45)
    @Column(name = "profession")
    private String profession;
    @Column(name = "nbreEnfant")
    private Integer nbreEnfant;
    @Size(max = 45)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 45)
    @Column(name = "adresse")
    private String adresse;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "persAppelUrgence")
    private String persAppelUrgence;
    @Size(max = 45)
    @Column(name = "telephonePAU")
    private String telephonePAU;
    @Size(max = 45)
    @Column(name = "emailPAU")
    private String emailPAU;
    @Size(max = 45)
    @Column(name = "employeur")
    private String employeur;
    @Size(max = 45)
    @Column(name = "telBureau")
    private String telBureau;
    @Size(max = 45)
    @Column(name = "domiciliation")
    private String domiciliation;
    @Size(max = 45)
    @Column(name = "numCompte")
    private String numCompte;
    @Size(max = 45)
    @Column(name = "CNI")
    private String cni;
    @OneToMany(mappedBy = "locataireId")
    private List<Antecedent> antecedentList;
    @OneToMany(mappedBy = "locataireId")
    private List<Contrat> contratList;
    @OneToMany(mappedBy = "locataireId")
    private List<Paiement> paiementList;
    @OneToMany(mappedBy = "locataireId")
    private List<Location> locationList;
    @OneToMany(mappedBy = "locataireId")
    private List<Bienimmobilier> bienimmobilierList;

    public Locataire() {
    }

    public Locataire(Long idlocataire) {
        this.idlocataire = idlocataire;
    }

    public Locataire(Long idlocataire, String nom, String prenom) {
        this.idlocataire = idlocataire;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getIdlocataire() {
        return idlocataire;
    }

    public void setIdlocataire(Long idlocataire) {
        this.idlocataire = idlocataire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getSituationMatri() {
        return situationMatri;
    }

    public void setSituationMatri(String situationMatri) {
        this.situationMatri = situationMatri;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getNbreEnfant() {
        return nbreEnfant;
    }

    public void setNbreEnfant(Integer nbreEnfant) {
        this.nbreEnfant = nbreEnfant;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersAppelUrgence() {
        return persAppelUrgence;
    }

    public void setPersAppelUrgence(String persAppelUrgence) {
        this.persAppelUrgence = persAppelUrgence;
    }

    public String getTelephonePAU() {
        return telephonePAU;
    }

    public void setTelephonePAU(String telephonePAU) {
        this.telephonePAU = telephonePAU;
    }

    public String getEmailPAU() {
        return emailPAU;
    }

    public void setEmailPAU(String emailPAU) {
        this.emailPAU = emailPAU;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getTelBureau() {
        return telBureau;
    }

    public void setTelBureau(String telBureau) {
        this.telBureau = telBureau;
    }

    public String getDomiciliation() {
        return domiciliation;
    }

    public void setDomiciliation(String domiciliation) {
        this.domiciliation = domiciliation;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    @XmlTransient
    public List<Antecedent> getAntecedentList() {
        return antecedentList;
    }

    public void setAntecedentList(List<Antecedent> antecedentList) {
        this.antecedentList = antecedentList;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
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
        hash += (idlocataire != null ? idlocataire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locataire)) {
            return false;
        }
        Locataire other = (Locataire) object;
        if ((this.idlocataire == null && other.idlocataire != null) || (this.idlocataire != null && !this.idlocataire.equals(other.idlocataire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Locataire[ idlocataire=" + idlocataire + " ]";
    }
    
}
