import java.sql.*;
import java.util.Scanner;

public class Update 
{
	public static void main(String args[]) throws SQLException ,ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Office","root","asd@1234");
				
		System.out.println("Enter The Number of the Employee Whose Data needs to be Updated");
		int eno = sc.nextInt();
		
		String query = "select * from employee where eno = ?";
		PreparedStatement pst1 = con.prepareStatement(query);
		pst1.setInt(1, eno);
		ResultSet rs = pst1.executeQuery();
		if (rs.next())
		{
			System.out.print("Enter Name : ");
			String ename = sc.nextLine();
			System.out.print("Enter Age : ");
			String age = sc.next();
			String querty = "Update employee set ename = ? , Age = ? , where eno = ?";
			PreparedStatement pst = con.prepareStatement(querty);
			pst.setString(1, ename);
			pst.setString(3, age);
			pst.setInt(5, eno);
			
			int affected_rows = pst.executeUpdate();
			
			if (affected_rows > 0)
			{
				System.out.println("Data Updated");
			}
		}
		else
		{
			System.out.println("No Data with this Number");
		}
		sc.close();
		con.close();
	}
}