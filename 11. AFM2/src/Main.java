
import Complier.*;

public class Main {
	public static void main(String [] args){
		MyCompiler c = new  CCompiler();
		c.compile();
		
		c = new JavaCompiler();
		c.compile();
	}
}
