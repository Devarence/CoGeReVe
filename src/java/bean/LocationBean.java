/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.LocationFacade;
import entities.Location;
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
@Named(value = "locationBean")
@RequestScoped
public class LocationBean {
    @EJB
    private LocationFacade locationFacade;
    private Location location;

    /**
     * Creates a new instance of LocationBean
     */
    public LocationBean() {
      this.location = new Location();
    }

    public LocationFacade getLocationFacade() {
        return locationFacade;
    }

    public void setLocationFacade(LocationFacade locationFacade) {
        this.locationFacade = locationFacade;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void create(Location entity) {
        locationFacade.create(entity);
    }

    public void edit(Location entity) {
        locationFacade.edit(entity);
    }

    public void remove(Location entity) {
        locationFacade.remove(entity);
    }

    public Location find(Object id) {
        return locationFacade.find(id);
    }

    public List<Location> findAll() {
        return locationFacade.findAll();
    }

    public List<Location> findRange(int[] range) {
        return locationFacade.findRange(range);
    }

    public int count() {
        return locationFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Location prepareCreate() {
        location = new Location();
        initializeEmbeddableKey();
        return location;
    }

   
      public Location getlocation(java.lang.Long id) {
        return getLocationFacade().find(id);
    }
      
      public Location getLocation(java.lang.Long id) {
        return getLocationFacade().find(id);
    }

    public List<Location> getItemsAvailableSelectMany() {
        return getLocationFacade().findAll();
    }

    public List<Location> getItemsAvailableSelectOne() {
        return getLocationFacade().findAll();
    }
    
        
       @FacesConverter(forClass = Location.class)
    public static class LocationBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LocationBean controller = (LocationBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "antecedentBean");
            return controller.getLocation(getKey(value));
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
            if (object instanceof Location) {
                Location o = (Location) object;
                return getStringKey(o.getIdlocation());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Location.class.getName()});
                return null;
            }
        }

    }
         public void creerLocation(){
        this.locationFacade.create(location);
        FacesMessage message = new FacesMessage( "Location créée avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerLocation(){
        this.locationFacade.remove(location);
        FacesMessage message = new FacesMessage( "Location supprimée avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierLocation(){
        this.locationFacade.edit(location);
        FacesMessage message = new FacesMessage( "Location modifiée avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
      public String creerLocationAdmin(){
        this.locationFacade.create(location);
        FacesMessage message = new FacesMessage( "Location créée avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListLocation.xhtml";
    }
  
    
    public String supprimerLocationAdmin(){
        this.locationFacade.remove(location);
        FacesMessage message = new FacesMessage( "Location supprimée avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListLocation.xhtml";
      }
    
     public String modifierLocationAdmin(){
        this.locationFacade.edit(location);
        FacesMessage message = new FacesMessage( "Location modifiée avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListLocation.xhtml";
      }
    
}
