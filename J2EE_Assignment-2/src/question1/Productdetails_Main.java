package question1;

import java.util.Scanner;
public class Productdetails_Main 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
	
		Scanner sc1=new Scanner(System.in);
		
		Productdetails_BLC p1 =new Productdetails_BLC();

		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: Display Product Details which having Maximum Price:");
		System.out.println("2: Display Product Details which having Minimum Price:");
		
		int ch=sc1.nextInt();
		
		switch(ch)
		{
			case 1: p1.maxPrice();
			 		break;
			
			case 2: p1.minPrice();
	 				break;
		}
	}
}