/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pankecho
 */
@Entity
@Table(name = "ingredientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i")
    , @NamedQuery(name = "Ingredientes.findByIdIngrediente", query = "SELECT i FROM Ingredientes i WHERE i.idIngrediente = :idIngrediente")
    , @NamedQuery(name = "Ingredientes.findByCantidad", query = "SELECT i FROM Ingredientes i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "Ingredientes.findByUnidadmedida", query = "SELECT i FROM Ingredientes i WHERE i.unidadmedida = :unidadmedida")})
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingrediente")
    private Integer idIngrediente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "unidadmedida")
    private String unidadmedida;
    @JoinColumn(name = "id_alimento", referencedColumnName = "id_alimento")
    @ManyToOne(optional = false)
    private Alimento idAlimento;
    @JoinColumn(name = "id_platillo", referencedColumnName = "id_platillo")
    @ManyToOne(optional = false)
    private Platillo idPlatillo;

    public Ingredientes() {
    }

    public Ingredientes(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Ingredientes(Integer idIngrediente, int cantidad, String unidadmedida) {
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
        this.unidadmedida = unidadmedida;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public Alimento getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Alimento idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Platillo getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Platillo idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngrediente != null ? idIngrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.idIngrediente == null && other.idIngrediente != null) || (this.idIngrediente != null && !this.idIngrediente.equals(other.idIngrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pankecho.modelo.Ingredientes[ idIngrediente=" + idIngrediente + " ]";
    }
    
}
