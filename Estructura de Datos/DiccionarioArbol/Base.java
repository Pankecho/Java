import java.util.*;
import java.io.*;
/**
 * Write a description of class Base here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Base
{
    private ArrayList <String> palabrasEspañol;
    private ArrayList <String> palabrasZapoteco;
    private ArrayList <String> palabrasMixteco;
    
    public Base(){
        palabrasEspañol = new ArrayList <String>();
        palabrasZapoteco = new ArrayList <String>();
        palabrasMixteco = new ArrayList <String>();
    }
    
    public void llenarEspañol(){
        try{
            FileReader reader = new FileReader("Palabras Español.txt");
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while((linea = br.readLine()) != null){
                palabrasEspañol.add(linea);
            }
            reader.close();
        }catch(Exception e){
        }
    }
    
    public void llenarMixteco(){
        try{
            FileReader reader = new FileReader("Palabras Mixteco.txt");
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while((linea = br.readLine()) != null){
                palabrasMixteco.add(linea);
            }
            reader.close();
        }catch(Exception e){
        }
    }
    
    public void llenarZapoteco(){
        try{
            FileReader reader = new FileReader("Palabras Zapoteco.txt");
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while((linea = br.readLine()) != null){
                palabrasZapoteco.add(linea);
            }
            reader.close();
        }catch(Exception e){
        }
    }
    
    public ArrayList getEspañol(){
        return palabrasEspañol;
    }
    
    public ArrayList getMixteco(){
        return palabrasMixteco;
    }
    
    public ArrayList getZapoteco(){
        return palabrasZapoteco;
    }
   
}
