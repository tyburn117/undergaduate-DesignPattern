
public abstract class Duck {
	FlyBehavior flyBehavior;
	public Duck(){};
	
	abstract void display();
	public void swim(){System.out.println("All ducks float, even decoys!");}
	public void performFly(){flyBehavior.fly();}
	
	public void setFlyBehavior(FlyBehavior fb){flyBehavior = fb;}
}
