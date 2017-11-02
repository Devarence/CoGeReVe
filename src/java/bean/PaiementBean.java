/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PaiementFacade;
import entities.Paiement;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

/**
 *
 * @author devarence
 */
@Named(value = "paiementBean")
@RequestScoped
public class PaiementBean {
    @EJB
    private PaiementFacade paiementFacade;
    private Paiement paiement;
     @PersistenceContext 
    private EntityManager em;

    /**
     * Creates a new instance of PaiementBean
     */
    public PaiementBean() {
        this.paiement = new Paiement();
    }

    public PaiementFacade getPaiementFacade() {
        return paiementFacade;
    }

    public void setPaiementFacade(PaiementFacade paiementFacade) {
        this.paiementFacade = paiementFacade;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public void create(Paiement entity) {
        paiementFacade.create(entity);
    }

    public void edit(Paiement entity) {
        paiementFacade.edit(entity);
    }

    public void remove(Paiement entity) {
        paiementFacade.remove(entity);
    }

    public Paiement find(Object id) {
        return paiementFacade.find(id);
    }
    
    
   
    public List<Paiement> findAll() {
         return paiementFacade.findAll();
    }    

    public int count() {
        return paiementFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Paiement prepareCreate() {
        paiement = new Paiement();
        initializeEmbeddableKey();
        return paiement;
    }

   
       @FacesConverter(forClass = Paiement.class)
    public static class PaiementBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PaiementBean controller = (PaiementBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "paiementBean");
            return controller.getPaiement(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Paiement) {
                Paiement o = (Paiement) object;
                return getStringKey(o.getIdpaiement());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Paiement.class.getName()});
                return null;
            }
        }

    }
        public void creerPaiement(){
        totaux = paiement.getLoyer() + paiement.getFraisGardiennage();
        paiement.setTotal(totaux);
        this.paiementFacade.create(paiement);
        FacesMessage message = new FacesMessage( "Paiement créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerPaiement(){
        this.paiementFacade.remove(paiement);
        FacesMessage message = new FacesMessage( "Paiement supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierPaiement(){
         totaux = paiement.getLoyer() + paiement.getFraisGardiennage();
        paiement.setTotal(totaux);
        this.paiementFacade.edit(paiement);
        
        FacesMessage message = new FacesMessage( "Paiement modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
      public String creerPaiementAdmin(){
        totaux = paiement.getLoyer() + paiement.getFraisGardiennage();
        paiement.setTotal(totaux);
        this.paiementFacade.create(paiement);
        FacesMessage message = new FacesMessage( "Paiement créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListPaiement.xhtml";
    }
  
    
    public String supprimerPaiementAdmin(){
        this.paiementFacade.remove(paiement);
        FacesMessage message = new FacesMessage( "Paiement supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListPaiement.xhtml";
      }
    
     public String modifierPaiementAdmin(){
         totaux = paiement.getLoyer() + paiement.getFraisGardiennage();
        paiement.setTotal(totaux);
        this.paiementFacade.edit(paiement);
        
        FacesMessage message = new FacesMessage( "Paiement modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListPaiement.xhtml";
      }
     
      public Paiement getpaiement(java.lang.Long id) {
        return getPaiementFacade().find(id);
    }
      
        public Paiement getPaiement(java.lang.Long id) {
        return getPaiementFacade().find(id);
    }

    public List<Paiement> getItemsAvailableSelectMany() {
        return getPaiementFacade().findAll();
    }

    public List<Paiement> getItemsAvailableSelectOne() {
        return getPaiementFacade().findAll();
    }
      
    
    private List<Paiement> paie= new ArrayList<>() ;
    private float penal;
    private String statut;
    private float totaux;
    
    public String operationPaie(){
                            
               if(paiement.getDateEcheance().before(new Date())){
                  penal = paiement.getLoyer()*paiement.getPourcentage();
                  statut = "impaye";
                 
               }
               else{
                   penal = 0;
                   statut = "paye";
               }
               totaux = paiement.getLoyer()+penal+paiement.getFraisGardiennage();
               paiement.setPenalite(penal);
               paiement.setStatutPaiement(statut);
               paiement.setTotal(totaux);
               this.paiementFacade.edit(paiement);
         return "/admin/paiement.xhtml";
                    
       }
        
     public String operationPaie2(){
            paie.add(paiement);
            for(Paiement paies:paie){
               if(paies.getDateEcheance().before(new Date())){
                  penal = paies.getLoyer()*paies.getPourcentage();
                  statut = "impaye";
                 
               }
               else{
                   penal = 0;
                   statut = "paye";
               }
               totaux = paies.getLoyer()+penal+paies.getFraisGardiennage();
               paiement.setPenalite(penal);
               paiement.setStatutPaiement(statut);
               paiement.setTotal(totaux);
               this.paiementFacade.edit(paiement);
        
                    
       }
             return "/admin/paiement.xhtml";
     }
     
     public String operationPaieComptable(){
            paie.add(paiement);
            for(Paiement paies:paie){
               if(paies.getDateEcheance().before(new Date())){
                  penal = paies.getLoyer()*paies.getPourcentage();
                  statut = "impaye";
                 
               }
               else{
                   penal = 0;
                   statut = "paye";
               }
               totaux = paies.getLoyer()+penal+paies.getFraisGardiennage();
               paiement.setPenalite(penal);
               paiement.setStatutPaiement(statut);
               paiement.setTotal(totaux);
               this.paiementFacade.edit(paiement);
        
                    
       }
             return "/comptable/paiement.xhtml";
     }
     
        public String operationPaieGestionnaire(){
            paie.add(paiement);
            for(Paiement paies:paie){
               if(paies.getDateEcheance().before(new Date())){
                  penal = paies.getLoyer()*paies.getPourcentage();
                  statut = "impaye";
                 
               }
               else{
                   penal = 0;
                   statut = "paye";
               }
               totaux = paies.getLoyer()+penal+paies.getFraisGardiennage();
               paiement.setPenalite(penal);
               paiement.setStatutPaiement(statut);
               paiement.setTotal(totaux);
               this.paiementFacade.edit(paiement);
        
                    
       }
             return "/gestionnaire/paiement.xhtml";
     }
}
