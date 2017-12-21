import java.util.ArrayList;

public class ProductoCompuesto extends Producto {
	
	private ArrayList<Producto> conjunto;

	public ProductoCompuesto(String d, double p) {
		// TODO Auto-generated constructor stub
		setDescripcion(d);
		setPrecio(p);
		this.conjunto = new ArrayList<Producto>();
	}
	
	@Override
	public Producto getHijo(int i) throws Exception {
		// TODO Auto-generated method stub
		return this.conjunto.get(i);
	}
	
	@Override
	public void agregar(Producto p) throws Exception {
		// TODO Auto-generated method stub
		this.conjunto.add(p);
	}
	
	@Override
	public void remover(Producto p) throws Exception {
		// TODO Auto-generated method stub
		int index = this.conjunto.indexOf(p);
		if(index >= 0)
			this.conjunto.remove(index);
	}
	
	@Override
	public void show(String a) {
		// TODO Auto-generated method stub
		super.show(a);
		for(int i = 0; i < conjunto.size(); i++) {
			String lol = "\t";
			conjunto.get(i).show(a + lol);
		}
	}
	
	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		double p = super.getTotal();
		for(int i = 0; i < conjunto.size(); i++)
			p += conjunto.get(i).getTotal();
		return p;
	}
}
