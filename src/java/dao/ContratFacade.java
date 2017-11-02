/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Contrat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author devarence
 */
@Stateless
public class ContratFacade extends AbstractFacade<Contrat> {
    @PersistenceContext(unitName = "CoGeReVeImmoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratFacade() {
        super(Contrat.class);
    }
    
}
