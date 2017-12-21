import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Grafico extends Decorator {
	
	private boolean isBold = false;
	private boolean isJustified = false;
	private boolean isFontC = false;
	private JLabel label;

	public Grafico(String t) {
		// TODO Auto-generated constructor stub
		this.texto = new Mensaje(t);
		this.label = new JLabel(this.texto.getTexto());
		this.label.setSize(new Dimension(200,label.getSize().height));
		this.label.setFont(new Font("serif",Font.PLAIN,14));
	}
	
	@Override
	public void setTexto(String texto) {
		// TODO Auto-generated method stub
		super.setTexto(texto);
		label.setText(super.getTexto());
	}
	
	public JLabel getLabel() {
		return label;
	} 
	
	public void negrita() {
		if(!isBold) {
			bold();
		}else {
			unBold();
		}
		isBold = !isBold;
	}
	
	private void unBold() {
		label.setFont(new Font(label.getFont().getName(),Font.PLAIN,label.getFont().getSize()));
		label.repaint();
	}
	
	private void bold() {
		label.setFont(new Font(label.getFont().getName(),Font.BOLD,label.getFont().getSize()));
		label.repaint();
	}
	
	public void changeColor(Color c) {
		label.setForeground(c);
		label.setOpaque(true);
		label.repaint();
	}
	
	public void changeFont() {
		String[] array = {"Arial","Century","Comic Sans MS","Courier","Futura","Georgia","Monaco"};
		int random = (int)(Math.random() * array.length);
		if(isBold)
			changeFont(new Font(array[random],Font.BOLD,14));
		else
			changeFont(new Font(array[random],Font.PLAIN,14));
	}
	
	private void changeFont(Font f) {
		label.setFont(f);
		label.repaint();
	}
	
	public void changePosition() {
		if(!isJustified)
			position(SwingConstants.RIGHT);
		else
			position(SwingConstants.LEFT);
		isJustified = !isJustified;
	}
	
	private void position(int position) {
		label.setHorizontalAlignment(position);
		label.repaint();
	}

}
