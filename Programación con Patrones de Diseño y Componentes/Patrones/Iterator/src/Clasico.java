import java.util.ArrayList;

public class Clasico extends Iterador {

	public Clasico(ArrayList<Archivo> conjunto) {
		// TODO Auto-generated constructor stub
		datos = conjunto;
	}

	@Override
	public Archivo next() {
		// TODO Auto-generated method stub
		indice++;
		return this.datos.get(indice);
	}

}
