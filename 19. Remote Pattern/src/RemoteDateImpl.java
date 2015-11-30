import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.net.*;

import javax.management.remote.rmi.RMIServer;

public class RemoteDateImpl 
extends UnicastRemoteObject
implements RemoteDate
{
	
	public RemoteDateImpl() throws RemoteException {
//		SecurityManager rm = new SecurityManager();
//		rm.checkPermission(new SocketPermission("localhost:1099", null));
//		
//		System.setSecurityManager(rm);
//		
//		System.setSecurityManager(new RMISecurityManager().checkPermission(new SocketPermission("localhost:1099-", "connet,resolve")));
	
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Date getDate() throws RemoteException {
		// TODO Auto-generated method stub
		return new Date();
	}
	
	public static void main(String [] args){
		try{
			
			RemoteDate ds = new RemoteDateImpl();
			Naming.rebind("DateServer", ds);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
}
