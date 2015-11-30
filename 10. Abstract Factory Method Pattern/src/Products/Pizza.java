package Products;

import Ingredient.*;

public abstract class Pizza {
	Dough dough;
	Sauce sauce;
	
	protected String name;
	public abstract void prepare();
	public void bake()	  {System.out.println("Bake for 25 minites at 350");}
	public void cut()	  {System.out.println("Cutting the pizza into diagonal slices");}
	public void box()	  {System.out.println("Place pizza in official PizzaStore box");}
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) { result.append(dough); result.append("\n"); }
		if (sauce != null) { result.append(sauce); result.append("\n"); }
		return result.toString();
	}
}
