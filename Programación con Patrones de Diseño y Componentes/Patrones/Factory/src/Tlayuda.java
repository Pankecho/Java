import java.util.ArrayList;

public abstract class Tlayuda {
	String nombre, maiz, base, salsa, frijol;
	ArrayList cubierta = new ArrayList();
	
	public void preparar() {
		System.out.println("Preparando " + nombre);
		System.out.println("Agregando " + base);
		System.out.println("Agregando " + frijol);
		System.out.println("Agregando " + salsa);
		
		for(int i = 0; i < cubierta.size(); i++)
			System.out.println("\t" + cubierta.get(i));
	}
	
	public void calentar() {
		System.out.println("Calentandola en las brazas...");
	}
	
	public void aderezar() {
		System.out.println("Agregandole el aderezo...");
	}
}
