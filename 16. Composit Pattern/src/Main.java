import java.util.*;

interface Graphic
{
	public void print(); 
}
class Circle implements Graphic{
	private String name;
	public Circle(String name){
		this.name = name;
	}
	public void print() {
		System.out.println("원 :"+name);	
	}
}
class CompositeGraphic implements Graphic{
	
	private List<Graphic> children = new ArrayList<Graphic>();
	public void print() {
		for(Graphic child: children){
			child.print();
		}
	}
	public void add(Graphic child){
		children.add(child);
	}
	public void remove(Graphic child){
		children.remove(child);
	}
}
public class Main {
	public static void main(String[] args){
		Circle c1, c2, c3, c4;
		c1 = new Circle("1번");
		c2 = new Circle("2번");
		c3 = new Circle("3번");
		c4 = new Circle("4번");
		
		CompositeGraphic g, g1, g2;
		g = new CompositeGraphic();
		g1 = new CompositeGraphic();
		g2 = new CompositeGraphic();
		
		g1.add(c1);
		g1.add(c2);
		g1.add(c3);
		g1.add(c4);
		
		g.add(g1);
		g.add(g2);
		
		g.print();
	}
}
