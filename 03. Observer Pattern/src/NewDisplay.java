public class NewDisplay implements DisplayElement, Observer {
	private float temperature, humidity;
	private Subject weather;
	
	public NewDisplay(Subject weatherData){
		weather = weatherData;
		weather.registerObserver(this);
	}
	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		temperature = temp;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("NewCurrent conditions: " + temperature+"F degrees and "+humidity+"% humidity");
	}

}
