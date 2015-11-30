package Products;

import AbstractFactory.*;
public class CheesePizza extends Pizza{
	
	PizzaIngredientFactory ingredientFactory;
	
	public CheesePizza(PizzaIngredientFactory pf){
		this.ingredientFactory = pf;
	}
	@Override
	public void prepare() {
		System.out.println("Preparing "+name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
	}

}
