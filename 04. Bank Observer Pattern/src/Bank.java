import java.util.ArrayList;
public class Bank implements Subject{

	private ArrayList<Observer> customers;
	private String message;
	public Bank(){
		customers  = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		customers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		for(Observer o : customers){
			o.update(message);
		}
	}
	
	public void notifyMessage(String message){
		this.message = message;
		this.notifyObservers();
	}
}
