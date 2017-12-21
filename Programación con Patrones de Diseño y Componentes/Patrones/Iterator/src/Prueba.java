import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Archivo> a = new ArrayList<Archivo>();
		
		a.add(new Archivo("Back in Black", "AC/DC", "Back in Black", 4000, 5));
		a.add(new Archivo("Humble", "Kendrick Lamar", "DAMN", 2570, 4));
		a.add(new Archivo("Intense", "Armin van Buuren", "Intense", 8400, 3));
		a.add(new Archivo("Inmigrant Song", "Led Zeppelin", "Mothership", 2260, 5));
		
		Archivos ar = new Secuencial((ArrayList<Archivo>)a.clone());
		//ar.reproducir();
		//ar.reproducir();
		
		System.out.println();
		
		ar = new Favoritos((ArrayList<Archivo>)a.clone());
		ar.reproducir();
		ar.reproducir();
		ar.reproducir();
		
		System.out.println();
		
		ar = new Ordenado((ArrayList<Archivo>)a.clone());
		ar.reproducir();
		ar.reproducir();
		
	}

}
