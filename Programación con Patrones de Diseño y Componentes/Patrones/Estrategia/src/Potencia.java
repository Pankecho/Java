public class Potencia extends ExpMatCom2 {
	
	public Potencia(Integer uno, Integer dos){
		super(uno,dos);
		evaluar = new EvaluacionPotencia();
		sumRes = new SinSumaRes();
	}
	
	public Potencia() {
		this(0,0);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(valor1 + "^" + valor2);
	}

	@Override
	public void producto(ExpMatCom2 valor) throws Exception {
		// TODO Auto-generated method stub
		ExpMatCom2 v = new Potencia();
		if(valor.getClass().getName().equals("Potencia")) {
			if(valor1 == valor.valor1){
				v.valor1 = valor1;
				v.valor2 = valor2 + valor.valor2;
				v.mostrar();
				v.evaluar();
			}else {
				throw new Exception("No se puede realizar el producto, no tienen la misma base");
			}
		}else {
			throw new Exception("No se puede realizar el producto entre una Potencia y " + valor.getClass().getName());
		}
	}

}
