import java.util.ArrayList;

public abstract class Archivos {
	Iterador iterador;
	ArrayList<Archivo> conjunto;
	
	public void reproducir() {
		if(iterador.hasNext()) {
			System.out.println("Reproduciendo " + iterador.next().getNombre());
		}else {
			System.out.println("Ya no hay mas archivos");
		}
		
	}
	
	public void agregar(Archivo a) {
		conjunto.add(a);
	}
	
	public Iterador getIterador() {
		return iterador;
	}
}
