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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devarence
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByIdrole", query = "SELECT r FROM Roles r WHERE r.idrole = :idrole"),
    @NamedQuery(name = "Roles.findByNomroles", query = "SELECT r FROM Roles r WHERE r.nomroles = :nomroles")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrole")
    private Long idrole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomroles")
    private String nomroles;
    @JoinColumn(name = "utilisateur_idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne
    private Utilisateur utilisateurIdutilisateur;

    public Roles() {
    }

    public Roles(Long idrole) {
        this.idrole = idrole;
    }

    public Roles(Long idrole, String nomroles) {
        this.idrole = idrole;
        this.nomroles = nomroles;
    }

    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public String getNomroles() {
        return nomroles;
    }

    public void setNomroles(String nomroles) {
        this.nomroles = nomroles;
    }

    public Utilisateur getUtilisateurIdutilisateur() {
        return utilisateurIdutilisateur;
    }

    public void setUtilisateurIdutilisateur(Utilisateur utilisateurIdutilisateur) {
        this.utilisateurIdutilisateur = utilisateurIdutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrole != null ? idrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Roles[ idrole=" + idrole + " ]";
    }
    
}
