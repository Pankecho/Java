/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.admin;

import com.pankecho.bl.BussinessLogic;
import com.pankecho.modelo.Alimento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

/**
 *
 * @author pankecho
 */
@Named(value = "alimentoAdmin")
@SessionScoped
public class AlimentoAdmin implements Serializable {

    @EJB
    private BussinessLogic bussinessLogic;

    private Alimento alimento;
    
    private List<Alimento> alimentos;
    
    /**
     * Creates a new instance of Admin
     */
    public AlimentoAdmin() {
    }
    
    public void crear(ActionEvent e){
        alimento = new Alimento();
    }
    
    public void guardar(ActionEvent e){
        if(!alimento.getNombre().isEmpty() && alimento.getKilocalorias() != 0 && !alimento.getUnidadmedida().isEmpty() && alimento.getCantidad() != 0 && !alimento.getTipo().isEmpty())
            bussinessLogic.saveAlimento(alimento);
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }
    
    public void getAlimentos(ActionEvent e){
        alimentos = bussinessLogic.getAllAlimentos();
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
    
    public void buscar(ActionEvent e){
        setAlimento(bussinessLogic.findAlimentoById(getAlimento().getIdAlimento()));
    }
    
    public void editar(ActionEvent e){
        if(!alimento.getNombre().isEmpty() && alimento.getKilocalorias() != 0 && !alimento.getUnidadmedida().isEmpty() && alimento.getCantidad() != 0 && !alimento.getTipo().isEmpty())
            bussinessLogic.editAlimento(alimento);
    }
    
    public void eliminar(ActionEvent e){
        bussinessLogic.deleteAlimento(alimento);
    }
    
}
