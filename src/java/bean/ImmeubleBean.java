/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ImmeubleFacade;
import entities.Immeuble;
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
@Named(value = "immeubleBean")
@RequestScoped
public class ImmeubleBean {
    @EJB
    private ImmeubleFacade immeubleFacade;
    private Immeuble immeuble;

    /**
     * Creates a new instance of ImmeubleBean
     */
    public ImmeubleBean() {
        this.immeuble = new Immeuble();
    }

    public ImmeubleFacade getImmeubleFacade() {
        return immeubleFacade;
    }

    public void setImmeubleFacade(ImmeubleFacade immeubleFacade) {
        this.immeubleFacade = immeubleFacade;
    }

    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }

    public void create(Immeuble entity) {
        immeubleFacade.create(entity);
    }

    public void edit(Immeuble entity) {
        immeubleFacade.edit(entity);
    }

    public void remove(Immeuble entity) {
        immeubleFacade.remove(entity);
    }

    public Immeuble find(Object id) {
        return immeubleFacade.find(id);
    }

    public List<Immeuble> findAll() {
        return immeubleFacade.findAll();
    }

    public List<Immeuble> findRange(int[] range) {
        return immeubleFacade.findRange(range);
    }

    public int count() {
        return immeubleFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Immeuble prepareCreate() {
        immeuble = new Immeuble();
        initializeEmbeddableKey();
        return immeuble;
    }

        
      
       @FacesConverter(forClass = Immeuble.class)
    public static class ImmeubleBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImmeubleBean controller = (ImmeubleBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "immeubleBean");
            return controller.getImmeuble(getKey(value));
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
            if (object instanceof Immeuble) {
                Immeuble o = (Immeuble) object;
                return getStringKey(o.getIdimmeuble());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Immeuble.class.getName()});
                return null;
            }
        }

    }
          public void creerImmeuble(){
        this.immeubleFacade.create(immeuble);
        FacesMessage message = new FacesMessage( "Immeuble créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerImmeuble(){
        this.immeubleFacade.remove(immeuble);
        FacesMessage message = new FacesMessage( "Immeuble supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierImmeuble(){
        this.immeubleFacade.edit(immeuble);
        FacesMessage message = new FacesMessage( "Immeuble modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
      public String creerImmeubleAdmin(){
        this.immeubleFacade.create(immeuble);
        FacesMessage message = new FacesMessage( "Immeuble créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListImmeuble.xhtml";
    }
  
    
    public String supprimerImmeubleAdmin(){
        this.immeubleFacade.remove(immeuble);
        FacesMessage message = new FacesMessage( "Immeuble supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListImmeuble.xhtml";
      }
    
     public String modifierImmeubleAdmin(){
        this.immeubleFacade.edit(immeuble);
        FacesMessage message = new FacesMessage( "Immeuble modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListImmeuble.xhtml";
      }
     
      public Immeuble getimmeuble(java.lang.Long id) {
        return getImmeubleFacade().find(id);
    }
      
      public Immeuble getImmeuble(java.lang.Long id) {
        return getImmeubleFacade().find(id);
    }

    public List<Immeuble> getItemsAvailableSelectMany() {
        return getImmeubleFacade().findAll();
    }

    public List<Immeuble> getItemsAvailableSelectOne() {
        return getImmeubleFacade().findAll();
    }
}
