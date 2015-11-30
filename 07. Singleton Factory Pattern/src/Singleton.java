
public class Singleton {
	private volatile static Singleton uniqueInstance = null;
	private static int value = 0;
	
	private Singleton() throws InterruptedException{
		
		value++;
	}
	public static int getValue(){return value;}
	
	public static synchronized Singleton getInstance() throws InterruptedException{
		
		if(value<20){
			
			uniqueInstance = new Singleton();
			
		}
		return uniqueInstance;
	}
//	public static Singleton getInstance() throws InterruptedException{
//		
//		if(uniqueInstance == null){
//			synchronized(Singleton.class){
//				if(uniqueInstance == null){
//					Thread.sleep(5);
//					uniqueInstance = new Singleton();
//				}
//			}
//		}
//		return uniqueInstance;
//	}
//	public static Singleton getInstance() throws InterruptedException{
//		
//		if(value < 20){
//			synchronized(Singleton.class){
//				if(value < 20){
//					Thread.sleep(5);
//					uniqueInstance = new Singleton();
//				}
//			}
//		}
//		return uniqueInstance;
//	}
}
