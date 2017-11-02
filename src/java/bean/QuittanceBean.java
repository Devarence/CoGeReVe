/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.util.Date;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Pattern;

/**
 *
 * @author devarence
 */
@Named(value = "quittanceBean")
@RequestScoped
@ManagedBean
public class QuittanceBean {
    
    
    
    
     @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
     private String locataireDestinantaire; //to
     private String nom;
     private String profession;
     private Date naiss;
     private String adresse;
     private String CNI;
     private String nomAdresse;
     private String nationalite;
     private String local;//description du local
     private int piece;
     private String porte;
     private String nomI;
     private String SG;
     private String lot;
     private int ncaution;
     private int navance;
     private int caution;
     private int avance;
     private int total;
     
     private int montant;
   
     private Float reste;
     private String description; //body
     private String dateDelivrance;//mois de loyer payé
     private String sujet;
     
     private Date dateDebut;
     private Date dateFin;
     
    private String message2;
    
    private float loyer;
    private Float penalite;
    private Float gardiennage;
    private String statut;
    private Float montantTotal;
 
    @Resource(name="mail/devarence")
	private Session session;
    /**
     * Creates a new instance of QuittanceBean
     */
    public QuittanceBean() {
        
    }


    public String getLocataireDestinantaire() {
        return locataireDestinantaire;
    }

