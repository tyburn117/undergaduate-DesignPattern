
public class MallardDuck extends Duck {

	@Override
	void display() {
		System.out.println("I'm a real Mallard duck");
	}
	public MallardDuck(){flyBehavior = new FlyWithWings();}

}
