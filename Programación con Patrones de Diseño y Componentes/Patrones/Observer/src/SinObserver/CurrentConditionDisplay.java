package SinObserver;

public class CurrentConditionDisplay implements Observer,DisplayElement {

	private float temperature, humidity;
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject data) {
		// TODO Auto-generated constructor stub
		this.weatherData = data;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Condiciones del clima: " + temperature + "º Centigrados y " + humidity + "% de humedad");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}
	
}
