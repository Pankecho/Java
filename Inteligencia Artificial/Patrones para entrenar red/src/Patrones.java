
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pankecho
 */

public class Patrones {
    
    private final List<Character> LETRAS = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
    private final String FILE = "patrones.csv";
    
    public Vector<Integer> readFile(String nombre){
        Vector<Integer> vector = new Vector<Integer>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(nombre)));
            String cadena;
            while ((cadena = br.readLine()) != null) {    
                for(int i = 0; i < cadena.length(); i++){
                    vector.add((Integer.parseInt(cadena.charAt(i) + "")) != 0 ? 1 : 0);
                }
            }
        } catch (Exception e) {
        }
        return vector;
    }
    
    public String toBinary(char letra){
        int index = LETRAS.indexOf(letra);
        if (index >= 0)
            return Integer.toBinaryString(index + 1);
        
        return null;
    }
    
    public String toBinary(String cadena){
        int total = 5 - cadena.length();
        for(int i = 0; i < total; i++){
            cadena = "0" + cadena;
        }
        return cadena;
    }
    
    
    public void appendFile(String cadena){
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(FILE), true)));
            pw.write(cadena + "\n");
            pw.close();
        } catch (Exception e) {
        }
    }
    
    public String vectorToString(Vector<Integer> dato){
        String cadena = "";
        for (Integer integer : dato) {
            cadena += integer + ","; 
        }
        return cadena.substring(0, cadena.length() - 1);
    }
    
    public static void main(String[] args) {

        Patrones n = new Patrones();
        for (char letra : n.LETRAS) {
            for(int i = 0; i < 5; i++){
                Vector<Integer> v = n.readFile("" + letra + "" + (i+1) + ".txt");
                String binario = n.toBinary(n.toBinary(letra));
                String cadena = n.vectorToString(v) + "," + binario;
                n.appendFile(cadena);
            }
        }
        
    }

    public Patrones() {
    }
}