    public void setLocataireDestinantaire(String locataireDestinantaire) {
        this.locataireDestinantaire = locataireDestinantaire;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(String dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Float getReste() {
        return reste;
    }

    public void setReste(Float reste) {
        this.reste = reste;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getNaiss() {
        return naiss;
    }

    public void setNaiss(Date naiss) {
        this.naiss = naiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCNI() {
        return CNI;
    }

    public void setCNI(String CNI) {
        this.CNI = CNI;
    }

    public String getNomAdresse() {
        return nomAdresse;
    }

    public void setNomAdresse(String nomAdresse) {
        this.nomAdresse = nomAdresse;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getNomI() {
        return nomI;
    }

    public void setNomI(String nomI) {
        this.nomI = nomI;
    }

    public String getSG() {
        return SG;
    }

    public void setSG(String SG) {
        this.SG = SG;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public int getNcaution() {
        return ncaution;
    }

    public void setNcaution(int ncaution) {
        this.ncaution = ncaution;
    }

    public int getNavance() {
        return navance;
    }

    public void setNavance(int navance) {
        this.navance = navance;
    }

    public int getCaution() {
        caution = ncaution * 75000;
        return caution;
    }

    public void setCaution(int caution) {
        this.caution = caution;
    }

    public int getAvance() {
        avance = navance * montant;
       return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getTotal() {
        total = avance + caution;
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getLoyer() {
        return loyer;
    }

    public void setLoyer(float loyer) {
        this.loyer = loyer;
    }

    public Float getPenalite() {
        return penalite;
    }

    public void setPenalite(Float penalite) {
        this.penalite = penalite;
    }

    public Float getGardiennage() {
        return gardiennage;
    }

    public void setGardiennage(Float gardiennage) {
        this.gardiennage = gardiennage;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    
     
    public String sendQuittance(){
     Message msg = new MimeMessage(session);
     String messages = ("Quittance de "+getNom().toUpperCase()+".\n La somme de: "+getMontant()+".\n Correspondant au local: "+getLocal().toUpperCase()+".\n Loyer du mois de: "+getDateDelivrance().toUpperCase()+"\n Reste à payer: "+getReste());
     
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Quittance de loyer "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         FacesMessage message = new FacesMessage( "QUITTANCE ENVOYEE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
        
        
        FacesMessage message = new FacesMessage( "MODIFIER MAINTENANT LE PAIEMENT DU LOCATAIRE, SI CE N'EST DEJA FAIT!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
            return "voirQuittance";
      }
    
     public String sendQuittanceAdmin(){
     Message msg = new MimeMessage(session);
     String messages = ("Quittance de "+getNom().toUpperCase()+".\n La somme de: "+getMontant()+".\n Correspondant au local: "+getLocal().toUpperCase()+".\n Loyer du mois de: "+getDateDelivrance().toUpperCase()+"\n Reste à payer: "+getReste());
     
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Quittance de loyer "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         FacesMessage message = new FacesMessage( "QUITTANCE ENVOYEE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
        
        
        FacesMessage message = new FacesMessage( "MODIFIER MAINTENANT LE PAIEMENT DU LOCATAIRE, SI CE N'EST DEJA FAIT!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
            return "/admin/voirQuittance.xhtml";
      }
     
     
      public String sendQuittanceGestionnaire(){
     Message msg = new MimeMessage(session);
     String messages = ("Quittance de "+getNom().toUpperCase()+".\n La somme de: "+getMontant()+".\n Correspondant au local: "+getLocal().toUpperCase()+".\n Loyer du mois de: "+getDateDelivrance().toUpperCase()+"\n Reste à payer: "+getReste());
     
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Quittance de loyer "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         FacesMessage message = new FacesMessage( "QUITTANCE ENVOYEE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
        
        
        FacesMessage message = new FacesMessage( "MODIFIER MAINTENANT LE PAIEMENT DU LOCATAIRE, SI CE N'EST DEJA FAIT!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
            return "/gestionnaire/voirQuittance.xhtml";
      }
      
      
    public String sendRecu(){
     Message msg = new MimeMessage(session);
     String messages = ("Réçu de "+getNom().toUpperCase()+".\n Somme: "+getMontant()+"\n Correspondant à la vente du local: "+getLocal().toUpperCase()+"\n Fait le: "+new Date());
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Réçu "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "RECU ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
         return "voirRecu";
      }
    
    
     public String sendRecuAdmin(){
     Message msg = new MimeMessage(session);
     String messages = ("Réçu de "+getNom().toUpperCase()+".\n Somme: "+getMontant()+"\n Correspondant à la vente du local: "+getLocal().toUpperCase()+"\n Fait le: "+new Date());
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Réçu "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "RECU ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
         return "/admin/voirRecu.xhtml";
      }
     public String sendRecuGestionnaire(){
     Message msg = new MimeMessage(session);
     String messages = ("Réçu de "+getNom().toUpperCase()+".\n Somme: "+getMontant()+"\n Correspondant à la vente du local: "+getLocal().toUpperCase()+"\n Fait le: "+new Date());
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Réçu "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "RECU ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
         return "/gestionnaire/voirRecu.xhtml";
      }
    
     public void sendMessage(){
     Message msg = new MimeMessage(session);
     
      try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject(getSujet());
         msg.setText(getDescription());
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "MESSAGE ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
           }
     
     
      public String sendMessageAdmin(){
     Message msg = new MimeMessage(session);
     
      try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject(getSujet());
         msg.setText(getDescription());
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "MESSAGE ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
      return "/admin/index.xhtml";
           }
      
      
      public String sendMessageSecretariat(){
     Message msg = new MimeMessage(session);
     
      try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject(getSujet());
         msg.setText(getDescription());
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "MESSAGE ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
        return "/secretariat/index.xhtml";
      }
     
      public String sendMessageGestionnaire(){
     Message msg = new MimeMessage(session);
     
      try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject(getSujet());
         msg.setText(getDescription());
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         
         FacesMessage message = new FacesMessage( "MESSAGE ENVOYE AVEC SUCCES!" );
          
        FacesContext.getCurrentInstance().addMessage( null, message );
         
     }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
        return "/gestionnaire/index.xhtml";
      }
      public String resultat(){
          getNom().toUpperCase();
          getProfession().toUpperCase();
          getNationalite().toUpperCase();
          getNaiss();
          getAdresse();
          getCNI();
          getNomAdresse();
          getPorte();
          getNomI().toUpperCase();
          getSG().toUpperCase();
          getLot();
          getMontant();
          getNcaution();
          getCaution();
          getNavance();
          getAvance();
          getTotal();
          getDateDebut();
          return "voirContrat.xhtml";
      }
     
      public String resultatAdmin(){
          getNom().toUpperCase();
          getProfession().toUpperCase();
          getNationalite().toUpperCase();
          getNaiss();
          getAdresse();
          getCNI();
          getNomAdresse();
          getPorte();
          getNomI().toUpperCase();
          getSG().toUpperCase();
          getLot();
          getMontant();
          getNcaution();
          getCaution();
          getNavance();
          getAvance();
          getTotal();
          getDateDebut();
          return "/admin/voirContrat.xhtml";
      }
      
       public String resultatGestionnaire(){
          getNom().toUpperCase();
          getProfession().toUpperCase();
          getNationalite().toUpperCase();
          getNaiss();
          getAdresse();
          getCNI();
          getNomAdresse();
          getPorte();
          getNomI().toUpperCase();
          getSG().toUpperCase();
          getLot();
          getMontant();
          getNcaution();
          getCaution();
          getNavance();
          getAvance();
          getTotal();
          getDateDebut();
          return "/gestionnaire/voirContrat.xhtml";
      }
      
     public String sendContratGestionnaire(){
     Message msg = new MimeMessage(session);
     String messages = ("Contrat de location à usage d'habitation.\r\n "
             + "Entre les soussignés\r\n "
             + "Monsieur: N'GBOBA KOKO JEAN\r\n "
             +"Domicile: PLATEAU-DOKUI\r\n"
             +"Adresse: 06 BP 1229 CIDEX 1 ABIDJAN 06\n"
             +"Telephone: 22 41 28 00\n"
             +"Le Diresteur,\n"
             +"Et\n"
             + "Mlle; Mme; M: "+getNom().toUpperCase()+".\n "
             +"Profession: "+getProfession().toUpperCase()+".\n"
             +"Nationalité: "+getNationalite().toUpperCase()+".\n"
             +"Né(e) le: "+getNaiss()+".\n"
             +"Adresse postale: "+getAdresse()+".\n"
             +"Carte Nationale d'Identité: "+getCNI()+".\n"
             +"Nom et Adresse de l'Employeur: "+getNomAdresse()+".\n"
             +"Le locataire\n"
             
             +"Il a été convenu et arrêté ce qui suit:\n"
             +"ARTICLE I: Le directeur par le présent acte loue à Mme; Mlle; M "+getNom().toUpperCase()+"\n"
             +"1 appartement/magasin de "+getPiece()+" pièce(s). Porte "+getPorte()+"\n"
             +"Situé à "+getNomI().toUpperCase()+" au "+getSG().toUpperCase()+" "+getLot()+"\n"
             
             +"ARTICLE II: La present location est consentie pour une durée indéterminée. Toutefois, l'une ou l'autre partie peut prendre l'initiative "
             +"de la rupture du contrat à charge de donner un préavis de (1) mois.\n"
             
             +"ARTICLE III: A: le loyer mensuel est fixé a "+getMontant()+" payable au plus tard le 06 (six) du mois quittance. AU DELA DE LA DATE LIMITE "
             +"DU PAIEMENT, UNE PENALITE DE 10% SERA PERCUE A TITRE DE FRAIS DE RECOUVREMENT SUR LE LOYER ET N'EST PAS NEGOCIABLE.\n"
             +getNcaution()+" Mois de caution = "+getCaution()+"F\n"
             +getNavance()+ " Mois avance = "+getAvance()+"F\n"
             + "TOTAL: "+getTotal()+"F\n"
             
             + "B: La caution n'est pas un loyer. Elle sera restituée après:\n"
             + "-Le locataire doit informer par écrit le proprietaire de la décision de quitter l'appartement ou magasin, 1 mois avant.\n"
             + "-L'état des lieux de sortie sera effectué par le proprietaire ou son représentant avec le locataire, suivi des aménagements qui lui incombent.\n"
             + "-La présentation de la quittance de loyer en cours.\n"
             + "-La présentation des réçus des résiliations des abonnements de CIE, SODECI, CI-TELCOM exigés.\n"
             + "N.B: La caution est une garantie et ne peut être substitué à un loyer.\n"
             
             + "ARTICLE IV: Les frais d'abonnement et de consommation d'eau, d'électricité et de téléphone incombent au locataire.\n"
             
             + "ARTICLE V: Les dispositions qui ne sont pas expressement prévues dans le contrat sont régies par les CAUTIONS GENERALES de LOCATION auxquelles le locataire"
             + "devra se reporter.\n"
             + "Le locataire reconnaît avoir pris connaissance des CONDITIONS GENERALES de LOCATION et s'engage à s'y conformer.\n"
             + "                                      Fait à Abidjan, le "+getDateDebut()+"\n"
             + "                                      Le locataire (Fait précéder la signature de la mention lu et approuvé)" 
             );
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Contrat de location, "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
        
        FacesMessage message = new FacesMessage( "CONTRAT ENVOYE AVEC SUCCES!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/gestionnaire/voirContrat.xhtml";
         
      }
     
       public String sendContratAdmin(){
     Message msg = new MimeMessage(session);
     String messages = ("Contrat de location à usage d'habitation.\r\n "
             + "Entre les soussignés\r\n "
             + "Monsieur: N'GBOBA KOKO JEAN\r\n "
             +"Domicile: PLATEAU-DOKUI\r\n"
             +"Adresse: 06 BP 1229 CIDEX 1 ABIDJAN 06\n"
             +"Telephone: 22 41 28 00\n"
             +"Le Diresteur,\n"
             +"Et\n"
             + "Mlle; Mme; M: "+getNom().toUpperCase()+".\n "
             +"Profession: "+getProfession().toUpperCase()+".\n"
             +"Nationalité: "+getNationalite().toUpperCase()+".\n"
             +"Né(e) le: "+getNaiss()+".\n"
             +"Adresse postale: "+getAdresse()+".\n"
             +"Carte Nationale d'Identité: "+getCNI()+".\n"
             +"Nom et Adresse de l'Employeur: "+getNomAdresse()+".\n"
             +"Le locataire\n"
             
             +"Il a été convenu et arrêté ce qui suit:\n"
             +"ARTICLE I: Le directeur par le présent acte loue à Mme; Mlle; M "+getNom().toUpperCase()+"\n"
             +"1 appartement/magasin de "+getPiece()+" pièce(s). Porte "+getPorte()+"\n"
             +"Situé à "+getNomI().toUpperCase()+" au "+getSG().toUpperCase()+" "+getLot()+"\n"
             
             +"ARTICLE II: La present location est consentie pour une durée indéterminée. Toutefois, l'une ou l'autre partie peut prendre l'initiative "
             +"de la rupture du contrat à charge de donner un préavis de (1) mois.\n"
             
             +"ARTICLE III: A: le loyer mensuel est fixé a "+getMontant()+" payable au plus tard le 06 (six) du mois quittance. AU DELA DE LA DATE LIMITE "
             +"DU PAIEMENT, UNE PENALITE DE 10% SERA PERCUE A TITRE DE FRAIS DE RECOUVREMENT SUR LE LOYER ET N'EST PAS NEGOCIABLE.\n"
             +getNcaution()+" Mois de caution = "+getCaution()+"F\n"
             +getNavance()+ " Mois avance = "+getAvance()+"F\n"
             + "TOTAL: "+getTotal()+"F\n"
             
             + "B: La caution n'est pas un loyer. Elle sera restituée après:\n"
             + "-Le locataire doit informer par écrit le proprietaire de la décision de quitter l'appartement ou magasin, 1 mois avant.\n"
             + "-L'état des lieux de sortie sera effectué par le proprietaire ou son représentant avec le locataire, suivi des aménagements qui lui incombent.\n"
             + "-La présentation de la quittance de loyer en cours.\n"
             + "-La présentation des réçus des résiliations des abonnements de CIE, SODECI, CI-TELCOM exigés.\n"
             + "N.B: La caution est une garantie et ne peut être substitué à un loyer.\n"
             
             + "ARTICLE IV: Les frais d'abonnement et de consommation d'eau, d'électricité et de téléphone incombent au locataire.\n"
             
             + "ARTICLE V: Les dispositions qui ne sont pas expressement prévues dans le contrat sont régies par les CAUTIONS GENERALES de LOCATION auxquelles le locataire"
             + "devra se reporter.\n"
             + "Le locataire reconnaît avoir pris connaissance des CONDITIONS GENERALES de LOCATION et s'engage à s'y conformer.\n"
             + "                                      Fait à Abidjan, le "+getDateDebut()+"\n"
             + "                                      Le locataire (Fait précéder la signature de la mention lu et approuvé)" 
             );
     setMessage2(messages);
     try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Contrat de location, "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
     
        
        FacesMessage message = new FacesMessage( "CONTRAT ENVOYE AVEC SUCCES!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/voirContrat.xhtml";
         
      }
     
       public String sendPenaliteAdmin(){
           Message msg = new MimeMessage(session);
           String messages = ("Loyer: "+getLoyer()+
                   "\n Pénalité: "+getPenalite()+
                   "\n Frais de gardiennage: "+getGardiennage()+
                   "\n Date d'écheance: "+getDateFin()+
                   "\n Satut: impayé"+
                   "\n Montant TOTAL: "+getMontant());
            setMessage2(messages);
             try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Penalité pour retard de paiement, "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
             return "/admin/paiement.xhtml";
       }
       
     
       public String sendPenaliteGestionnaire(){
           Message msg = new MimeMessage(session);
           String messages = ("Loyer: "+getLoyer()+
                   "\n Pénalité: "+getPenalite()+
                   "\n Frais de gardiennage: "+getGardiennage()+
                   "\n Date d'écheance: "+getDateFin()+
                   "\n Satut: impayé"+
                   "\n Montant TOTAL: "+getMontant());
            setMessage2(messages);
             try{
         
          InternetAddress[] address =  {new InternetAddress(getLocataireDestinantaire())};
          
         msg.setSubject("Penalité pour retard de paiement, "+new Date());
         msg.setText(messages);
         msg.setRecipients(RecipientType.TO, address);
         
         Transport.send(msg);
         }  catch (MessagingException ex) {
              ex.printStackTrace();
        }
             return "/gestionnaire/paiement.xhtml";
       }
}
