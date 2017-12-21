import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Log {
	static Log instance = new Log();
	private String contenido;
	
	private Log(){
		contenido = "";
	}
	
	public static Log getInstance() {
		return instance;
	}
	
	public void escribirEvento(String evento){
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date ahora = new Date();
		String cadena = evento + " - " + formato.format(ahora);
		contenido += cadena + "\n";
	}
	
	public void printLog() {
		System.out.println(contenido);
	}
}
