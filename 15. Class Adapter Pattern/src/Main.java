
interface Turkey {
	public void gobble();
	public void fly();
}

interface Duck {
	public void quack();
	public void fly();
}

class WildTurkey implements Turkey {

	@Override
	public void gobble() {
		// TODO Auto-generated method stub
		System.out.println("Gooble!");
	}

	@Override
	public void fly() {
		System.out.println("I little fly");
	}

}
class Adapter extends WildTurkey implements Duck{

	
	@Override
	public void quack() {
		super.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5; i ++)
			super.fly();
	}
	
}

public class Main {
	public static void main(String [] args){
		Duck adapter = new Adapter();
		
		adapter.quack();
		adapter.fly();
	}
}
