/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DossierpersonnelFacade;
import entities.Dossierpersonnel;
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
@Named(value = "dossierBean")
@RequestScoped
public class DossierBean {
    @EJB
    private DossierpersonnelFacade dossierpersonnelFacade;
    private Dossierpersonnel dossier;

    /**
     * Creates a new instance of DossierBean
     */
    public DossierBean() {
       this.dossier = new Dossierpersonnel();
    }

    public DossierpersonnelFacade getDossierpersonnelFacade() {
        return dossierpersonnelFacade;
    }

    public void setDossierpersonnelFacade(DossierpersonnelFacade dossierpersonnelFacade) {
        this.dossierpersonnelFacade = dossierpersonnelFacade;
    }

    public Dossierpersonnel getDossier() {
        return dossier;
    }

    public void setDossier(Dossierpersonnel dossier) {
        this.dossier = dossier;
    }

    public void create(Dossierpersonnel entity) {
        dossierpersonnelFacade.create(entity);
    }

    public void edit(Dossierpersonnel entity) {
        dossierpersonnelFacade.edit(entity);
    }

    public void remove(Dossierpersonnel entity) {
        dossierpersonnelFacade.remove(entity);
    }

    public Dossierpersonnel find(Object id) {
        return dossierpersonnelFacade.find(id);
    }

    public List<Dossierpersonnel> findAll() {
        return dossierpersonnelFacade.findAll();
    }

    public List<Dossierpersonnel> findRange(int[] range) {
        return dossierpersonnelFacade.findRange(range);
    }

    public int count() {
        return dossierpersonnelFacade.count();
    }
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Dossierpersonnel prepareCreate() {
        dossier = new Dossierpersonnel();
        initializeEmbeddableKey();
        return dossier;
    }

        
      
       @FacesConverter(forClass = Dossierpersonnel.class)
    public static class DossierBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DossierBean controller = (DossierBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dossierBean");
            return controller.getDossier(getKey(value));
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
            if (object instanceof Dossierpersonnel) {
                Dossierpersonnel o = (Dossierpersonnel) object;
                return getStringKey(o.getIddossierPersonnel());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Dossierpersonnel.class.getName()});
                return null;
            }
        }

    }
         public void creerDossier(){
        this.dossierpersonnelFacade.create(dossier);
        FacesMessage message = new FacesMessage( "Dossier créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
  
    
    public void supprimerDossier(){
        this.dossierpersonnelFacade.remove(dossier);
        FacesMessage message = new FacesMessage( "Dossier supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
    
     public void modifierDossier(){
        this.dossierpersonnelFacade.edit(dossier);
        FacesMessage message = new FacesMessage( "Dossier modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
      }
     
     public String creerDossierAdmin(){
        this.dossierpersonnelFacade.create(dossier);
        FacesMessage message = new FacesMessage( "Dossier créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListDossier.xhtml";
        
    }
  
    
    public String supprimerDossierAdmin(){
        this.dossierpersonnelFacade.remove(dossier);
        FacesMessage message = new FacesMessage( "Dossier supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListDossier.xhtml";
      }
    
     public String modifierDossierAdmin(){
        this.dossierpersonnelFacade.edit(dossier);
        FacesMessage message = new FacesMessage( "Dossier modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListDossier.xhtml";
      }
     
      public Dossierpersonnel getdossier(java.lang.Long id) {
        return getDossierpersonnelFacade().find(id);
    }
      
        public Dossierpersonnel getDossier(java.lang.Long id) {
        return getDossierpersonnelFacade().find(id);
    }

    public List<Dossierpersonnel> getItemsAvailableSelectMany() {
        return getDossierpersonnelFacade().findAll();
    }

    public List<Dossierpersonnel> getItemsAvailableSelectOne() {
        return getDossierpersonnelFacade().findAll();
    }
     
}
