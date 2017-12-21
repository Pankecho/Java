public class PatoMadera extends Pato
{
    public PatoMadera(){
        conductaQuack = new QuackSilencioso();
        conductaVolar = new NoVolar();
    }
    
    public void mostrar(){
        System.out.println("Soy un patito de madera");
    }
}
