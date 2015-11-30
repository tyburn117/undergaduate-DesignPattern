import java.util.*;
public class ls {
	public static void main(String [] args){
		FileComponent file = new Directory(System.getProperty("user.dir"));
		file.print();
		
	}
}
