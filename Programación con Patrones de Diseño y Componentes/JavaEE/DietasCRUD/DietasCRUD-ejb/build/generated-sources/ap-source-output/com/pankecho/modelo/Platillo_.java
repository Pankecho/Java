package com.pankecho.modelo;

import com.pankecho.modelo.Ingredientes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T08:38:08")
@StaticMetamodel(Platillo.class)
public class Platillo_ { 

    public static volatile SingularAttribute<Platillo, String> tipo;
    public static volatile SingularAttribute<Platillo, Integer> idPlatillo;
    public static volatile SingularAttribute<Platillo, Integer> cantidad;
    public static volatile SingularAttribute<Platillo, String> nombre;
    public static volatile SingularAttribute<Platillo, String> unidadmedida;
    public static volatile ListAttribute<Platillo, Ingredientes> ingredientesList;

}