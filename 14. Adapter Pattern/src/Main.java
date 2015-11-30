
interface Duck {
	public void quack();
	public void fly();
}

interface Turkey {
	public void gobble();
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

class Adapter implements Duck{

	private Turkey turkey;
	
	public Adapter(Turkey t){
		turkey = t;
	}
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5; i ++)
			turkey.fly();
	}
	
}


public class Main {
	public static void main(String [] args){
		WildTurkey turkey  = new WildTurkey();
		Duck adapter = new Adapter(turkey);
		
		adapter.quack();
		adapter.fly();
	}
}
