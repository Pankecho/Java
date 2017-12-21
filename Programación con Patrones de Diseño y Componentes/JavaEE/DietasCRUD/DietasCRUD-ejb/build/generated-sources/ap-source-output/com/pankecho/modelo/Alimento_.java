package com.pankecho.modelo;

import com.pankecho.modelo.Ingredientes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T08:38:08")
@StaticMetamodel(Alimento.class)
public class Alimento_ { 

    public static volatile SingularAttribute<Alimento, String> tipo;
    public static volatile SingularAttribute<Alimento, Integer> kilocalorias;
    public static volatile SingularAttribute<Alimento, Integer> idAlimento;
    public static volatile SingularAttribute<Alimento, Integer> cantidad;
    public static volatile SingularAttribute<Alimento, String> nombre;
    public static volatile SingularAttribute<Alimento, String> unidadmedida;
    public static volatile ListAttribute<Alimento, Ingredientes> ingredientesList;

}