public class EvaluacionFraccion implements FormaEvaluar {

	@Override
	public Double evaluacion(ExpMatCom2 objeto) {
		// TODO Auto-generated method stub
		return Double.valueOf(objeto.valor1 / objeto.valor2);
	}

}
