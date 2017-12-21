
public class Despertador implements Observer {
	int [] dias;
	int [] hora;
	
	public Despertador(int [] dias, int[] hora) {
		// TODO Auto-generated constructor stub
		this.dias = dias;
		this.hora = hora;
	}

	@Override
	public int[] getDias() {
		// TODO Auto-generated method stub
		return dias;
	}

	@Override
	public int getHora() {
		// TODO Auto-generated method stub
		String lol = "" + hora[0] + "" + hora[1] + "" + hora[2];
		return Integer.parseInt(lol);
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Despertador";
	}

	@Override
	public void update(Observable a) {
		// TODO Auto-generated method stub
		Tiempo t = (Tiempo)a;
		System.out.println("ALARMA DE DIA " + t.getDia() + " A LAS " + hora[0] + " HORAS");
		dias = remove(t.getDia(), dias);
		if(dias.length == 0) {
			System.out.println("ALARMA ELIMINADA");
		}
	}
	
	public int[] remove(int elemento, int[] array) {
		int[] nuevo = new int[array.length-1];
		int contador = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != elemento) {
				nuevo[contador] = array[i];
				contador++;
			}
		}
		return nuevo;
	}

}
