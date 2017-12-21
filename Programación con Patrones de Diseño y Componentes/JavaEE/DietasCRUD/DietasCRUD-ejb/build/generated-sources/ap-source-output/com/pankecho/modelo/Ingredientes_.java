package com.pankecho.modelo;

import com.pankecho.modelo.Alimento;
import com.pankecho.modelo.Platillo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T08:38:08")
@StaticMetamodel(Ingredientes.class)
public class Ingredientes_ { 

    public static volatile SingularAttribute<Ingredientes, Platillo> idPlatillo;
    public static volatile SingularAttribute<Ingredientes, Alimento> idAlimento;
    public static volatile SingularAttribute<Ingredientes, Integer> cantidad;
    public static volatile SingularAttribute<Ingredientes, Integer> idIngrediente;
    public static volatile SingularAttribute<Ingredientes, String> unidadmedida;

}