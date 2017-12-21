
public class TlayuderiaMerida extends Tlayuderia {

	@Override
	protected Tlayuda creaTlayuda(String nombre) {
		// TODO Auto-generated method stub
		if(nombre.equalsIgnoreCase("QUESILLO"))
			return new TlayudaQuesilloMer();
		else if(nombre.equalsIgnoreCase("CARNE"))
			return new TlayudaCarneMer();
		return null;
	}

}
