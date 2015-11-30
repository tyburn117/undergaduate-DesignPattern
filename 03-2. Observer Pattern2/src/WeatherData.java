import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float 온도, 습도, 기압, 풍속;
	
	public WeatherData(){observers = new ArrayList();}
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	@Override
	public void removeObserver(Observer o) {
		
	}
	@Override
	public void notifyObservers() {
		for( Observer o : observers ) o.update(온도 ,습도, 기압,풍속);
	}

	public void setMeasurement(float t, float h, float p){
		온도 = t; 습도 = h; 기압 = p;
		measurementsChanged();
	}
	public void measurementsChanged(){
		notifyObservers();
	}
}
