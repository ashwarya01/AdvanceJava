package Bca.model;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.Scanner; 
public class employee { 
 public employee() { 
 super(); 
 
 } 
 public void insertEmployee(Connection con, Scanner sc) throws 
SQLException { 
 
 // Create statement 
 Statement st = con.createStatement(); 
 //read student details 
 System.out.println("Enter the Employee Name:"); 
 String ename = sc.nextLine(); 
 System.out.println("Enter the Employee Number:"); 
 int eno = sc.nextInt(); 
 System.out.println("Enter Employee Age: "); 
 String age = sc.next(); 
  
 
 // create sql query string 
 //create sql squery string 
 String query = String.format("Insert Into employee values(%d, '%s', %s, '%s') ", ename, eno, age); 
 //excecute sql quesry 
 int rows = st.executeUpdate(query); 
 
 System.out.println(rows + " record inserted!!!"); 
 
 } 
 public void displayEmployee(Connection con) throws SQLException { 
 Statement st = con.createStatement(); 
 
 ResultSet rs = st.executeQuery("select * from employee"); 
 
 while(rs.next()) { 
 System.out.println(rs.getInt(1)+ 
"\t"+rs.getString(2)+ "\t"+ rs.getString(3)+"\t"+rs.getString(4)); 
 } 
 
 } 
 public void updateEmployeename(Connection con, Scanner sc) 
throws SQLException { 
 Statement st = con.createStatement(); 
 System.out.println("Enter Employee Number: "); 
 int eno = sc.nextInt(); 
 System.out.println("Enter Employee New Name: "); 
 String ename = sc.nextLine(); 
 
 String query = String.format("update employee set ename='%s' where eno = %d", ename, eno); 
 int rowsAffected = st.executeUpdate(query); 
 System.out.println(rowsAffected+" recored updated!!!"); 
 
 } 
 
 public void removeEmployee(Connection con, Scanner sc) throws 
SQLException { 
 Statement st = con.createStatement(); 
 System.out.println("Enter Employee Number: "); 
 int eno = sc.nextInt(); 
 
 int rowAffected = st.executeUpdate("delete from employee where eno = "+eno); 
 System.out.println(rowAffected + " recored deleted!!!"); 
 
 
 } 
} 