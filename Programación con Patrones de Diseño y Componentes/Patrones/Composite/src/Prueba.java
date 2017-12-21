public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto pantalla, teclado, trackpad, tarjeta,procesador,pixel,pc;
		pc = new ProductoCompuesto("Computadora", 15000.00);
		pantalla = new ProductoSimple("Pantalla",3000.00);
		teclado = new ProductoSimple("Teclado",500.00);
		trackpad = new ProductoSimple("Trackpad",1000.00);
		tarjeta = new ProductoCompuesto("Tarjeta Madre",2000.00);
		procesador = new ProductoSimple("Procesador Intel i5",2000.00);
		pixel = new ProductoSimple("Pixeles",0.00);
		try {
			pc.agregar(pantalla);
			pc.agregar(teclado);
			pc.agregar(trackpad);
			pc.agregar(tarjeta);
			pc.getHijo(3).agregar(procesador);
			pc.getHijo(0).agregar(pixel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		finally {
			pc.show("");
			System.out.println("Precio total: " + pc.getTotal());
		}
		
	}

}
