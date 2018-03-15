package com.bridgelabz.program;
import com.bridgelabz.utility.Utility;

public class CommericalDataProcessing 
{
	static
	{
		System.out.println("**********Commerical Data Processing**********");
	}
	public static void main(String []args)
	{
		Utility utility = new Utility();
		int choice=0;
		do {	
			System.out.println("Enter your choice:");
			System.out.println("1. Create user");
			System.out.println("2. Buy Share");
			System.out.println("3. Sale Share");
			System.out.println("4. Display Details");
			System.out.println("5. Exit");
			 choice = utility.inputInteger();
			switch(choice)
			{
			case 1:	 	Utility.createAccount();
			break;
			case 2 :	Utility.buyShare();
			break;
			
			case 3 :	Utility.saleShare();
			break;
			case 4 :	Utility.printReport();
			break;
			case 5 :
				System.out.println("*****Thanks*****");
				System.exit(0);
			default : 
				System.out.println("Invalid choice");
			}
		}while(choice > 0);
	}

}
