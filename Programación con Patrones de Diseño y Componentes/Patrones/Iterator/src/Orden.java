import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Orden extends Iterador{

	public Orden(ArrayList<Archivo> c) {
		// TODO Auto-generated constructor stub
		datos = c;
		Collections.sort(datos,new Comparator<Archivo>() {
			@Override
			public int compare(Archivo o1, Archivo o2) {
				// TODO Auto-generated method stub
				return o1.getArtista().compareTo(o2.getArtista());
			}
		});
	}

	@Override
	public Archivo next() {
		// TODO Auto-generated method stub
		indice++;
		return datos.get(indice);
	}

}
