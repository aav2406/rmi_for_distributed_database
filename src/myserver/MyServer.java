import java.rmi.*;
import java.rmi.registry.*;
public class MyServer{
public static void main(String args[]){
try{
Registry Naming = LocateRegistry.createRegistry(8000);
Adder stub=new AdderRemote();
Naming.rebind("AddService",stub);
System.out.println("server ready");
}
catch(Exception e){System.out.println(e);}
}
}