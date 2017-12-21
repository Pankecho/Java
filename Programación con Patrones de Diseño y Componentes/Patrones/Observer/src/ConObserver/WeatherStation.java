package ConObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionDisplay cd = new CurrentConditionDisplay(weatherData);
		CurrentConditionDisplayGraph cdg = new CurrentConditionDisplayGraph(weatherData);
		HeatIndexDisplay d = new HeatIndexDisplay(weatherData);
		StatisticsDisplay s = new StatisticsDisplay(weatherData);
		
		weatherData.setMeasurements(30, 65, 30.4f);
		weatherData.setMeasurements(90, 10, 29.2f);
		weatherData.setMeasurements(50, 90, 29.2f);
		
		JFrame frame = new JFrame("Agrega nuevos datos");
		JPanel uno = new JPanel();
		JButton button = new JButton("Agregar");
		JTextField temp = new JTextField("Temperatura",20), hum = new JTextField("Humedad",20), pre = new JTextField("Presion",20);
		uno.add(temp);
		uno.add(hum);
		uno.add(pre);
		uno.add(button);
		
		frame.getContentPane().add(uno);
		frame.pack();
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Double t = Double.valueOf(temp.getText());
					Double h = Double.valueOf(hum.getText());
					Double p = Double.valueOf(pre.getText());
					weatherData.setMeasurements(t.floatValue(), h.floatValue(), p.floatValue());
				}catch (Exception ex) {
					// TODO: handle exception
				}
				
				
			}
			
		});
		
	}
}

