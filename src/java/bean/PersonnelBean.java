/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PersonnelFacade;
import entities.Personnel;
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
@Named(value = "personnelBean")
@RequestScoped
public class PersonnelBean {
    @EJB
    private PersonnelFacade personnelFacade;
    private Personnel personnel;

    /**
     * Creates a new instance of PersonnelBean
     */
    public PersonnelBean() {
        this.personnel = new Personnel();
    }

    public PersonnelFacade getPersonnelFacade() {
        return personnelFacade;
    }

    public void setPersonnelFacade(PersonnelFacade personnelFacade) {
        this.personnelFacade = personnelFacade;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public void create(Personnel entity) {
        personnelFacade.create(entity);
    }

    public void edit(Personnel entity) {
        personnelFacade.edit(entity);
    }

    public void remove(Personnel entity) {
        personnelFacade.remove(entity);
    }

    public Personnel find(Object id) {
        return personnelFacade.find(id);
    }

    public List<Personnel> findAll() {
        return personnelFacade.findAll();
    }

    public List<Personnel> findRange(int[] range) {
        return personnelFacade.findRange(range);
    }

    public int count() {
        return personnelFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Personnel prepareCreate() {
        personnel = new Personnel();
        initializeEmbeddableKey();
        return personnel;
    }

   
       @FacesConverter(forClass = Personnel.class)
    public static class PersonnelBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonnelBean controller = (PersonnelBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personnelBean");
            return controller.getPersonnel(getKey(value));
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
            if (object instanceof Personnel) {
                Personnel o = (Personnel) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Personnel.class.getName()});
                return null;
            }
        }

    }
         public void creerPersonnel(){
        this.personnelFacade.create(personnel);
        FacesMessage message = new FacesMessage( "Personnel créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerPersonnel(){
        this.personnelFacade.remove(personnel);
        FacesMessage message = new FacesMessage( "Personnel supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierPersonnel(){
        this.personnelFacade.edit(personnel);
        FacesMessage message = new FacesMessage( "Personnel modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
       public String creerPersonnelAdmin(){
        this.personnelFacade.create(personnel);
        FacesMessage message = new FacesMessage( "Personnel créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListPersonnel.xhtml";
    }
  
    
    public String supprimerPersonnelAdmin(){
        this.personnelFacade.remove(personnel);
        FacesMessage message = new FacesMessage( "Personnel supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListPersonnel.xhtml";
      }
    
     public String modifierPersonnelAdmin(){
        this.personnelFacade.edit(personnel);
        FacesMessage message = new FacesMessage( "Personnel modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListPersonnel.xhtml";
      }
     
      public Personnel getpersonnel(java.lang.Long id) {
        return getPersonnelFacade().find(id);
    }
      
       public Personnel getPersonnel(java.lang.Long id) {
        return getPersonnelFacade().find(id);
    }

    public List<Personnel> getItemsAvailableSelectMany() {
        return getPersonnelFacade().findAll();
    }

    public List<Personnel> getItemsAvailableSelectOne() {
        return getPersonnelFacade().findAll();
    }
}
