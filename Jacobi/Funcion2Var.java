import org.nfunk.jep.JEP;
import org.nfunk.*;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.lsmp.djep.*;
public class Funcion2Var
{
    private JEP evaluar;
    private boolean errorEnExpresion;
    private String funcion;
    private String errorMensaje;
    public Funcion2Var(String funcion)
    {
        this.funcion = funcion;
        evaluar = new JEP();             // Creamos un objeto JEP
        evaluar.addStandardFunctions(); // Agrega las funciones comunes como las trigonométricas
        evaluar.addStandardConstants(); // Agregamos constantes como PI, Euler, etc.
        evaluar.addComplex();           // Agregamos números complejos
        evaluar.setImplicitMul(true);   // En vez de 2*x sea 2X
        evaluar.addVariable("x",0);
        evaluar.addVariable("y",0);
    }
    
    /**
     * Metodo para evaluar la función
     */
    public float evaluar(float x, float y){
        evaluar.parseExpression(funcion); // Agregamos la funcion
        evaluar.addVariable("x",x);       // Colocamos el valor recibido en la variable x
        evaluar.addVariable("y",y);
        errorEnExpresion = evaluar.hasError(); // Hay error?
        if(errorEnExpresion){
              errorMensaje = evaluar.getErrorInfo();  // En caso de error, lo guardamos
        }
        return (float) evaluar.getValue(); // Regresamos el resultado
    }
    
    public boolean isErrorEnExpresion() {
        return errorEnExpresion;
    }

    public String getErrorMensaje() {
        return errorMensaje;
    }
    
    public String toString(){
        return funcion;
    }
}
