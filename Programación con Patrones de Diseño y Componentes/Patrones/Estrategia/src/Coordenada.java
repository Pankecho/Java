public class Coordenada extends ExpMatCom2{

	public Coordenada(Integer uno, Integer dos){
		super(uno,dos);
		evaluar = new SinEvaluacion();
		sumRes = new SumRestxTer();
	}
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Coordenada(x,y) = (" + this.valor1 + "," + this.valor2 + ")");
	}

	@Override
	public void producto(ExpMatCom2 valor) {
		// TODO Auto-generated method stub
		System.out.println("Operacion no soportada");
	}

}
