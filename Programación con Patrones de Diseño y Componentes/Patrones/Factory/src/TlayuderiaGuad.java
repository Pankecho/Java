public class TlayuderiaGuad extends Tlayuderia {

	@Override
	protected Tlayuda creaTlayuda(String nombre) {
		// TODO Auto-generated method stub
		if(nombre.equalsIgnoreCase("QUESILLO"))
			return new TlayudaQuesilloGuad();
		else if(nombre.equalsIgnoreCase("CARNE"))
			return new TlayudaCarneGuad();
		return null;
	}

}
