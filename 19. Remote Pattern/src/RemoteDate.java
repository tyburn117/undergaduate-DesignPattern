import java.rmi.*;
import java.util.Date;

public interface RemoteDate extends Remote{
	public Date getDate() throws RemoteException;
}
