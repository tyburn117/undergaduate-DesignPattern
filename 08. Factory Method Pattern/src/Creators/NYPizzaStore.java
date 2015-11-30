package Creators;

import Products.*;

public class NYPizzaStore extends PizzaStore{

	@Override
	NYStylePizza createPizza(String item) {
		if(item.equals("cheese")) return new NYStyleCheesePizza();
		else if (item.equals("veggie")) return new NYStyleVeggiePizza();
		return null;
	}

}
