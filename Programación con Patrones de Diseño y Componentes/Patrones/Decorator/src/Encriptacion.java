public class Encriptacion extends Decorator {
	
	private boolean isCrypted = false;

	public Encriptacion(String t) {
		// TODO Auto-generated constructor stub
		this.texto = new Mensaje(t);
	}
	
	public void encripta() {
		if(!isCrypted) {
			this.texto.setTexto(encripta(getTexto()));
		}else {
			this.texto.setTexto(desencripta(getTexto()));
		}
		isCrypted = !isCrypted;
	}
	
	
	private String encripta(String a) {
		String aux = "";
		for(int i = 0; i < a.length(); i++)
			aux += (char)((int)a.charAt(i) + 1) + "";
		return aux;
	}
	
	private String desencripta(String a) {
		String aux = "";
		for(int i = 0; i < a.length(); i++)
			aux += (char)((int)a.charAt(i) - 1) + "";
		return aux;
	}

}
