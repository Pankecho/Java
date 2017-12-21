
public class Prueba
{
    public static void main(String [] args){
        Pato azul = new PatoAzul();
        Pato hule = new PatoHule();
        Pato madera = new PatoMadera();
        
        azul.mostrar();
        azul.volar();
        azul.quack();
        
        System.out.println();
        hule.mostrar();
        hule.volar();
        hule.quack();
        
        System.out.println();
        madera.mostrar();
        madera.volar();
        madera.quack();
    }
}
