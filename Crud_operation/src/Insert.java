import java.sql.*;
import java.util.Scanner;
public class Insert 
{
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.print("Enter The Details of the Employee\nName = ");
		String ename = sc.nextLine();
		System.out.print("Employee Number = ");
		int eno = sc.nextInt();
		System.out.print("Age = ");
		String age = sc.next();
		
		

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Office","root","asd@1234");
				
		String query = "Insert into Employee values (? , ? , ? , ? ,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, ename);
		pst.setInt(2, eno);
		pst.setString(4, age);
		
		int affected_rows = pst.executeUpdate();
		
		if (affected_rows > 0)
		{
			System.out.println("Data Inserted");
		}
		sc.close();
		con.close();
	}
}