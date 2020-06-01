package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Productdetails_BLC
{

	static Connection con;
	
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=root");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void maxPrice()
	{
		Statement s1=null;
		ResultSet r1=null;
		
		String query = "SELECT * FROM productdetails WHERE Product_prc = (SELECT MAX(Product_prc) FROM productdetails); ";
		try 
		{
			s1= con.createStatement();
			r1= s1.executeQuery(query);
			
			System.out.println("Product ID\t Product Name\t Product Prc");
			System.out.println("-----------------------------------------------");
			while(r1.next())
			{
				System.out.println(r1.getInt(1)+"\t"+r1.getString(2)+"\t"+r1.getDouble(3));
				System.out.println("-----------------------------------------------");

			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void minPrice()
	{
		Statement s1=null;
		ResultSet r1=null;
			
		String query = "SELECT * FROM productdetails WHERE Product_prc = (SELECT MIN(Product_prc) FROM productdetails);";
		try 
		{
			s1= con.createStatement();
			r1= s1.executeQuery(query);
			
			System.out.println("Product ID\t Product Name\t Product Prc");
			System.out.println("-----------------------------------------------");
			while(r1.next())
			{
				System.out.println(r1.getInt(1)+"\t"+r1.getString(2)+"\t"+r1.getDouble(3));
				System.out.println("-----------------------------------------------");
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}

