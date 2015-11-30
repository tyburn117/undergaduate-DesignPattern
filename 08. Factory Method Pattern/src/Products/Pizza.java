package Products;

public abstract class Pizza {
	protected String name;
	public void prepare(){System.out.println("Preparing "+name);}
	public void bake()	  {System.out.println("Bake for 25 minites at 350");}
	public void cut()	  {System.out.println("Cutting the pizza into diagonal slices");}
	public void box()	  {System.out.println("Place pizza in official PizzaStore box");}
	public String getName(){return name;}
}
