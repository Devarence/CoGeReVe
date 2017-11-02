/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.BienimmobilierFacade;
import entities.Bienimmobilier;
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

/**
 *
 * @author devarence
 */
@Named(value = "bienBean")
@RequestScoped
public class BienBean {
    @EJB
    private BienimmobilierFacade bienimmobilierFacade;
    private Bienimmobilier bien;
    

    /**
     * Creates a new instance of BienBean
     */
    public BienBean() {
        this.bien = new Bienimmobilier();
    }

    public BienimmobilierFacade getBienimmobilierFacade() {
        return bienimmobilierFacade;
    }

    public void setBienimmobilierFacade(BienimmobilierFacade bienimmobilierFacade) {
        this.bienimmobilierFacade = bienimmobilierFacade;
    }

    public Bienimmobilier getBien() {
        return bien;
    }

    public void setBien(Bienimmobilier bien) {
        this.bien = bien;
    }

    public void create(Bienimmobilier entity) {
        bienimmobilierFacade.create(entity);
    }

    public void edit(Bienimmobilier entity) {
        bienimmobilierFacade.edit(entity);
    }

    public void remove(Bienimmobilier entity) {
        bienimmobilierFacade.remove(entity);
    }


    public List<Bienimmobilier> findAll() {
        return bienimmobilierFacade.findAll();
    }

    public List<Bienimmobilier> findRange(int[] range) {
        return bienimmobilierFacade.findRange(range);
    }

    public int count() {
        return bienimmobilierFacade.count();
    }
    
      protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Bienimmobilier prepareCreate() {
        bien = new Bienimmobilier();
        initializeEmbeddableKey();
        return bien;
    }

   
       @FacesConverter(forClass = Bienimmobilier.class)
    public static class BienBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BienBean controller = (BienBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bienBean");
            return controller.getBien(getKey(value));
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
            if (object instanceof Bienimmobilier) {
                Bienimmobilier o = (Bienimmobilier) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Bienimmobilier.class.getName()});
                return null;
            }
        }

    }
       
         public void creerBien(){
        this.bienimmobilierFacade.create(bien);
        FacesMessage message = new FacesMessage( "Bien créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerBien(){
        this.bienimmobilierFacade.remove(bien);
        FacesMessage message = new FacesMessage( "Bien supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierBien(){
        this.bienimmobilierFacade.edit(bien);
        FacesMessage message = new FacesMessage( "Bien modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
      public String creerBienAdmin(){
        this.bienimmobilierFacade.create(bien);
        FacesMessage message = new FacesMessage( "Bien créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListBien.xhtml";
    }
  
    
    public String supprimerBienAdmin(){
        this.bienimmobilierFacade.remove(bien);
        FacesMessage message = new FacesMessage( "Bien supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListBien.xhtml";
      }
    
     public String modifierBienAdmin(){
        this.bienimmobilierFacade.edit(bien);
        FacesMessage message = new FacesMessage( "Bien modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListBien.xhtml";
      }
     private String statut;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
     
    /* public List<Bienimmobilier> trouverStatut(){
         return this.bienimmobilierFacade.find(statut);
     }*/
     
     private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     
     /*public List<Bienimmobilier> trouverNom(){
         return this.bienimmobilierFacade.find(nom);
     }*/
     
     private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
     
    /*public List<Bienimmobilier> afficherType(){
         return this.bienimmobilierFacade.find(type);
     }*/
    
     public Bienimmobilier getbien(java.lang.Long id) {
        return getBienimmobilierFacade().find(id);
    }
     
       public Bienimmobilier getBien(java.lang.Long id) {
        return getBienimmobilierFacade().find(id);
    }

    public List<Bienimmobilier> getItemsAvailableSelectMany() {
        return getBienimmobilierFacade().findAll();
    }

    public List<Bienimmobilier> getItemsAvailableSelectOne() {
        return getBienimmobilierFacade().findAll();
    }
}
