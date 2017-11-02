/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;



import dao.UtilisateurFacade;

import entities.Utilisateur;
import java.security.Key;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author devarence
 */

public class ExempleBean {
    
    @EJB
    private UtilisateurFacade utilisateurFacade;
    private Utilisateur utilisateur;
    
     public static final  String USER_SESSION_KEY = "user";
    

     @Resource 
    private UserTransaction utx;
      @PersistenceContext 
    private EntityManager em;
      
    private String username;
    private String password;
    private String passwordv;
    
     private boolean loggedIn;
   
    /**
     * Creates a new instance of ExempleBean
     */
    public ExempleBean() {
        this.utilisateur = new Utilisateur();
            }

    
    public UtilisateurFacade getUtilisateurFacade() {
        return utilisateurFacade;
    }

    public void setUtilisateurFacade(UtilisateurFacade utilisateurFacade) {
        this.utilisateurFacade = utilisateurFacade;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

   public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordv() {
        return passwordv;
    }

    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
  
    
    public List<entities.Utilisateur> findAll(){
        return this.utilisateurFacade.findAll();
    }
    
    
     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
      public Utilisateur prepareCreate() {
        utilisateur = new Utilisateur();
       
        initializeEmbeddableKey();
        return utilisateur;
    }
      
      
       public String creerUser(){
            FacesContext context = FacesContext.getCurrentInstance();
         Utilisateur user = getUser();
         if(user==null){
             utilisateur.setMotDepass(crypter(utilisateur.getMotDepass(), "bob"));
           try{
         utx.begin();
                em.persist(utilisateur);
                utx.commit();
           FacesMessage message = new FacesMessage( "Utilisateur créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
           
           }
           catch (Exception e){
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                        "Error creating user!",
                                                        "Unexpected error when creating your account.  Please contact the system Administrator");
                context.addMessage(null, message);
                Logger.getAnonymousLogger().log(Level.SEVERE,
                                                "Unable to create new user",
                                                e);
                return null;
                }
         }
         
          else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username '"+ utilisateur.getLogin() + "' Existe déja!","SVP choisissez un username différent.");
            context.addMessage(null, message);
            return null;
        }
        return "/admin/ListUser.xhtml";
      }
       
