public class PatoAzul extends Pato
{
    public PatoAzul()
    {
        conductaQuack = new Quack();
        conductaVolar = new VolarConAlas();
    }

    public void mostrar(){
        System.out.println("Soy un pato azul");
    }
}
