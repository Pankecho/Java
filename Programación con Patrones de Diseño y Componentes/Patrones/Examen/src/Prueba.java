import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tiempo lol = new Tiempo(2017,10,31,9,43,5);
		int[] hora = {9,43,10};
		int[] dia = {31};
		Observer o = new Despertador(dia, hora);
		lol.registerObserver(o);
		
		Timer timer = new Timer(1000,new ActionListener (){ 
		    public void actionPerformed(ActionEvent e) { 
		        // Aquí el código que queramos ejecutar.
		    		lol.avanza();
		    } 
		});
		timer.start();
	}

}
