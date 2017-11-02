/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Immeuble;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author devarence
 */
@Stateless
public class ImmeubleFacade extends AbstractFacade<Immeuble> {
    @PersistenceContext(unitName = "CoGeReVeImmoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImmeubleFacade() {
        super(Immeuble.class);
    }
    
}
