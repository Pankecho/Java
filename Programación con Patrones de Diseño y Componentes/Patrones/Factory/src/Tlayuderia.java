public abstract class Tlayuderia {

	protected abstract Tlayuda creaTlayuda(String nombre);
	
	public Tlayuda ordenTlayuda(String nombre) {
		Tlayuda t = creaTlayuda(nombre);
		System.out.println("Creando una tlayuda " + t.nombre);
		t.preparar();
		t.calentar();
		return t;
	}
}
