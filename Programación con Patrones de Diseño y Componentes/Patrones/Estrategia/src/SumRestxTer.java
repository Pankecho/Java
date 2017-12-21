public class SumRestxTer implements FormaSumRes{

	@Override
	public ExpMatCom2 suma(ExpMatCom2 uno, ExpMatCom2 dos) throws Exception {
		// TODO Auto-generated method stub
		ExpMatCom2 valor = null;
		if(uno.getClass().getName().equals(dos.getClass().getName())) {
			Integer valor1 = Integer.valueOf(uno.valor1 + dos.valor1);
			Integer valor2 = Integer.valueOf(uno.valor2 + dos.valor2);
			if(uno.getClass().getName().equals("Complejo")) {
				valor = new Complejo(valor1, valor2);
			}else{
				valor = new Coordenada(valor1,valor2);
			}
		}else {
			throw new Exception("No puedes sumar " + uno.getClass().getName() + " y " + dos.getClass().getName() + " son datos incompatibles");
		}
		return valor;
	}

	@Override
	public ExpMatCom2 resta(ExpMatCom2 uno, ExpMatCom2 dos) throws Exception {
		// TODO Auto-generated method stub
		ExpMatCom2 valor = null;
		if(uno.getClass().getName().equals(dos.getClass().getName())) {
			Integer valor1 = Integer.valueOf(uno.valor1 - dos.valor1);
			Integer valor2 = Integer.valueOf(uno.valor2 - dos.valor2);
			if(uno.getClass().getName().equals("Complejo")) {
				valor = new Complejo(valor1, valor2);
			}else{
				valor = new Coordenada(valor1,valor2);
			}
		}else {
			throw new Exception("No puedes restar " + uno.getClass().getName() + " y " + dos.getClass().getName() + " son datos incompatibles");
		}
		return valor;
	}

}
