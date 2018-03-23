package com.bridgelabz.program;
/***************************************************************************
 * @purpose : Company share using stack and queue
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 15/03/2018
 ***************************************************************************/
import com.bridgelabz.utility.Utility;
import com.bridgelabz.datastructure.LinkedList1;
public class CompanyShare 
{
	static
	{
		System.out.println("********* Company Shares ********");
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		LinkedList1 list = new LinkedList1();
		Utility utility = new Utility();
		
	
		while(true)
		{
			System.out.println("1. Add the shares");
			System.out.println("2. Remove the shares");
			System.out.println("3. Display the shares");
			
			System.out.println("4. Exit");
			int lChoice =utility.inputInteger();        
			switch (lChoice)
			{
			case 1 : 
				System.out.println("Enter element to insert");
				list.add(utility.inputInteger());  
				break;      

			case 2 : 
				System.out.println("Enter position to remove");
				int position = utility.inputInteger();  
				list.remove(position);
				System.out.println("removed successfuly");
				break;
				
			case 3:
				System.out.print("Shares are: ");
				list.display();
				break;                  
		  
			case 4:
				System.out.println("Thanks.......");
				System.exit(0);
			default : 
				System.out.println("Invalid choice ");
				  
			}

		}              
	}

		
	
}
