/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.admin;

import com.pankecho.bl.BussinessLogic;
import com.pankecho.modelo.Alimento;
import com.pankecho.modelo.Ingredientes;
import com.pankecho.modelo.Platillo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

/**
 *
 * @author pankecho
 */
@Named(value = "platilloAdmin")
@SessionScoped
public class PlatilloAdmin implements Serializable {

    @EJB
    private BussinessLogic bussinessLogic;
    
    private Platillo platillo;
    private List<Ingredientes> ingredientes;
    private List<Alimento> alimentos;
    private List<Platillo> platillos;
    private Ingredientes ingrediente;
    private List<Integer> kilocalorias;
    private Alimento alimento;
    private int idAlimento;
    
    /**
     * Creates a new instance of PlatilloAdmin
     */
    public PlatilloAdmin() {
        kilocalorias = new ArrayList<Integer>();
    }
    
    public void crear(ActionEvent e){
        platillo = new Platillo();
        alimentos = bussinessLogic.getAllAlimentos();
        ingrediente = new Ingredientes();
        ingredientes = new ArrayList<Ingredientes>();
    }
    
    public void guardarIngrediente(ActionEvent e){
        alimento = bussinessLogic.findAlimentoById(idAlimento);
        ingrediente.setIdAlimento(alimento);
        ingrediente.setUnidadmedida(alimento.getUnidadmedida());
        ingredientes.add(ingrediente);
        Integer kilocaloria = (alimento.getKilocalorias() * ingrediente.getCantidad())/alimento.getCantidad();
        kilocalorias.add(kilocaloria);
        alimento = null;
        ingrediente = new Ingredientes();
    }
    
    public void guardar(ActionEvent e){
        if(!platillo.getNombre().isEmpty() && platillo.getCantidad() != 0 && !platillo.getUnidadmedida().isEmpty()){
            bussinessLogic.savePlatillo(platillo);
            for (Ingredientes i : ingredientes) {
                i.setIdPlatillo(platillo);
                bussinessLogic.saveIngrediente(i);
            }
        }
    }
    
    public void getPlatillos(ActionEvent e){
        platillos = bussinessLogic.getAllPlatillos();
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }
    
    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public Ingredientes getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingredientes ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }

    public List<Integer> getKilocalorias() {
        return kilocalorias;
    }

    public void setKilocalorias(List<Integer> kilocalorias) {
        this.kilocalorias = kilocalorias;
    }
    
}
