import org.nfunk.jep.JEP;
import org.nfunk.*;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.lsmp.djep.*;
public class Funcion5Var
{
    private JEP evaluar;
    private boolean errorEnExpresion;
    private String funcion;
    private String errorMensaje;
    public Funcion5Var(String funcion)
    {
        this.funcion = funcion;
        evaluar = new JEP();             // Creamos un objeto JEP
        evaluar.addStandardFunctions(); // Agrega las funciones comunes como las trigonométricas
        evaluar.addStandardConstants(); // Agregamos constantes como PI, Euler, etc.
        evaluar.addComplex();           // Agregamos números complejos
        evaluar.setImplicitMul(true);   // En vez de 2*x sea 2X
        evaluar.addVariable("v",0);
        evaluar.addVariable("w",0);
        evaluar.addVariable("x",0);
        evaluar.addVariable("y",0);
        evaluar.addVariable("z",0);
    }
    
    /**
     * Metodo para evaluar la función
     */
    public float evaluar(float v, float w, float x, float y,float z){
        evaluar.parseExpression(funcion); // Agregamos la funcion
        evaluar.addVariable("v",v);
        evaluar.addVariable("w",w);
        evaluar.addVariable("x",x);       // Colocamos el valor recibido en la variable x
        evaluar.addVariable("y",y);
        evaluar.addVariable("z",z);
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
