public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String e1 = "Usuario Rick registrado";
		String e2 = "Usuario Morty inició sesión";
		String e3 = "Usuario Morty cambió su correo electrónico";
		String e4 = "Usuario Rick cerró sesión";
		
		String e5 = "Usuario Morty cerró sesión";
		
		Log logger = Log.getInstance();
		
		logger.escribirEvento(e1);
		logger.escribirEvento(e2);
		logger.escribirEvento(e3);
		logger.escribirEvento(e4);
		
		// Se imprimen los eventos
		System.out.println("Log de Logger");
		logger.printLog();
		
		// Se vuelve a obtener la instancia
		Log logger2 = Log.getInstance();
		
		// Es la misma instancia
		System.out.println("Log de Logger2 (Misma instancia)");
		logger2.printLog();
		
		// Se agrega un evento
		logger2.escribirEvento(e5);
		
		// Se imprime los eventos de la instancia
		System.out.println("Log de Logger2 con el nuevo evento");
		logger2.printLog();	
	}

}
