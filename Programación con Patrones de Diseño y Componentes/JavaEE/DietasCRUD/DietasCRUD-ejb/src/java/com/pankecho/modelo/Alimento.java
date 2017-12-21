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
@Table(name = "alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a")
    , @NamedQuery(name = "Alimento.findByIdAlimento", query = "SELECT a FROM Alimento a WHERE a.idAlimento = :idAlimento")
    , @NamedQuery(name = "Alimento.findByNombre", query = "SELECT a FROM Alimento a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alimento.findByKilocalorias", query = "SELECT a FROM Alimento a WHERE a.kilocalorias = :kilocalorias")
    , @NamedQuery(name = "Alimento.findByUnidadmedida", query = "SELECT a FROM Alimento a WHERE a.unidadmedida = :unidadmedida")
    , @NamedQuery(name = "Alimento.findByCantidad", query = "SELECT a FROM Alimento a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "Alimento.findByTipo", query = "SELECT a FROM Alimento a WHERE a.tipo = :tipo")})
public class Alimento implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlimento")
    private List<Ingredientes> ingredientesList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alimento")
    private Integer idAlimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kilocalorias")
    private int kilocalorias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "unidadmedida")
    private String unidadmedida;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;

    public Alimento() {
    }

    public Alimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Alimento(Integer idAlimento, String nombre, int kilocalorias, String unidadmedida, String tipo) {
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.kilocalorias = kilocalorias;
        this.unidadmedida = unidadmedida;
        this.tipo = tipo;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getKilocalorias() {
        return kilocalorias;
    }

    public void setKilocalorias(int kilocalorias) {
        this.kilocalorias = kilocalorias;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimento != null ? idAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idAlimento == null && other.idAlimento != null) || (this.idAlimento != null && !this.idAlimento.equals(other.idAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @XmlTransient
    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }
    
}
