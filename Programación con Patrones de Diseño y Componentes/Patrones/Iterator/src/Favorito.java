import java.util.ArrayList;

public class Favorito extends Iterador {

	public Favorito(ArrayList<Archivo> a) {
		// TODO Auto-generated constructor stub
		datos = a;
		datos.removeIf(i -> (i.getPuntuacion() != 5));
	}

	@Override
	public Archivo next() {
		// TODO Auto-generated method stub
		indice++;
		return datos.get(indice);
	}
}
