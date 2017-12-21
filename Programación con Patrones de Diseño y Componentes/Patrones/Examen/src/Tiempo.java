import java.util.ArrayList;

public class Tiempo implements Observable {

	int[] calendario = new int[3];
	// calendario[0] = dia - calendario[1] = mes - calendario[2] = año
	int[] reloj = new int[3];
	// reloj[0] = horas - reloj[1] = minutos - reloj[2] = segundos
	ArrayList observers;
	
	public Tiempo(int año, int mes, int dia, int hora, int minuto, int segundo) {
		this.observers = new ArrayList();
		setCalendario(dia, mes, año);
		setHora(hora, minuto, segundo);
	}
	
	public void avanza() {
		setHora(reloj[0], reloj[1], reloj[2]+1);
		if(reloj[2] == 60) {
			setHora(reloj[0], reloj[1]+1, 0);
			if(reloj[1] == 60) {
				setHora(reloj[0]+1, 0, reloj[2]);
				if(reloj[0] == 24) {
					setHora(0, 0, 0);
					setCalendario(calendario[0]+1, calendario[1], calendario[2]);
					if(calendario[0] == 30) {
						setCalendario(1, calendario[1]+1, calendario[2]);
						if(calendario[1] == 13) {
							setCalendario(1, 1, calendario[2]+1);
						}
					}
				}
			}
		}
		show();
	}
	
	
	private void setCalendario(int dia, int mes, int año) {
		calendario[0] = dia;
		calendario[1] = mes;
		calendario[2] = año;
		notifyObservers();
	}
	
	private void setHora(int hora, int minutos, int segundos) {
		reloj[0] = hora;
		reloj[1] = minutos;
		reloj[2] = segundos;
		notifyObservers();
	}
	
	public void show() {
		System.out.println("Fecha: " + calendario[0] + "/" + calendario[1] + "/" + calendario[2]);
		System.out.println("Hora: " + reloj[0] + ":" + reloj[1] + ":" + reloj[2]);
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if(i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observers.size(); i++) {
			Observer o = (Observer)observers.get(i);
			if(contains(calendario[0], o.getDias())) {
				if(o.getTipo().equals("Despertador")) {
					if(getHora() == o.getHora()) {
						o.update(this);
						if(o.getDias().length == 0) {
							removeObserver(o);
						}
					}
				}
			}
		}
	}
	
	public boolean contains(int dia, int[] dias) {
		for(int i = 0; i < dias.length; i++) {
			if(dia == dias[i]){
				return true;
			}
		}
		return false;
	}
	
	public int getHora() {
		String lol = "" + reloj[0] + "" + reloj[1] + "" + reloj[2];
		return Integer.parseInt(lol);
	}
	
	public int getDia() {
		return calendario[0];
	}
	
	public int getMes() {
		return calendario[1];
	}
	
	public int getAño() {
		return calendario[2];
	}
}
