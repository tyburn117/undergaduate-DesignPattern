
public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		NewDisplay newDisplay = new NewDisplay(weatherData);
		
		weatherData.setMeasurement(80, 65, 30.4f);
		
	}

}