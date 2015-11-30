package Products;

import AbstractFactory.PizzaIngredientFactory;

public class VeggiePizza extends Pizza{
	
	PizzaIngredientFactory ingredientFactory;
	
	public VeggiePizza(PizzaIngredientFactory pf){
		this.ingredientFactory = pf;
	}
	@Override
	public void prepare() {
		System.out.println("Preparing "+name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
	}

}
