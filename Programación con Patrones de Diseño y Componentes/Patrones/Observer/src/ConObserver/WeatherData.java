package ConObserver;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable{

	private float temperature, humidity, pressure;
	
	public WeatherData() {
		// TODO Auto-generated constructor stub
	}
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temp, float h, float p) {
		this.temperature = temp;
		this.humidity = h;
		this.pressure = p;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}
