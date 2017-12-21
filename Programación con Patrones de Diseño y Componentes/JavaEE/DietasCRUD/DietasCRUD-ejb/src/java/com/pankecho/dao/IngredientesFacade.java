/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.dao;

import com.pankecho.modelo.Ingredientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pankecho
 */
@Stateless
public class IngredientesFacade extends AbstractFacade<Ingredientes> {

    @PersistenceContext(unitName = "DietasCRUD-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngredientesFacade() {
        super(Ingredientes.class);
    }
    
}
