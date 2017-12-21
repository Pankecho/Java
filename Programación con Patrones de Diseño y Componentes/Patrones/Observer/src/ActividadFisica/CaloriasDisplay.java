package ActividadFisica;

public class CaloriasDisplay implements Observer, DisplayElement{
	
	int caloriasQuemadas;
	Actividad a;
	Individuo i;
	String [] actividades;
	
	public CaloriasDisplay(Individuo in,String[] a) {
		// TODO Auto-generated constructor stub
		this.i = in;
		i.addObserver(this);
		this.actividades = a;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Se quemaron " + caloriasQuemadas + " calorías por " + a.nombre + " " + a.distancia + " m.");
	}

	@Override
	public void update(Individuo o, Actividad arg) {
		// TODO Auto-generated method stub
		this.a = arg;
		Individuo i = (Individuo) o;
		Double total = Double.valueOf("0");
		switch(a.nombre) {
			case "Correr":
				total = 0.029 * (i.getPesoKg() * 2.2) * a.tiempo;
				break;
			case "Caminar":
				total = 0.06 * (i.getPesoKg() * 2.2) * a.tiempo;
				break;
			case "Bicicleta":
				total = 0.071 * (i.getPesoKg() * 2.2) * a.tiempo;
				break;
			default:
				break;
		}
		caloriasQuemadas = total.intValue();
		display();
	}

	@Override
	public String[] getActividades() {
		// TODO Auto-generated method stub
		return this.actividades;
	}


}
