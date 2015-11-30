package Creators;

import AbstractFactory.*;
import Products.*;

public class NYPizzaStore extends PizzaStore{
	
	@Override
	Pizza createPizza(String item) {
		PizzaIngredientFactory pf = new NYPizzaIngredientFactory();
		Pizza pizza = null;
		if(item.equals("cheese")){ 
			pizza =  new CheesePizza(pf);
			pizza.setName("New York Style Cheese Pizza");
		}
		else if (item.equals("veggie")){ 
			pizza = new VeggiePizza(pf);
			pizza.setName("New York Sytle Veggie Pizza");
		}
		return pizza;
	}

}
