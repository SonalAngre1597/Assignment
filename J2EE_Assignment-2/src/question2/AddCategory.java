package question2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddCategory 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Product Category");
		String cat= scan.next();
		
		Connection con = null;
		Statement s1 = null;
		ResultSet r1 = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=root");
			
			String query="select Product_name from productdetails where Product_category='"+cat+"'";
			s1 = con.createStatement();
			r1 = s1.executeQuery(query);
			
			while(r1.next())
			{
				String name=r1.getString("product_name");
				System.out.println(name);
				System.out.println("-----------------------------------------------------");
				
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(s1!=null)
			{
				try 
				{
					s1.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			if(r1!=null)
			{
				try 
				{
					r1.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

}
