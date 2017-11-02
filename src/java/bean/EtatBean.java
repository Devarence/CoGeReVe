/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EtatdeslieuxFacade;
import entities.Etatdeslieux;
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
@Named(value = "etatBean")
@RequestScoped
public class EtatBean {
    @EJB
    private EtatdeslieuxFacade etatdeslieuxFacade;
    private Etatdeslieux etat;

    /**
     * Creates a new instance of EtatBean
     */
    public EtatBean() {
        this.etat = new Etatdeslieux();
    }

    public EtatdeslieuxFacade getEtatdeslieuxFacade() {
        return etatdeslieuxFacade;
    }

    public void setEtatdeslieuxFacade(EtatdeslieuxFacade etatdeslieuxFacade) {
        this.etatdeslieuxFacade = etatdeslieuxFacade;
    }

    public Etatdeslieux getEtat() {
        return etat;
    }

    public void setEtat(Etatdeslieux etat) {
        this.etat = etat;
    }

    public void create(Etatdeslieux entity) {
        etatdeslieuxFacade.create(entity);
    }

    public void edit(Etatdeslieux entity) {
        etatdeslieuxFacade.edit(entity);
    }

    public void remove(Etatdeslieux entity) {
        etatdeslieuxFacade.remove(entity);
    }

    public Etatdeslieux find(Object id) {
        return etatdeslieuxFacade.find(id);
    }

    public List<Etatdeslieux> findAll() {
        return etatdeslieuxFacade.findAll();
    }

    public List<Etatdeslieux> findRange(int[] range) {
        return etatdeslieuxFacade.findRange(range);
    }

    public int count() {
        return etatdeslieuxFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Etatdeslieux prepareCreate() {
        etat = new Etatdeslieux();
        initializeEmbeddableKey();
        return etat;
    }

         
       @FacesConverter(forClass = Etatdeslieux.class)
    public static class EtatBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EtatBean controller = (EtatBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "EtatBean");
            return controller.getEtat(getKey(value));
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
            if (object instanceof Etatdeslieux) {
                Etatdeslieux o = (Etatdeslieux) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Etatdeslieux.class.getName()});
                return null;
            }
        }

    }
        public void creerEtat(){
        this.etatdeslieuxFacade.create(etat);
        FacesMessage message = new FacesMessage( "Créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerEtat(){
        this.etatdeslieuxFacade.remove(etat);
        FacesMessage message = new FacesMessage( "Supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierEtat(){
        this.etatdeslieuxFacade.edit(etat);
        FacesMessage message = new FacesMessage( "Modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
      public String creerEtatAdmin(){
        this.etatdeslieuxFacade.create(etat);
        FacesMessage message = new FacesMessage( "Créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListEtat.xhtml";
        
    }
  
    
    public String supprimerEtatAdmin(){
        this.etatdeslieuxFacade.remove(etat);
        FacesMessage message = new FacesMessage( "Supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListEtat.xhtml";
      }
    
     public String modifierEtatAdmin(){
        this.etatdeslieuxFacade.edit(etat);
        FacesMessage message = new FacesMessage( "Modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListEtat.xhtml";
      }
     
      public Etatdeslieux getetat(java.lang.Long id) {
        return getEtatdeslieuxFacade().find(id);
    }
      
       public Etatdeslieux getEtat(java.lang.Long id) {
        return getEtatdeslieuxFacade().find(id);
    }

    public List<Etatdeslieux> getItemsAvailableSelectMany() {
        return getEtatdeslieuxFacade().findAll();
    }

    public List<Etatdeslieux> getItemsAvailableSelectOne() {
        return getEtatdeslieuxFacade().findAll();
    }
}
