import java.util.ArrayList;

public abstract class Iterador {
	ArrayList<Archivo> datos;
	int indice = -1;
	
	public abstract Archivo next();
	
	public boolean hasNext() {
		if(!datos.isEmpty() && (indice + 1) < this.datos.size()) {
			return true;
		}else {
			return false;
		}
	}
}
