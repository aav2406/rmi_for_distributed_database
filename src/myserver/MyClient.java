import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import myserver.accounts;

public class MyClient{
public static void main(String args[]){
try{
Scanner sc=new Scanner(System.in);
int expamount,income=0,inc=0,choice,exit=1,id;
int totalexp=0;
System.out.println("Enter Password: ");
id=sc.nextInt();
Registry Naming = LocateRegistry.getRegistry("localhost",8000);
Adder stub=(Adder)Naming.lookup("AddService");
System.out.println("Initial Balance is: ");
income=stub.getIncome(id);
System.out.println(income);
System.out.println("Expense till now is: ");
totalexp=stub.getExp(id);
System.out.println(totalexp);
do{
System.out.println("Enter your Choice :\n ");
System.out.println("1.Credit :");
System.out.println("2.View Total Amount after Credit : ");
System.out.println("3.Debit :");
System.out.println("4.View Total Debited Amount");
System.out.println("5.Retrive User Details");
System.out.println("6.Balance");
System.out.println("7.Exit");
choice=sc.nextInt();
switch(choice)
{
    case 1:{
        System.out.println("Enter Amount to be added : ");
        inc=sc.nextInt();

        int total=income;
        income=stub.addinc(total,inc,id);
        System.out.println("Sucessfully Added ");
        break;
    }
    case 2:{
        System.out.println("Total Credited Amount :" +income);
        break;
    }
    case 3:
    {
        System.out.println("Enter the Amount : ");
        expamount=sc.nextInt();
        totalexp=stub.delexp(totalexp,expamount,id);
        System.out.println("Sucessfully Debited ");
        break;
        
    }
    case 4:{
        System.out.println("Total Debited Amount "+ totalexp);
        break;
    }
    case 5:{
        System.out.println("Retriving Data from DB ");
        //String[] ar=new String[10];
        List<accounts> list = (List)stub.dbconn(id);
        for (accounts s : list) {
            // System.out.println("bc "+s.getBranch());
            System.out.println("ID: " + s.getId());
            System.out.println("name: " + s.getName());
            System.out.println("Credited Amount: " + s.getIncome());
            System.out.println("Total Debited Amount: " + s.getExpense());
        }
        break;   
    }
    case 6:{
       System.out.println("Balance Remaining: "+(income-totalexp));
       
        break;
    }
    case 7:
    {
         exit=0;
        break;
    }
    default:{
        System.out.println("Wrong Choice");

    }
}

}while(exit==1);
}
catch(Exception e){}
}
}
