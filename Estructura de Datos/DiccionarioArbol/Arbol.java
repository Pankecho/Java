import java.util.*;
import javax.swing.*;
import java.io.*;

public class Arbol{
    private NodoArbol raiz;
    private ArrayList <String> español ;
    private ArrayList <String> zapoteco;
    private ArrayList <String> mixteco;
    public Arbol(){
        raiz=null; 
    }
    
    public boolean isEmpty(){
        return(raiz==null); 
    }
    
    public boolean agregar(Palabra x){
        if(buscar(x.getEspañol()) == null){
            NodoArbol na = new NodoArbol(x);
            if(na != null ){
                if(isEmpty()){
                    raiz = na;
                }else{
                    NodoArbol aux = raiz;
                    NodoArbol ant = null;
                    while(aux != null ){
                        ant = aux;
                        int compare = (aux.getDato().getEspañol().compareToIgnoreCase(x.getEspañol()));
                        if(compare > 0){
                            aux = aux.getIzq();
                        }else{
                            aux = aux.getDer(); 
                        }
                    }
                    int compare1 = (ant.getDato().getEspañol().compareToIgnoreCase(x.getEspañol()));
                    if(compare1 > 0){
                        ant.setIzq(na);
                    }else{
                        ant.setDer(na);
                    }
                }
                return true; 
            } 
        }
        return false;
    }
    
    public NodoArbol buscar(String x){
        String cadena = x;
        NodoArbol aux = raiz;
         while(aux != null && !x.toUpperCase().equals(aux.getDato().getEspañol().toUpperCase())){
            int compare = (cadena.toUpperCase().compareToIgnoreCase(aux.getDato().getEspañol().toUpperCase()));
            if(compare < 0){
                 aux = aux.getIzq();     
            }else{
             aux = aux.getDer(); 
            }
        }
        return aux; 
    }
    
    public void inOrden(){
        ayudanteinOrden(raiz);
    }
    
    private void ayudanteinOrden(NodoArbol actual){
         if(actual != null){
             ayudanteinOrden(actual.getIzq());
             System.out.format("%20s%20s%20s\n",actual.getDato().getEspañol(),actual.getDato().getMixteco(),actual.getDato().getZapoteco());
             ayudanteinOrden(actual.getDer()); 
         }        
    }
    
    public void preOrden(){
         ayudantepreOrden(raiz);
    }
    
    private void ayudantepreOrden(NodoArbol actual){
         if(actual != null){
             System.out.format("%20s%20s%20s\n",actual.getDato().getEspañol(),actual.getDato().getMixteco(),actual.getDato().getZapoteco());
             ayudantepreOrden(actual.getIzq());
             ayudantepreOrden(actual.getDer()); 
         }
    }
    
    public void posOrden(){
         ayudanteposOrden(raiz);
    }
    
    private void ayudanteposOrden(NodoArbol actual){
         if(actual != null){
             ayudanteposOrden(actual.getIzq());
             ayudanteposOrden(actual.getDer()); 
             System.out.format("%20s%20s%20s\n",actual.getDato().getEspañol(),actual.getDato().getMixteco(),actual.getDato().getZapoteco());
         }
    }
        
    public void imprimirInOrden(){
        System.out.println("                  Diccionario Español - Zapoteco - Mixteco          ");
        System.out.println("             -------------------------------------------------");
        System.out.println("               Español           Zapoteco             Mixteco             ");
        System.out.println("             -------------------------------------------------");
        inOrden();
    }
    
    public void imprimirPreOrden(){
        System.out.println("                  Diccionario Español - Zapoteco - Mixteco          ");
        System.out.println("             -------------------------------------------------");
        System.out.println("               Español           Zapoteco             Mixteco             ");
        System.out.println("             -------------------------------------------------");
        preOrden();
    }
    
    public void imprimirPosOrden(){
        System.out.println("                  Diccionario Español - Zapoteco - Mixteco          ");
        System.out.println("             -------------------------------------------------");
        System.out.println("               Español           Zapoteco             Mixteco             ");
        System.out.println("             -------------------------------------------------");
        posOrden();
    }
    
    public void llenarLista(Base b){
        
        for(int i = 0; i < b.getEspañol().size(); i++){
            agregar(new Palabra(b.getEspañol().get(i).toString(),b.getZapoteco().get(i).toString(),b.getMixteco().get(i).toString()));
        }
    }
    
