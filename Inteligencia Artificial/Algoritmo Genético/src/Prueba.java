import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Prueba {
	private DefaultCategoryDataset dataset;
	private final String ruta = "Ruta";
	private final String distancia = "Distancia";
	private JFreeChart distancias;
	private ChartPanel panel;
	private JFrame frame;
	
	public Prueba(TSPBasico b) {
		// TODO Auto-generated constructor stub
		this.dataset = new DefaultCategoryDataset();
		this.frame = new JFrame("Distancias");
		
		ArrayList<int[]> array = b.individuos;
		
		for(int i = 0; i < array.size(); i++) {
			dataset.addValue(b.fitness(array.get(i)), distancia, "Ruta " + i);
		}
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.distancias = ChartFactory.createLineChart("Distancias", distancia, ruta, dataset,PlotOrientation.VERTICAL,false,false,false);
		panel = new ChartPanel(distancias);
		panel.setPreferredSize(new Dimension(750,300));
		p.add(panel);
		frame.getContentPane().add(p);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		int[][] matriz = {{0,190,200,345,200,180,200,200,200,180,330},
				{190,0,170,299,200,200,200,200,200,200,317},
				{200,170,0,310,200,200,200,200,200,200,415},
				{345,299,310,0,250,450,200,200,200,200,200},
				{200,200,200,250,0,230,312,200,200,200,200},
				{180,200,200,450,230,0,255,267,200,314,200},
				{200,200,200,200,312,255,0,280,450,200,200},
				{200,200,200,200,200,267,280,0,225,198,200},
				{200,200,200,200,200,200,450,225,0,275,300},
				{180,200,200,200,200,314,200,198,275,0,230},
				{330,317,415,200,200,200,200,200,300,230,0}};
		TSPBasico b = new TSPBasico(matriz, 1000,1000);
		new Prueba(b);
	}
}
