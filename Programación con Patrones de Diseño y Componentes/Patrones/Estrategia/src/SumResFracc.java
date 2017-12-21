public class SumResFracc implements FormaSumRes{

	@Override
	public ExpMatCom2 suma(ExpMatCom2 uno, ExpMatCom2 dos) throws Exception {
		// TODO Auto-generated method stub
		ExpMatCom2 valor = new Fraccion();
		
		if(uno.getClass().getName().equals("Fraccion") && uno.getClass().getName().equals(dos.getClass().getName())) {
			Integer denominador = Integer.valueOf(uno.valor2 * dos.valor2);
			Integer nominador = Integer.valueOf((denominador / uno.valor2) * uno.valor1) + Integer.valueOf((denominador / dos.valor2) * dos.valor1);
			valor.valor1 = nominador;
			valor.valor2 = denominador;
		}else {
			throw new Exception("No se puede realizar la suma entre tipo " + uno.getClass().getName() + " y " + dos.getClass().getName() + ". Tipos incompatibles");
		}
		return valor;
	}

	@Override
	public ExpMatCom2 resta(ExpMatCom2 uno, ExpMatCom2 dos) throws Exception {
		// TODO Auto-generated method stub
		ExpMatCom2 valor = new Fraccion();
		
		if(uno.getClass().getName().equals("Fraccion") && uno.getClass().getName().equals(dos.getClass().getName())) {
			Integer denominador = Integer.valueOf(uno.valor2 * dos.valor2);
			Integer nominador = Integer.valueOf((denominador / uno.valor2) * uno.valor1) - Integer.valueOf((denominador / dos.valor2) * dos.valor1);
			valor.valor1 = nominador;
			valor.valor2 = denominador;
		}else {
			throw new Exception("No se puede realizar la resta entre tipo " + uno.getClass().getName() + " y " + dos.getClass().getName() + ". Tipos incompatibles");
		}
		return valor;
	}

}
