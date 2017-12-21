/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.bl;

import com.pankecho.dao.DatoFacade;
import com.pankecho.modelo.Dato;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author pankecho
 */
@Stateless
@LocalBean
public class BussinessLogic {

    @EJB
    private DatoFacade datoFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void save(Dato d){
        datoFacade.create(d);
    }
    
}
