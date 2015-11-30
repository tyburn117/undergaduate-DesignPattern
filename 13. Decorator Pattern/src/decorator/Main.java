package decorator;

abstract class Beverage{
	String description = "Unknown Beverage";
	public String getDesc(){
		return description;
	}
	public abstract double cost();
}

class HouseBlend extends Beverage{
	public HouseBlend(){
		description = "House Blend Coffee";
	}
	@Override
	public double cost() {
		return 0.89;
	}
	
}
class Espresso extends Beverage{
	public Espresso(){
		description="Espresso";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}	
}

abstract class CondimentDecorator extends Beverage{
	Beverage beverage;
}

class Milk extends CondimentDecorator {
	public Milk(Beverage beverage){
		this.beverage = beverage;
	}

	public String getDesc(){
		return beverage.getDesc()+", Milk";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+0.1;
	}
}

class Mocha extends CondimentDecorator{
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDesc(){
		return beverage.getDesc()+", Mocha";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+0.2;
	}
	
}

public class Main {

	public static void main(String[] args) {
		Beverage beverage1 = new Espresso();
		System.out.println(beverage1.getDesc()+" $"+beverage1.cost());
		
		Beverage beverage2 = new Espresso();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Milk(beverage2);
		
		System.out.println(beverage2.getDesc()+" $"+beverage2.cost());
	}

}
