/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AntecedentFacade;
import entities.Antecedent;
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
@Named(value = "antecedentBean")
@RequestScoped
public class AntecedentBean {
  @EJB
    private AntecedentFacade antecedentFacade;
    private Antecedent antecedent;
    private List<Antecedent> filtreAntecedent;
   

    /**
     * Creates a new instance of AntecedentBean
     */
    public AntecedentBean() {
        this.antecedent = new Antecedent();
    }

    public List<Antecedent> getFiltreAntecedent() {
        return filtreAntecedent;
    }

    public void setFiltreAntecedent(List<Antecedent> filtreAntecedent) {
        this.filtreAntecedent = filtreAntecedent;
    }


    public AntecedentFacade getAntecedentFacade() {
        return antecedentFacade;
    }

    public void setAntecedentFacade(AntecedentFacade antecedentFacade) {
        this.antecedentFacade = antecedentFacade;
    }

    public Antecedent getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    public void create(Antecedent entity) {
        antecedentFacade.create(entity);
    }

    public void edit(Antecedent entity) {
        antecedentFacade.edit(entity);
    }

    public void remove(Antecedent entity) {
        antecedentFacade.remove(entity);
    }


    public List<Antecedent> findAll() {
        return antecedentFacade.findAll();
    }

    public List<Antecedent> findRange(int[] range) {
        return antecedentFacade.findRange(range);
    }

    public int count() {
        return antecedentFacade.count();
    }
    
     public String creerAntecedent(){
        this.antecedentFacade.create(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "ListAntecedent";
    }
  
     public String creerAntecedentAdmin(){
        this.antecedentFacade.create(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListAntecedent.xhtml";
    }
    
    public String supprimerAntecedent(){
        this.antecedentFacade.remove(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "ListAntecedent";
    }
    
     public String supprimerAntecedentAdmin(){
        this.antecedentFacade.remove(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListAntecedent.xhtml";
    }
    
     public String modifierAntecedent(){
        this.antecedentFacade.edit(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "ListAntecedent";        
    }
     
      public String modifierAntecedentAdmin(){
        this.antecedentFacade.edit(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListAntecedent.xhtml";        
    }
      public String creerAntecedentSecretariat(){
        this.antecedentFacade.create(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/secretariat/ListAntecedent.xhtml";
    }
  
    
    public String supprimerAntecedentSecretariat(){
        this.antecedentFacade.remove(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/secretariat/ListAntecedent.xhtml";
    }
    
     public String modifierAntecedentSecretariat(){
        this.antecedentFacade.edit(antecedent);
        FacesMessage message = new FacesMessage( "Antecedent modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/secretariat/ListAntecedent.xhtml";        
    }
    
    public List<entities.Antecedent> afficherAntecedent(){
        return antecedentFacade.findAll();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Antecedent prepareCreate() {
        antecedent = new Antecedent();
        initializeEmbeddableKey();
        return antecedent;
    }

   
      
       @FacesConverter(forClass = Antecedent.class)
    public static class AntecedentBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AntecedentBean controller = (AntecedentBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "antecedentBean");
            return controller.getAntecedent(getKey(value));
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
            if (object instanceof Antecedent) {
                Antecedent o = (Antecedent) object;
                return getStringKey(o.getIdantecedent());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Antecedent.class.getName()});
                return null;
            }
        }

    }
       
         public Antecedent getantecedent(java.lang.Long id) {
        return getAntecedentFacade().find(id);
    }
         public Antecedent getAntecedent(java.lang.Long id) {
        return getAntecedentFacade().find(id);
    }

    public List<Antecedent> getItemsAvailableSelectMany() {
        return getAntecedentFacade().findAll();
    }

    public List<Antecedent> getItemsAvailableSelectOne() {
        return getAntecedentFacade().findAll();
    }
 
    
}
