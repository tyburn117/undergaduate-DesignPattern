
public class MiniDuckSimulator1 {

	public static void main(String[] args) {
		
		Duck mallard = new MallardDuck();
		mallard.performFly();
		
		Duck rubber = new RubberDuck();
		rubber.performFly();
		
		rubber.setFlyBehavior(new FlyRocketPowered());
		rubber.performFly();
	}

}
