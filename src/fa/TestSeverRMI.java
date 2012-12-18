package fa;

import java.rmi.*;

public interface TestSeverRMI extends Remote {
	public boolean dbConnectionTest() throws RemoteException;
}