        public String creerUserAdmin(){
            FacesContext context = FacesContext.getCurrentInstance();
         Utilisateur user = getUser();
         if(user==null){
             utilisateur.setMotDepass(crypter(utilisateur.getMotDepass(),"bob"));
           try{
         utx.begin();
                em.persist(utilisateur);
                utx.commit();
           FacesMessage message = new FacesMessage( "Utilisateur créé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );}
           catch (Exception e){
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                        "Error creating user!",
                                                        "Unexpected error when creating your account.  Please contact the system Administrator");
                context.addMessage(null, message);
                Logger.getAnonymousLogger().log(Level.SEVERE,
                                                "Unable to create new user",
                                                e);
                return null;
                }
         }
         
          else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username '"+ utilisateur.getLogin() + "' Existe déja!","SVP choisissez un username différent.");
            context.addMessage(null, message);
            return null;
        }
          
          
        return "/admin/ListUser.xhtml";
      }
         
      
       public String supprimerUser(){
        this.utilisateurFacade.remove(utilisateur);
        FacesMessage message = new FacesMessage( "Utilisateur supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "ListUser";
    }
       
       
       public String supprimerUserAdmin(){
        this.utilisateurFacade.remove(utilisateur);
        FacesMessage message = new FacesMessage( "Utilisateur supprimé avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "/admin/ListUser.xhtml";
    }
       
          
     public String modifierUser(){
        this.utilisateurFacade.edit(utilisateur);
       
        FacesMessage message = new FacesMessage( "Utilisateur modifié avec succès!" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "ListUser";        
    }
    
    public List<entities.Utilisateur> afficherUser(){
       return this.utilisateurFacade.findAll();
    }
    
  
     
      public Utilisateur getUtilisateur(java.lang.Long id) {
        return getUtilisateurFacade().find(id);
    }

      
    public List<Utilisateur> getItemsAvailableSelectMany() {
        return getUtilisateurFacade().findAll();
    }
    
    
    public List<Utilisateur> getItemsAvailableSelectOne() {
        return getUtilisateurFacade().findAll();
    }
    
    
     @FacesConverter(forClass = Utilisateur.class)
    public static class UtilisateurBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UtilisateurBean controller = (UtilisateurBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "utilisateurBean");
            return controller.getUtilisateur(getKey(value));
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
            if (object instanceof Utilisateur) {
                Utilisateur o = (Utilisateur) object;
                return getStringKey(o.getIdutilisateur());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Utilisateur.class.getName()});
                return null;
            }
        }

    }
    
    
     public Utilisateur getUser() {
        try {
            Utilisateur user = (Utilisateur) em.createNamedQuery("Utilisateur.findByLogin").setParameter("login", utilisateur.getLogin()).getSingleResult();
            return user; 
        } catch (NoResultException nre) {
              return null;
        }
    }
     
     
     public Utilisateur getUser2() {
        try {
            Utilisateur user = (Utilisateur) em.createNamedQuery("Utilisateur.findByLogin").setParameter("login", username).getSingleResult();
            return user; 
        } catch (NoResultException nre) {
              return null;
        }
    }
     
     
         
       public String modifier(){
           FacesContext context = FacesContext.getCurrentInstance();
         Utilisateur user = getUser();
        if(user!=null){
            
            //faire les methodes modifier et supprimer des user et role en suivant la methode inscrire()
            utilisateur.setMotDepass(crypter(utilisateur.getMotDepass(), "bob"));
           
            try{
                 utx.begin();
                em.merge(utilisateur);
                utx.commit();
                
                FacesMessage message = new FacesMessage("Utilisateur modifié avec succès");
                FacesContext.getCurrentInstance().addMessage( null, message );
                    return "ListUser";
                }catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e){
                
                  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur lors de la modification de l'utilisateur!","Unexpected error when creating your account. Please contact the system Administrator");
                context.addMessage(null, message);
                Logger.getAnonymousLogger().log(Level.SEVERE,"Unable to edit user",e);
                return null;
            }
            }         
        else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username '"+ utilisateur.getLogin() + "' Existe déja!","SVP choisissez un username différent.");
            context.addMessage(null, message);
            return null;
        }
     
       }
       
        public String modifierAdmin(){
           FacesContext context = FacesContext.getCurrentInstance();
         Utilisateur user = getUser();
        if(user!=null){
            
            //faire les methodes modifier et supprimer des user et role en suivant la methode inscrire()
            utilisateur.setMotDepass(crypter(utilisateur.getMotDepass(), "bob"));
           
            try{
                 utx.begin();
                em.merge(utilisateur);
                utx.commit();
                
                FacesMessage message = new FacesMessage("Utilisateur modifié avec succès");
                FacesContext.getCurrentInstance().addMessage( null, message );
                    return "/admin/ListUser.xhtml";
                }catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e){
                
                  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur lors de la modification de l'utilisateur!","Unexpected error when creating your account. Please contact the system Administrator");
                context.addMessage(null, message);
                Logger.getAnonymousLogger().log(Level.SEVERE,"Unable to edit user",e);
                return null;
            }
            }         
        else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username '"+ utilisateur.getLogin() + "' Existe déja!","SVP choisissez un username différent.");
            context.addMessage(null, message);
            return null;
        }
     
       }
       
       
       public String doLogin() {
             FacesContext context = FacesContext.getCurrentInstance();
              Utilisateur user = getUser2();
           password = crypter(password, "bob");
           if(user != null){
                 if (!user.getMotDepass().equals(password)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Authentification échouée!",
                                           "Le mot de passe n'est pas correct.");
                context.addMessage(null, message);
                return null;
            } 
                   if(username.contains(".admin") || username.contains(".Admin")){  
                   loggedIn = true;
                   context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
                  return "app-main-admin";
                
            }
            
             if(username.contains(".commercial") || username.contains(".Commercial")){                
                 loggedIn = true;
                 context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
                return "app-main-commercial";
            }
            
             if(username.contains(".comptable") || username.contains(".Comptable")){                
                loggedIn = true;
                context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
                return "app-main-comptable";
            }
            
             if(username.contains(".gestionnaire") || username.contains(".Gestionnaire")){
                loggedIn = true;
                context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
                return "app-main-gestionnaire";
            }
            
            if(username.contains(".secretariat") || username.contains(".Secretariat")){                
                loggedIn = true;
                context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
                return "app-main-secretariat";
            }
                                 
               
           }else{
                 FacesMessage msg = new FacesMessage("Erreur lors de la tentative de connexion!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
       return null;
           }
        return null;
        
    }
       
             
        public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
         HttpSession session = (HttpSession)
        
         FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(USER_SESSION_KEY);
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        // Set logout message
        
        if (session != null) {
            session.invalidate();
        }
         
        FacesMessage msg = new FacesMessage("Déconnexion réussie!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "login";
    }
        
      
        
        public String crypter(String password,String key){
           try
            {
                Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
                Cipher cipher=Cipher.getInstance("Blowfish");
                cipher.init(Cipher.ENCRYPT_MODE,clef);
                return new String(cipher.doFinal(password.getBytes()));
            }
           catch (Exception e)
        {
           return null;
        }
    }
        
        public String decrypter(String password,String key){
                try
                    {
                        Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
                        Cipher cipher=Cipher.getInstance("Blowfish");
                        cipher.init(Cipher.DECRYPT_MODE,clef);
                        return new String(cipher.doFinal(password.getBytes()));
                    }
                catch (Exception e)
                    {
                        System.out.println(e);
                        return null;
                    }
       }
       
}
