package ConObserver;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
	Observable observable;
	private float temperature, humidity;
	
	public CurrentConditionDisplay(Observable o) {
		// TODO Auto-generated constructor stub
		this.observable = o;
		o.addObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Condiciones del clima: " + temperature + " º F y " + humidity + "% de humedad");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof WeatherData) {
			WeatherData d = (WeatherData)o;
			this.temperature = d.getTemperature();
			this.humidity = d.getHumidity();
			display();
		}
	}

}
