import java.util.ArrayList;

public class Secuencial extends Archivos {

	public Secuencial(ArrayList<Archivo> a) {
		// TODO Auto-generated constructor stub
		conjunto = a;
		iterador = new Clasico(conjunto);
	}

}
