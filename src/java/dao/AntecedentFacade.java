/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Antecedent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author devarence
 */
@Stateless
public class AntecedentFacade extends AbstractFacade<Antecedent> {
    @PersistenceContext(unitName = "CoGeReVeImmoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentFacade() {
        super(Antecedent.class);
    }
    
}
