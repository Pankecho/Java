/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.bl;

import com.pankecho.dao.AlimentoFacade;
import com.pankecho.dao.IngredientesFacade;
import com.pankecho.dao.PlatilloFacade;
import com.pankecho.modelo.Alimento;
import com.pankecho.modelo.Ingredientes;
import com.pankecho.modelo.Platillo;
import java.util.List;
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
    private IngredientesFacade ingredientesFacade;

    @EJB
    private PlatilloFacade platilloFacade;

    @EJB
    private AlimentoFacade alimentoFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void saveAlimento(Alimento a){
        alimentoFacade.create(a);
    }
    
    public List<Alimento> getAllAlimentos(){
        return alimentoFacade.findAll();
    }
    
    public  Alimento findAlimentoById(int id){
        return alimentoFacade.find(id);
    }
    
    public void editAlimento(Alimento a){
        alimentoFacade.edit(a);
    }
    
    public void deleteAlimento(Alimento a){
        alimentoFacade.remove(a);
    }
    
    public List<Platillo> getAllPlatillos(){
        return platilloFacade.findAll();
    }
    
    public void savePlatillo(Platillo p){
        platilloFacade.create(p);
    }
    
    public void saveIngrediente(Ingredientes i){
        ingredientesFacade.create(i);
    }
}
