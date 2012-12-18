package fa;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class TestSever extends UnicastRemoteObject implements TestSeverRMI{
	private static final long serialVersionUID = 1L;
	
	private DbConnector testServer;
	
	public TestSever() throws RemoteException {
	}
	
	public boolean dbConnectionTest() {
		testServer = new DbConnector();
		testServer.connectDb();
		
		Article test = new Article();
		test.setUpdated(Date.valueOf("2012-12-16"));
		test.setHead("Test-Artikel");
		test.setContent("Dies ist ein einfacher Artikel :-)");
		
		testServer.setArticle(test);
		
		testServer.disconnectDb();
		
		return false;
	}
	
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager());
		
		try {
			TestSever testsever = new TestSever();
			Naming.bind("rmi://127.0.0.1:1090/testsever", testsever);
			System.out.println("gebinded");
			testsever.dbConnectionTest();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				Naming.unbind("rmi://127.0.0.1:1090/testsever");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}