public class Complejo extends ExpMatCom2{
	
	public Complejo(Integer uno, Integer dos) {
		super(uno,dos);
		evaluar = new SinEvaluacion();
		sumRes = new SumRestxTer();
	}

	public Complejo(){
		this(0,0);
	}
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("(" + valor1 + " + " + valor2 + " i)");
	}

	@Override
	public void producto(ExpMatCom2 valor) throws Exception {
		// TODO Auto-generated method stub
		ExpMatCom2 v = new Complejo();
		if(valor.getClass().getName().equals("Complejo")){
			v.valor1 = valor1 * valor.valor1;
			v.valor2 = valor2 * valor.valor2;
			v.mostrar();
			v.evaluar();
		}else {
			throw new Exception("No puedes realizar el producto entre un Complejo y " + valor.getClass().getName());
		}
	}

}
