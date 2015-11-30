package Creators;

import Products.Pizza;

public abstract class PizzaStore {
	abstract Pizza createPizza(String item);
	public Pizza orderPizza(String type){
		Pizza pizza = createPizza(type);
		System.out.println("--- making a "+pizza.getName()+"---");
		pizza.prepare(); pizza.bake(); pizza.cut(); pizza.box();
		return pizza;
	}
}
