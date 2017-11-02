/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RolesFacade;
import entities.Roles;
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
@Named(value = "roleBean")
@RequestScoped
public class RoleBean {
    @EJB
    private RolesFacade rolesFacade;
    private Roles role;

    /**
     * Creates a new instance of RoleBean
     */
    public RoleBean() {
        this.role = new Roles();
    }

    public RolesFacade getRolesFacade() {
        return rolesFacade;
    }

    public void setRolesFacade(RolesFacade rolesFacade) {
        this.rolesFacade = rolesFacade;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void create(Roles entity) {
        rolesFacade.create(entity);
    }

    public void edit(Roles entity) {
        rolesFacade.edit(entity);
    }

    public void remove(Roles entity) {
        rolesFacade.remove(entity);
    }

    public Roles find(Object id) {
        return rolesFacade.find(id);
    }

    public List<Roles> findAll() {
        return rolesFacade.findAll();
    }

    public List<Roles> findRange(int[] range) {
        return rolesFacade.findRange(range);
    }

    public int count() {
        return rolesFacade.count();
    }
    
      protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Roles prepareCreate() {
        role = new Roles();
        initializeEmbeddableKey();
        return role;
    }
      
         @FacesConverter(forClass = Roles.class)
    public static class RoleBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RoleBean controller = (RoleBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "roleBean");
            return controller.getRole(getKey(value));
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
            if (object instanceof Roles) {
                Roles o = (Roles) object;
                return getStringKey(o.getIdrole());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Roles.class.getName()});
                return null;
            }
        }

    }
          public Roles getrole(java.lang.Long id) {
        return getRolesFacade().find(id);
    }
     
       public Roles getRole(java.lang.Long id) {
        return getRolesFacade().find(id);
    }

    public List<Roles> getItemsAvailableSelectMany() {
        return getRolesFacade().findAll();
    }

    public List<Roles> getItemsAvailableSelectOne() {
        return getRolesFacade().findAll();
    }
    
       public void creerRole(){
        this.rolesFacade.create(role);
        FacesMessage message = new FacesMessage( "Role créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerRole(){
        this.rolesFacade.remove(role);
        FacesMessage message = new FacesMessage( "Role supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierRole(){
        this.rolesFacade.edit(role);
        FacesMessage message = new FacesMessage( "Role modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
}
