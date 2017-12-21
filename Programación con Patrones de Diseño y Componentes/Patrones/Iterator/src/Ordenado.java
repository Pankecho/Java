import java.util.ArrayList;

public class Ordenado extends Archivos {

	public Ordenado(ArrayList<Archivo> a) {
		// TODO Auto-generated constructor stub
		conjunto = a;
		iterador = new Orden(conjunto);
	}

}
