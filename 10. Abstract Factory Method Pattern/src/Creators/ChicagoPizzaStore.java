package Creators;

import AbstractFactory.ChicagoPizzaIngredientFactory;
import AbstractFactory.PizzaIngredientFactory;
import Products.*;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String item) {
		PizzaIngredientFactory pf = new ChicagoPizzaIngredientFactory();
		Pizza pizza = null;
		if(item.equals("cheese")){ 
			pizza =  new CheesePizza(pf);
			pizza.setName("Chicago Style Cheese Pizza");
		}
		else if (item.equals("veggie")){ 
			pizza = new VeggiePizza(pf);
			pizza.setName("Chicago Sytle Veggie Pizza");
		}
		return pizza;
	}

}
