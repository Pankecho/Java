/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankecho.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pankecho
 */
@Entity
@Table(name = "platillo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platillo.findAll", query = "SELECT p FROM Platillo p")
    , @NamedQuery(name = "Platillo.findByIdPlatillo", query = "SELECT p FROM Platillo p WHERE p.idPlatillo = :idPlatillo")
    , @NamedQuery(name = "Platillo.findByNombre", query = "SELECT p FROM Platillo p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Platillo.findByTipo", query = "SELECT p FROM Platillo p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Platillo.findByCantidad", query = "SELECT p FROM Platillo p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Platillo.findByUnidadmedida", query = "SELECT p FROM Platillo p WHERE p.unidadmedida = :unidadmedida")})
public class Platillo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_platillo")
    private Integer idPlatillo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 10)
    @Column(name = "unidadmedida")
    private String unidadmedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlatillo")
    private List<Ingredientes> ingredientesList;

    public Platillo() {
    }

    public Platillo(Integer idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public Platillo(Integer idPlatillo, String nombre, String tipo) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Integer idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    @XmlTransient
    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlatillo != null ? idPlatillo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platillo)) {
            return false;
        }
        Platillo other = (Platillo) object;
        if ((this.idPlatillo == null && other.idPlatillo != null) || (this.idPlatillo != null && !this.idPlatillo.equals(other.idPlatillo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pankecho.modelo.Platillo[ idPlatillo=" + idPlatillo + " ]";
    }
    
}
