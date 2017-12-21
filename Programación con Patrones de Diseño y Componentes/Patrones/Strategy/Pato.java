public abstract class Pato{
    ConductaVolar conductaVolar;
    ConductaQuack conductaQuack;
    
    public Pato(){
    }
    
    public abstract void mostrar();
    
    public void volar(){
        conductaVolar.volar();
    }
    
    public void quack(){
        conductaQuack.quack();
    }
    
    public void nadar(){
        System.out.println("Todos los patos flotan, incluso los decoy");
    }
    
}
