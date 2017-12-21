/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.dao;

import com.pankecho.modelo.Platillo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pankecho
 */
@Stateless
public class PlatilloFacade extends AbstractFacade<Platillo> {

    @PersistenceContext(unitName = "DietasCRUD-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatilloFacade() {
        super(Platillo.class);
    }
    
}
