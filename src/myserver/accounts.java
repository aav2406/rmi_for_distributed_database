/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

/**
 *
 * @author user
 */
public class accounts implements java.io.Serializable {   
   private int id, income,expense;   
   private String name;    
  
   public int getId() { 
      return id; 
   } 
   public String getName() { 
      return name; 
   }
   public int getIncome() { 
      return income; 
   } 
   public int getExpense() { 
      return expense; 
   }
   public void setID(int id) { 
      this.id = id; 
   } 
   public void setName(String name) { 
      this.name = name; 
   } 
   public void setIncome(int income) { 
      this.income = income; 
   } 
   public void setExpense(int expense) { 
      this.expense = expense; 
   }
}
