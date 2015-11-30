
public class CurrentConditionsDisplay implements DisplayElement,Observer {
	private float temperature, humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}


	public void display() {
		System.out.println("Current conditions: " + temperature+"F degrees and "+humidity+"% humidity");
	}

	@Override
	public void update(float t, float h, float p, float w) {
		temperature = t; humidity = h;
		display();
	}

	
}
