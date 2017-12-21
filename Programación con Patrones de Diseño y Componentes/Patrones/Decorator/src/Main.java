import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Texto mensaje = new Mensaje("Hola mundo");
			Texto encripta, grafico;
			encripta = new Encriptacion(mensaje.getTexto());
			grafico = new Grafico(mensaje.getTexto());
			
			JFrame frame = new JFrame("Prueba Decorator");
			JPanel botones = new JPanel(new FlowLayout());
			frame.getContentPane().setLayout(new FlowLayout());
			
			JButton bold,encrypt,color,font;
			bold = new JButton("Bold - unBold");
			encrypt = new JButton("Encripta - Desencripta");
			color = new JButton("Cambia color");
			font = new JButton("Cambia fuente");
			
			bold.addActionListener((e)->{
				((Grafico)grafico).negrita();
			});
			
			encrypt.addActionListener((e)->{
				((Encriptacion)encripta).encripta();
				grafico.setTexto(encripta.getTexto());
			});
			
			color.addActionListener((e)->{
				int r = (int) (Math.random() * 255);
				int g = (int) (Math.random() * 255);
				int b = (int) (Math.random() * 255);
				((Grafico)grafico).changeColor(new Color(r, g, b));
			});
			
			font.addActionListener((e)->{
				((Grafico)grafico).changeFont();
			});
			
			botones.add(((Grafico)grafico).getLabel());
			botones.add(bold);
			botones.add(encrypt);
			botones.add(color);
			botones.add(font);
			
			frame.getContentPane().add(botones);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			
		}

}
