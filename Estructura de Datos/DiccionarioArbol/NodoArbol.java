public class NodoArbol
{
    private Palabra dato;
    private NodoArbol izq, der;
    public NodoArbol(Palabra dato)
    {
        this.dato = dato;
        izq = der = null;
    }

    public void setDato(Palabra dato){
        this.dato = dato;
    }
    
    public Palabra getDato(){
       return dato;
    }
    
    public NodoArbol getIzq(){
        return izq;
    }
    
    public void setIzq(NodoArbol izq){
        this.izq = izq;
    }
    
    public NodoArbol getDer(){
        return der;
    }
    
    public void setDer(NodoArbol der){
        this.der = der;
    }
    
}
