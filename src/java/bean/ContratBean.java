/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ContratFacade;
import entities.Contrat;
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
@Named(value = "contratBean")
@RequestScoped
public class ContratBean {
    @EJB
    private ContratFacade contratFacade;
    private Contrat contrat;

    /**
     * Creates a new instance of ContratBean
     */
    public ContratBean() {
        this.contrat = new Contrat();
    }

    public ContratFacade getContratFacade() {
        return contratFacade;
    }

    public void setContratFacade(ContratFacade contratFacade) {
        this.contratFacade = contratFacade;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    
    
    public void create(Contrat entity) {
        contratFacade.create(entity);
    }

    public void edit(Contrat entity) {
        contratFacade.edit(entity);
    }

    public void remove(Contrat entity) {
        contratFacade.remove(entity);
    }

    public Contrat find(Object id) {
        return contratFacade.find(id);
    }

    public List<Contrat> findAll() {
        return contratFacade.findAll();
    }

    public List<Contrat> findRange(int[] range) {
        return contratFacade.findRange(range);
    }

    public int count() {
        return contratFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Contrat prepareCreate() {
        contrat = new Contrat();
        initializeEmbeddableKey();
        return contrat;
    }

        
      
       @FacesConverter(forClass = Contrat.class)
    public static class ContratBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ContratBean controller = (ContratBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "contratBean");
            return controller.getContrat(getKey(value));
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
            if (object instanceof Contrat) {
                Contrat o = (Contrat) object;
                return getStringKey(o.getIdcontrat());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Contrat.class.getName()});
                return null;
            }
        }

    }
       
          public void creerContrat(){
        this.contratFacade.create(contrat);
        FacesMessage message = new FacesMessage( "Contrat créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerContrat(){
        this.contratFacade.remove(contrat);
        FacesMessage message = new FacesMessage( "Contrat supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierContrat(){
        this.contratFacade.edit(contrat);
        FacesMessage message = new FacesMessage( "Contrat modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
       public String creerContratAdmin(){
        this.contratFacade.create(contrat);
        FacesMessage message = new FacesMessage( "Contrat créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListContrat.xhtml";
    }
  
    
    public String supprimerContratAdmin(){
        this.contratFacade.remove(contrat);
        FacesMessage message = new FacesMessage( "Contrat supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListContrat.xhtml";
      }
    
     public String modifierContratAdmin(){
        this.contratFacade.edit(contrat);
        FacesMessage message = new FacesMessage( "Contrat modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListContrat.xhtml";
      }
     
      public Contrat getcontrat(java.lang.Long id) {
        return getContratFacade().find(id);
    }
      
       public Contrat getContrat(java.lang.Long id) {
        return getContratFacade().find(id);
    }

    public List<Contrat> getItemsAvailableSelectMany() {
        return getContratFacade().findAll();
    }

    public List<Contrat> getItemsAvailableSelectOne() {
        return getContratFacade().findAll();
    }
    
}
