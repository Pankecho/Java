/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.admin;

import com.pankecho.bl.BussinessLogic;
import com.pankecho.modelo.Dato;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

/**
 *
 * @author pankecho
 */
@Named(value = "admin")
@SessionScoped
public class Admin implements Serializable {

    @EJB
    private BussinessLogic bussinessLogic;

    private Dato d;
    
    /**
     * Creates a new instance of Admin
     */
    public Admin() {
    }
    
    public void crear(ActionEvent e){
        d = new Dato();
    }
    
    public void agregar(ActionEvent e){
        if(d.getIddato() != null && d.getTexto().isEmpty()){
            bussinessLogic.save(d);
        }
    }

    public Dato getD() {
        return d;
    }

    public void setD(Dato d) {
        this.d = d;
    }
    
    
    
}