    public boolean eliminar(String dato){
        NodoArbol n = raiz, ant = null;
        while(n !=null && !n.getDato().getEspañol().toUpperCase().equals(dato.toUpperCase())){
            ant = n;
            int compare = (n.getDato().getEspañol().compareToIgnoreCase(dato));
            if(compare > 0){
                 n = n.getIzq(); 
            }else{
                 n = n.getDer(); 
            }
        }
        if(n != null){
            if(n.getDato().getEspañol().toUpperCase().equals(raiz.getDato().getEspañol().toUpperCase())){
                raiz = borrarNodo(n);
            } else{
                 if(ant.getIzq().getDato().getEspañol().toUpperCase().equals(n.getDato().getEspañol().toUpperCase())){
                     ant.setIzq(borrarNodo(n));
                 } else{
                     ant.setDer(borrarNodo(n));
                 }
            }
            return true;
        }
        return false; 
    }
    
    private NodoArbol borrarNodo(NodoArbol n){
        if(n.getIzq() == null){
            return n.getDer();
        } else{
            if(n.getDer() == null){
                 return n.getIzq();
            } else{
                 NodoArbol aux = n.getDer(), ante = null;
                 while(aux.getIzq() != null){
                     ante = aux;
                     aux = aux.getIzq(); 
                 }
                 n.setDato(aux.getDato());
                 if(ante != null){
                     ante.setIzq(aux.getDer());
                 }else{
                     n.setDer(aux.getDer());
                 }
                 return n; 
            }
        }
    } 
    
    public void inOrdenArchivoEspañol(){      
        español = new ArrayList <String>(); 
        ayudanteinOrdenEspañol(raiz);
    }
   
    
    private void ayudanteinOrdenEspañol(NodoArbol actual){
         if(actual != null){
             español.add(actual.getDato().getEspañol());
             ayudanteinOrdenEspañol(actual.getIzq());
             ayudanteinOrdenEspañol(actual.getDer()); 
         }     
    }
    
    public void escribirArchivoEspañol(){
        try{
            FileWriter archivo = new FileWriter("Palabras Español.txt");
            for(int i = 0; i < español.size(); i ++){
                archivo.write(español.get(i).toString() + "\n");
            }
            archivo.close();
        } catch (IOException ex){ 
        
        }
    }
    
    public void escribirArchivoZapoteco(){
        try{
            FileWriter archivo = new FileWriter("Palabras Zapoteco.txt");
            for(int i = 0; i < zapoteco.size(); i ++){
                archivo.write(zapoteco.get(i).toString()+ "\n");
            }
            archivo.close();
        } catch (IOException ex){ 
        
        }
    }
    
    public void escribirArchivoMixteco(){
        try{
            FileWriter archivo = new FileWriter("Palabras Mixteco.txt");
            for(int i = 0; i < mixteco.size(); i ++){
                archivo.write(mixteco.get(i).toString()+ "\n");
            }
            archivo.close();
        } catch (IOException ex){ 
        
        }
    }
    
    public void inOrdenArchivoMixteco(){
        mixteco = new ArrayList <String>();
        ayudanteinOrdenMixteco(raiz); 
    }
    
    private void ayudanteinOrdenMixteco(NodoArbol actual){
         if(actual != null){
             mixteco.add(actual.getDato().getMixteco());
             ayudanteinOrdenMixteco(actual.getIzq());
             ayudanteinOrdenMixteco(actual.getDer()); 
         }     
    }
    
    public void inOrdenArchivoZapoteco(){
        zapoteco = new ArrayList <String>(); 
        ayudanteinOrdenZapoteco(raiz);
    }
    
    private void ayudanteinOrdenZapoteco(NodoArbol actual){
         if(actual != null){
             zapoteco.add(actual.getDato().getZapoteco());
             ayudanteinOrdenZapoteco(actual.getIzq());
             ayudanteinOrdenZapoteco(actual.getDer()); 
         }     
    }
    
    public void escribirArchivo(){
        try{
            FileWriter archivo = new FileWriter("Palabras.txt");
            archivo.write("                  Diccionario Español - Zapoteco - Mixteco\n          ");
            archivo.write("---------------------------------------------------------------------\n");
            for(int i = 0; i < mixteco.size(); i ++){
                archivo.write("Español: " + español.get(i).toString() + "\tZapoteco: " + zapoteco.get(i).toString() + "\tMixteco : " + mixteco.get(i).toString() + "\n");
            }
            archivo.close();
        } catch (IOException ex){ 
        
        }
    }
    
    
}
