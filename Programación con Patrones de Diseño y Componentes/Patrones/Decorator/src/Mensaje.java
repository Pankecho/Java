public class Mensaje implements Texto {
	
	private String texto;
	
	public Mensaje(String t) {
		this.texto = t;
	}

	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		return this.texto;
	}

	@Override
	public void setTexto(String texto) {
		// TODO Auto-generated method stub
		this.texto = texto;
	}

}
