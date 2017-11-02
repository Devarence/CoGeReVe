/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.LocataireFacade;
import entities.Locataire;
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
@Named(value = "locataireBean")
@RequestScoped
public class LocataireBean {
    @EJB
    private LocataireFacade locataireFacade;
    private Locataire locataire;

    /**
     * Creates a new instance of LocataireBean
     */
    public LocataireBean() {
        this.locataire = new Locataire();
    }

    public LocataireFacade getLocataireFacade() {
        return locataireFacade;
    }

    public void setLocataireFacade(LocataireFacade locataireFacade) {
        this.locataireFacade = locataireFacade;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public void create(Locataire entity) {
        locataireFacade.create(entity);
    }

    public void edit(Locataire entity) {
        locataireFacade.edit(entity);
    }

    public void remove(Locataire entity) {
        locataireFacade.remove(entity);
    }

    public Locataire find(Object id) {
        return locataireFacade.find(id);
    }

    public List<Locataire> findAll() {
        return locataireFacade.findAll();
    }

    public List<Locataire> findRange(int[] range) {
        return locataireFacade.findRange(range);
    }

    public int count() {
        return locataireFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Locataire prepareCreate() {
        locataire = new Locataire();
        initializeEmbeddableKey();
        return locataire;
    }

         
      
       @FacesConverter(forClass = Locataire.class)
    public static class LocataireBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LocataireBean controller = (LocataireBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "locataireBean");
            return controller.getLocataire(getKey(value));
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
            if (object instanceof Locataire) {
                Locataire o = (Locataire) object;
                return getStringKey(o.getIdlocataire());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Locataire.class.getName()});
                return null;
            }
        }

    }
       
        public void creerLocataire(){
        this.locataireFacade.create(locataire);
        FacesMessage message = new FacesMessage( "Locataire créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerLocataire(){
        this.locataireFacade.remove(locataire);
        FacesMessage message = new FacesMessage( "Locataire supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierLocataire(){
        this.locataireFacade.edit(locataire);
        FacesMessage message = new FacesMessage( "Locataire modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
      public String creerLocataireAdmin(){
        this.locataireFacade.create(locataire);
        FacesMessage message = new FacesMessage( "Locataire créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListLocataire.xhtml";
    }
  
    
    public String supprimerLocataireAdmin(){
        this.locataireFacade.remove(locataire);
        FacesMessage message = new FacesMessage( "Locataire supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListLocataire.xhtml";
      }
    
     public String modifierLocataireAdmin(){
        this.locataireFacade.edit(locataire);
        FacesMessage message = new FacesMessage( "Locataire modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListLocataire.xhtml";
      }
     
      public Locataire getlocataire(java.lang.Long id) {
        return getLocataireFacade().find(id);
    }

    public List<Locataire> getItemsAvailableSelectMany() {
        return getLocataireFacade().findAll();
    }

    public List<Locataire> getItemsAvailableSelectOne() {
        return getLocataireFacade().findAll();
    }
    
    public Locataire getLocataire(java.lang.Long id) {
        return getLocataireFacade().find(id);
    }
    
}
