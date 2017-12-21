import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Adaptador extends JList{
	DefaultListModel<JCheckBox> modelo;
	
	public Adaptador(int tamaño) {
		modelo = new DefaultListModel<JCheckBox>();
		for(int i = 0; i < tamaño; i++) {
			JCheckBox box = new JCheckBox("Elemento " + i);
			modelo.addElement(box);
		}
		setModel(modelo);
		init();
	}
	
	private void init() {
		setCellRenderer(new Renderer());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int index = locationToIndex(e.getPoint());
				if(index >= 0) {
					setSelectedIndex(index);
					JCheckBox box = modelo.getElementAt(index);
					box.setSelected(!box.isSelected());	
					repaint();
					System.out.println((box.isSelected()) ? "Se ha seleccionado el item " + index + " del JList": "Se ha deseleccionado el item " + index + " del JList");
				}
			}
		});
	}
	
	protected class Renderer implements ListCellRenderer{
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			JCheckBox box = (JCheckBox)value;
			return box;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Adaptador(10));
		frame.pack();
		frame.setVisible(true);
	}
	
}