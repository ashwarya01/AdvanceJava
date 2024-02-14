import java.sql.*;

public class Select 
{
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Office","root","asd@1234");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from employee");
		System.out.println("Name\tEmployee Number\tAge");
		while (rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
		}
		
		con.close();
	}
}