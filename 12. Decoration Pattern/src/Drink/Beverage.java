package Drink;

public abstract class Beverage {
	protected String description = "Unknown Beverage";
	
	public String getDesc(){
		return description;
	}
	public abstract double cost();
}
