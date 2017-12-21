public class PatoHule extends Pato
{
    public PatoHule(){
        conductaVolar = new NoVolar();
        conductaQuack = new Chillido();
    }
    
    public void mostrar(){
        System.out.println("Soy un patito de hule");
    }
}
