package ActividadFisica;

public class Aplicacion {
	public static void main(String[] args) {
		String [] sport = {"Caminar","Bicicleta","Correr"};
		String [] c = {"Caminar","Correr"};
		Individuo i = new Individuo(60, 170, 21, 'H');
		CaloriasDisplay cd = new CaloriasDisplay(i,sport);
		Podometro p = new Podometro(i,c);
		DistanciaDisplay dd = new DistanciaDisplay(i,c);
		i.caminar(1000,30);
		i.correr(200, 5);
		i.pedalearBicicleta(1000, 20);
	}
}