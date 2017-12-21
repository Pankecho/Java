package ActividadFisica;

public interface Observer {
	public String[] getActividades();
	public void update(Individuo i, Actividad a);
}
