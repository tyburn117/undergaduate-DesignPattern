package AbstractFactory;

import Ingredient.*;

public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
}
