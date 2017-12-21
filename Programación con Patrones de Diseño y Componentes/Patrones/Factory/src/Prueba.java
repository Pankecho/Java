public class Prueba {
	public static void main(String[] args) {
		Tlayuderia t, tUno;
		t = new TlayuderiaGuad();
		tUno = new TlayuderiaMerida();
		t.ordenTlayuda("CARNE");
		System.out.println();
		tUno.ordenTlayuda("QUESILLO");
	}
}
