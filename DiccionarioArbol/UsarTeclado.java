import java.*;
import javax.swing.JOptionPane;

public class UsarTeclado
{
    public static String leerString(String str) {
        return JOptionPane.showInputDialog(str);
    }
    
    public static int leerEntero(String msg)
    {
        int valor = 0;
        try {
            valor = Integer.parseInt(leerString(msg));
            if(valor <= 0 || valor > 20){
                JOptionPane.showMessageDialog(null, "Favor de ingresar un número válido");
                leerEntero(msg);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un número válido");
            leerEntero(msg);
        }
        return valor;
    }
    
    public static float leerFlotante(String msg)
    {
        float valor = 0.0f;
        try {
            valor = Float.parseFloat(leerString(msg));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un número válido");
        }
        return valor;
    }
    
    public static long leerLong(String msg){
        long valor = 0;
        try {
            valor = Long.parseLong(leerString(msg));
            if(valor < 15161001 || valor > 15161500){
                JOptionPane.showMessageDialog(null, "Favor de ingresar un número válido");
                leerLong(msg);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un número válido");
            leerLong(msg);
        }
        return valor;
    }
    
    public static char leerChar(String msg)
    {
        char valor = ' ';
        try {
            valor = leerString(msg).charAt(0);
        } catch (Exception nfe) {}
        return valor;
    }
    
    public static boolean leerBooleano(String msg)
    {
        boolean valor = false;
        try {
            valor = Boolean.parseBoolean(leerString(msg));
        } catch (NumberFormatException nfe) {
            valor = false;
        }
        return valor;
    }
    
    public static String leerCadena(String msg){
        String valor = null;
        valor = leerString(msg);
        if(isNumeric(valor)){
            JOptionPane.showMessageDialog(null, "Por favor, introduzca un valor válido");
            leerCadena(msg);
        }
        return valor;
       
        
    }
    
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
}