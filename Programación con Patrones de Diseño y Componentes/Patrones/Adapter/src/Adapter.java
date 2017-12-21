import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Adapter extends JCheckBox implements ListCellRenderer {
	
	DefaultListModel modelo;
	JList lista;
	int contador;
	
	public Adapter(int tamaño) {
		// TODO Auto-generated constructor stub
		this.contador = 0;
		this.modelo = new DefaultListModel();
		for(int i = 0; i < tamaño; i++)
			addElement();
		
		this.lista = new JList();
		this.lista.setCellRenderer(this);
		this.lista.setModel(modelo);
	}
	
	public void addElement() {
		this.modelo.addElement("Elemento " + contador);
		this.contador++;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		
		int status = 0;
		
		setComponentOrientation(list.getComponentOrientation());
		
		setText("Seleccionar " + index);
		setSelected(isSelected);
		
		if(isSelected()) {
			list.setSelectedIndex(index);
			setBackground(Color.GRAY);
			setForeground(Color.WHITE);
		}else {
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}
		setOpaque(true);
		return this;
	}
	
	public JList getLista() {
		return this.lista;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		Adapter lol = new Adapter(10);
		frame.getContentPane().add(lol.getLista());
		frame.pack();
		frame.setVisible(true);
	}
	
}
