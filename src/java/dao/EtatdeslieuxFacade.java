/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Etatdeslieux;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author devarence
 */
@Stateless
public class EtatdeslieuxFacade extends AbstractFacade<Etatdeslieux> {
    @PersistenceContext(unitName = "CoGeReVeImmoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtatdeslieuxFacade() {
        super(Etatdeslieux.class);
    }
    
}
