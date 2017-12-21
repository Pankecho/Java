public abstract class ExpMatCom2 {

	FormaEvaluar evaluar;
	FormaSumRes sumRes;
	Integer valor1, valor2;
	
	public ExpMatCom2(Integer valor1, Integer valor2){
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	public ExpMatCom2(){
		this(0, 0);
	}
	
	public void evaluar(){
		Double v = evaluar.evaluacion(this);
		System.out.println((v != null) ? v : "No se puede evaluar");
	}
	
	public void suma(ExpMatCom2 valor) throws Exception{
		ExpMatCom2 v = sumRes.suma(this, valor);
		if(v == null){
			System.out.println("Operacion no soportada");
		}else {
			v.mostrar();
			v.evaluar();
		}
	}
	
	public void resta(ExpMatCom2 valor) throws Exception{
		ExpMatCom2 v = sumRes.resta(this, valor);
		if(v == null){
			System.out.println("Operacion no soportada");
		}else {
			v.mostrar();
			v.evaluar();
		}
	}
	
	public abstract void mostrar();
	
	public abstract void producto(ExpMatCom2 valor) throws Exception;
}
