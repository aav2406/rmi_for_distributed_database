import java.rmi.*;
import java.rmi.server.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import myserver.accounts;
public class AdderRemote extends UnicastRemoteObject implements Adder
{
AdderRemote() throws RemoteException
{
super();
}

public int getIncome(int id) throws RemoteException{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
//Statement stmt = null;
//stmt = conn.createStatement(); 
int income = 0;
    Statement stmt = null;
    stmt = conn.createStatement();
      
      PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from debit WHERE id = "+id);
      ResultSet rs = preparedStmt.executeQuery();
      while(rs.next()){
        income = rs.getInt("income");
      }
conn.close();
return income;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
return 0;
}



public int getExp(int id) throws RemoteException{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
//Statement stmt = null;
//stmt = conn.createStatement(); 
int expense= 0;
    Statement stmt = null;
    stmt = conn.createStatement();
      
      PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from debit WHERE id = "+id);
      ResultSet rs = preparedStmt.executeQuery();
      while(rs.next()){
        expense = rs.getInt("expense");
      }
conn.close();
return expense;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
return 0;
}





public int delexp(int x, int y, int i)
{
    
 String z=Integer.toString(x+y);
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
//Statement stmt = null;
//stmt = conn.createStatement();  
      String sql = "UPDATE debit SET expense = ? where id = ?";
      //stmt.executeUpdate(sql);
     // String query = "update users set num_points = ? where first_name = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString(1,z);
      preparedStmt.setInt(2, i);
      // execute the java preparedstatement
      preparedStmt.executeUpdate();
conn.close();
return x+y;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
}
    return x+y;
    
    
}
public int addinc(int x, int y, int i)
{
    String z=Integer.toString(x+y);
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
//Statement stmt = null;
//stmt = conn.createStatement();  
      String sql = "UPDATE debit SET income = ? where id = ?";
      //stmt.executeUpdate(sql);
     // String query = "update users set num_points = ? where first_name = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString(1,z);
      preparedStmt.setInt(2, i);
      // execute the java preparedstatement
      preparedStmt.executeUpdate();
conn.close();
return x+y;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
}
    return x+y;
    
}
public List<accounts> dbconn(int id)
{
try
{
List<accounts> list;   
list = new ArrayList<>();
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
Statement stmt = null;
stmt = conn.createStatement();
      
      PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from debit WHERE id = "+id);
      ResultSet rs = preparedStmt.executeQuery();

        while(rs.next()) { 
         // Retrieve by column name 
         int id1 = rs.getInt("id"); 
         String name= rs.getString("name"); 
         int income = rs.getInt("income"); 
         int expense = rs.getInt("expense"); 
         
         accounts accounts = new accounts(); 
         accounts.setID(id1); 
         accounts.setName(name); 
         accounts.setIncome(income); 
         accounts.setExpense(expense); 

         list.add(accounts);
        }
conn.close();
return list;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
    return null;
}
}