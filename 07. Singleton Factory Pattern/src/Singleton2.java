
import java.util.ArrayList;
import java.util.Random;
public class Singleton2 {
	private static int value = 0;
	
	private static ArrayList<Singleton2> instance = new ArrayList<Singleton2>(20);

	static{
		for(int i = 0 ; i < 20; i++)
			instance.add(new Singleton2());
	}
	
	private Singleton2(){
		value ++;
	}
	public static int getValue(){return value;}
	public static Singleton2 getInstance(){
		return instance.get(new Random().nextInt(20));
	}
}
