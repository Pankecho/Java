package SinObserver;
public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionDisplay cd = new CurrentConditionDisplay(weatherData);
		
		weatherData.setMeasurements(30, 65, 30.4f);
		weatherData.setMeasurements(28, 70, 29.2f);
		weatherData.setMeasurements(15, 90, 29.2f);
	}

}
