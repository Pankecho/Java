package ActividadFisica;

import java.util.ArrayList;
import java.util.Observable;

public class Individuo extends Observable{
	private int pesoKg, alturaCm, edad;
	private char sexo;
	ArrayList observers;
	
	public Individuo(int p, int a, int e, char x) {
		// TODO Auto-generated constructor stub
		this.pesoKg = p;
		this.alturaCm = a;
		this.edad = e;
		this.sexo = x;
		this.observers = new ArrayList();
	}
	
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	
	public synchronized void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if(i >= 0)
			observers.remove(i);
	}
	
	public void actividadRealizada(Actividad a) {
		notifyObservers(a);
	}
	
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		Actividad a = (Actividad)arg;
		
		for (int i = 0; i < observers.size(); i++) {
			Observer x = (Observer)observers.get(i);
			if(contains(x.getActividades(), a.nombre)) {
				x.update(this, a);
			}
		}
	}
	
	public void caminar(int distancia, int tiempo) {
		Actividad a = new Actividad(distancia, tiempo, "Caminar");
		actividadRealizada(a);
	}
	
	public void correr(int distancia, int tiempo) {
		Actividad a = new Actividad(distancia, tiempo, "Correr");
		actividadRealizada(a);
	}
	
	public void pedalearBicicleta(int distancia, int tiempo) {
		Actividad a = new Actividad(distancia,tiempo,"Bicicleta");
		actividadRealizada(a);
	}

	public int getPesoKg() {
		return pesoKg;
	}

	public int getAlturaCm() {
		return alturaCm;
	}

	public int getEdad() {
		return edad;
	}

	public char getSexo() {
		return sexo;
	}
	
	private boolean contains(String [] array, String c) {
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals(c))
				return true;
		}
		return false;
	}
	
}
