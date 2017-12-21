package ConObserver;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.SystemColor;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import com.orsoncharts.renderer.category.BarRenderer3D;

public class CurrentConditionDisplayGraph implements Observer, DisplayElement {
	private DefaultCategoryDataset datasetTemp, datasetHumidity;
	private final String tempString = "Temperatura";
	private final String humiString = "Humedad";
	private final String grados = "º F";
	private final String porcentaje = " % ";
	private JFreeChart temperatura, humedad;
	private ChartPanel tempPanel, humPanel;
	private JFrame frame;
	private int indice = 1;
	private BarRenderer render;
	private LineAndShapeRenderer r;
	
	private final Color azulFuerte = new Color(60,160,240), azulBajo = new Color(200,250,255), naranjaBajo = new Color(255, 250, 220), naranja = new Color(255,160,0),rojoBajo = new Color(255,50,0), rojo = new Color(165,0,0); 
	
	public CurrentConditionDisplayGraph(Observable o) {
		// TODO Auto-generated constructor stub
		this.datasetTemp = new DefaultCategoryDataset();
		this.datasetHumidity = new DefaultCategoryDataset();
		o.addObserver(this);
		this.frame = new JFrame("Grafica de Temperatura y Humedad");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.temperatura = ChartFactory.createBarChart("Grafica de temperatura",tempString,grados,datasetTemp,PlotOrientation.VERTICAL,false,false,false);
		this.humedad = ChartFactory.createLineChart("Grafica de Humedad", humiString, porcentaje, datasetHumidity,PlotOrientation.VERTICAL,false,false,false);
		
		render = (BarRenderer)temperatura.getCategoryPlot().getRenderer();
		render.setBarPainter(new StandardBarPainter());
		
		for(int i = 0; i < datasetTemp.getColumnCount(); i++) {
			render.setSeriesPaint(i, rojo);
		}
		
		r = (LineAndShapeRenderer)humedad.getCategoryPlot().getRenderer();
		for(int i = 0; i < datasetHumidity.getColumnCount(); i++) {
			r.setSeriesStroke(i, new BasicStroke(2));
			r.setSeriesPaint(i, azulFuerte);
		}
		
		this.temperatura.setBackgroundPaint(Color.WHITE);
		this.temperatura.getPlot().setBackgroundPaint(Color.white);
		this.humedad.setBackgroundPaint(Color.WHITE);
		this.humedad.getPlot().setBackgroundPaint(Color.white);
		
		this.tempPanel = new ChartPanel(temperatura);
		this.humPanel = new ChartPanel(humedad);
		this.tempPanel.setPreferredSize(new Dimension(750,300));
		this.humPanel.setPreferredSize(new Dimension(750, 300));
		p.add(tempPanel);
		p.add(humPanel);
		this.frame.getContentPane().add(p);
		this.frame.pack();
		this.frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof WeatherData) {
			WeatherData d = (WeatherData)o;
			datasetHumidity.addValue(new Double(d.getHumidity()), humiString,"Toma " + indice);
			datasetTemp.addValue(new Double(d.getTemperature()), tempString,"Toma " + indice);
			indice++;
			display();
		}
	}

}