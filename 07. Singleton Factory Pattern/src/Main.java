import java.util.ArrayList;

public class Main  {

	private static int number = 50;
	
	public static void main(String[] args) throws InterruptedException {
		
		MyThread r = new MyThread();
		ArrayList<Thread> th = new ArrayList<Thread>();
		
		for(int i = 0 ; i < number; i++)
			th.add(new Thread(r));
		
		for(int i = 0 ; i < number ; i++)
			th.get(i).start();
		
		for(int i = 0 ; i < number ; i++)
			th.get(i).join();
		
		System.out.println(Singleton2.getValue());
		
	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		Singleton2 single = Singleton2.getInstance();
	}
	
}