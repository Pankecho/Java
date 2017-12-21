public class Fraccion extends ExpMatCom2 {
	
	public Fraccion(Integer uno, Integer dos){
		super(uno,dos);
		this.sumRes = new SumResFracc();
		this.evaluar = new EvaluacionFraccion();
	}
	
	public Fraccion() {
		this(0,0);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(valor1 + "/" + valor2);
	}

	@Override
	public void producto(ExpMatCom2 valor) throws Exception {
		ExpMatCom2 va = new Fraccion();
		// TODO Auto-generated method stub
		if(valor.getClass().getName().equals("Fraccion")) {
			va.valor1 = valor1 * valor.valor1;
			va.valor2 = valor2 * valor.valor2;
			va.mostrar();
			va.evaluar();
		}else {
			throw new Exception("No puedes realizar el producto entre una Fraccion y " + valor.getClass().getName());
		}
	}
}
