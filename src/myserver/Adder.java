import java.rmi.*;
import java.util.List;
import myserver.accounts;
public interface Adder extends Remote{
public int delexp(int x,int y, int i) throws RemoteException;
public int addinc(int x, int y, int i) throws RemoteException;
public List<accounts> dbconn(int id) throws RemoteException;
public int getIncome(int id) throws RemoteException;
public int getExp(int id) throws RemoteException;
}
