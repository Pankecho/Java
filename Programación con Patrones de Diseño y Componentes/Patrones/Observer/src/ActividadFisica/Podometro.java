package ActividadFisica;


public class Podometro implements Observer, DisplayElement {
	int pasosTotal, pasosActividad;
	Actividad a;
	String [] actividades;
	
	public Podometro(Individuo i, String[] a) {
		i.addObserver(this);
		pasosTotal = 0;
		this.actividades = a;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Pasos dados por " + a.nombre + " " + a.distancia + " m = " + pasosActividad + " / Pasos en total = " + pasosTotal);
	}

	@Override
	public void update(Individuo o, Actividad arg) {
		// TODO Auto-generated method stub
		this.a = (Actividad) arg;
		Double total = a.distancia * 0.71777203560149;
		this.pasosActividad = total.intValue();
		this.pasosTotal += this.pasosActividad;
		display();
	}

	@Override
	public String[] getActividades() {
		// TODO Auto-generated method stub
		return this.actividades;
	}
}
