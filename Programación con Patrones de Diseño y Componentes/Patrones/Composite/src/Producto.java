public abstract class Producto {
	private String descripcion;
	private double precio;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Producto getHijo(int i) throws Exception {
		throw new Exception("No disponible");
	}
	
	public void agregar(Producto p) throws Exception{
		throw new Exception("No disponible");
	}
	
	public void remover(Producto p) throws Exception{
		throw new Exception("No disponible");
	}
	
	public double getTotal() {
		return getPrecio();
	}
	
	public void show(String a) {
		System.out.println(a + toString());
	}
	
	public String toString() {
		return "Descripcion: " + getDescripcion() + " - Precio: $" + getPrecio();
	}
	
}
