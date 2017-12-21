import java.util.ArrayList;

public class Favoritos extends Archivos {

	public Favoritos(ArrayList<Archivo> a) {
		// TODO Auto-generated constructor stub
		conjunto = a;
		iterador = new Favorito(conjunto);
	}

}
