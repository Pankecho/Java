package ConObserver;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement{

	private float maxTemp = 0.0f, minTemp = 200, tempSum= 0.0f;
	private int numReadings;
	
	public StatisticsDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Avg/Max/Min temperatura = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings ++;
			if (temp > maxTemp)
				maxTemp = temp;
 
			if (temp < minTemp)
				minTemp = temp;
			
			display();
		}
	}

}
