import java.rmi.*;
public class RMIClient {
	static final String server="127.0.0.1:1099";
	
	public static void main(String [] args){
		try{
			String host = "rmi://" + server + "/DateServer";
			
			RemoteDate ds = (RemoteDate)Naming.lookup(host);
			System.out.println(ds.getDate());
		}catch(Exception e){e.printStackTrace();}
	}
}
