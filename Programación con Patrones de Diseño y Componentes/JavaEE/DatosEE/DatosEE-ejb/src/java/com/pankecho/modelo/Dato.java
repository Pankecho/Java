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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "DATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dato.findAll", query = "SELECT d FROM Dato d")
    , @NamedQuery(name = "Dato.findByIddato", query = "SELECT d FROM Dato d WHERE d.iddato = :iddato")})
public class Dato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDATO")
    private Integer iddato;
    @Lob
    @Size(max = 32700)
    @Column(name = "TEXTO")
    private String texto;

    public Dato() {
    }

    public Dato(Integer iddato) {
        this.iddato = iddato;
    }

    public Integer getIddato() {
        return iddato;
    }

    public void setIddato(Integer iddato) {
        this.iddato = iddato;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddato != null ? iddato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dato)) {
            return false;
        }
        Dato other = (Dato) object;
        if ((this.iddato == null && other.iddato != null) || (this.iddato != null && !this.iddato.equals(other.iddato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pankecho.modelo.Dato[ iddato=" + iddato + " ]";
    }
    
}
