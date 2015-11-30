
public class RubberDuck extends Duck{

	public RubberDuck(){flyBehavior = new FlyNoWay();}
	@Override
	void display() {
		System.out.println("I'm a real Rubber Duck");
	}

}
