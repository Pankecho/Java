public abstract class Decorator implements Texto {
	
	Texto texto;
	@Override
	public void setTexto(String texto) {
		// TODO Auto-generated method stub
		this.texto.setTexto(texto);
	}

	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		return this.texto.getTexto();
	}

}
