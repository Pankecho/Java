package ActividadFisica;

public class DistanciaDisplay implements DisplayElement, Observer {
	int totalDistancia, totalActividad;
	String [] actividades;
	
	public DistanciaDisplay(Individuo i, String[] actividades) {
		// TODO Auto-generated constructor stub
		i.addObserver(this);
		totalActividad = totalDistancia = 0;
		this.actividades = actividades;
	}

	@Override
	public void update(Individuo o, Actividad arg) {
		// TODO Auto-generated method stub
		Actividad a = (Actividad) arg;
		totalActividad ++;
		totalDistancia += a.distancia;
		display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		String total;
		if(totalDistancia >= 1000) {
			total = totalDistancia/1000 + "." + (totalDistancia%1000) + " Km.";
		}else{
			total = totalDistancia + " m.";
		}
		String totalP;
		if(totalDistancia/totalActividad >= 1000) {
			totalP = (totalDistancia/totalActividad)/1000 + "." + ((totalDistancia/totalActividad)%1000) + " Km.";
		}else{
			totalP = totalDistancia/totalActividad + " m.";
		}
		System.out.println("Distancia(Caminar, Correr) total / promedio = " + total + " / " + totalP);
	}

	@Override
	public String[] getActividades() {
		// TODO Auto-generated method stub
		return this.actividades;
	}

}
