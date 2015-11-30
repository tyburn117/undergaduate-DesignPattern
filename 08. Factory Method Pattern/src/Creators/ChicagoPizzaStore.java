package Creators;

import Products.*;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	ChicagoStylePizza createPizza(String item) {
		if(item.equals("cheese")) return new ChicagoStyleCheesePizza();
		else if(item.equals("veggie")) return new ChicagoStyleVeggiePizza();
		return null;
	}

}
