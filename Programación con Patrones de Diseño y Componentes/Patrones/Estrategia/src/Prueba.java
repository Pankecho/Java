public class Prueba {
	public static void main(String[] args) throws Exception {
		// Martínez Ruiz Juan Pablo
		// TODO Auto-generated method stub
		
		ExpMatCom2 com1,com2,coor1,coor2,frac1,frac2,pot1,pot2;
		
		com1 = new Complejo(3,4);
		com2 = new Complejo(5, -2);
		
		coor1 = new Coordenada(4, 1);
		coor2 = new Coordenada(6, 5);
		
		frac1 = new Fraccion(1,2);
		frac2 = new Fraccion(1, 5);
		
		pot1 = new Potencia(2, 3);
		pot2 = new Potencia(2, 8);
		
		System.out.println("Complejo 1");
		com1.mostrar();
		com1.evaluar();
		
		System.out.println("Complejo 2");
		com2.mostrar();
		com2.evaluar();
		
		System.out.println("Suma Complejo 1 y 2");
		com1.suma(com2);
		
		System.out.println("Producto Complejo 1 y 2");
		com1.producto(com2);
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Coordenada 1");
		coor1.mostrar();
		coor1.evaluar();
		
		System.out.println("Coordenada 2");
		coor2.mostrar();
		coor2.evaluar();
		
		System.out.println("Suma Coordenada 1 y 2");
		coor1.suma(coor2);
		
		System.out.println("Producto Coordenada 1 y 2");
		coor1.producto(coor2);
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Fraccion 1");
		frac1.mostrar();
		frac1.evaluar();
		
		System.out.println("Fraccion 2");
		frac2.mostrar();
		frac2.evaluar();
		
		System.out.println("Suma Fraccion 1 y 2");
		frac1.suma(frac2);
		
		System.out.println("Producto Fraccion 1 y 2");
		frac1.producto(frac2);
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Potencia 1");
		pot1.mostrar();
		pot1.evaluar();
		
		System.out.println("Potencia 2");
		pot2.mostrar();
		pot2.evaluar();
		
		System.out.println("Suma Potencia 1 y 2");
		pot1.suma(pot2);
		
		System.out.println("Producto Potencia 1 y 2");
		pot1.producto(pot2);
		
		System.out.println("\n---------------------------------------------------\n");
		
		// Agregue algo para que no te dejará hacer operaciones binarias de diferentes tipos, con Excepciones
		
		// coor1.suma(frac1);
		// pot1.producto(frac2);
	
		// Lanzan una Excepcion
	}

}
