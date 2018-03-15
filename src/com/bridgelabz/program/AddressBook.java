package com.bridgelabz.program;

import com.bridgelabz.utility.Utility;

public class AddressBook 
{
	static
	{
		System.out.println("**********Address Book**********");
	}
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		int choice=0;
		do
		{
			System.out.println("1.Add details \n2.Edit details \n3.Delete details \n4.Sort By Name "
					+ "\n5.Sort By Zipcode \n6.Display Address book \n7.Exit");
			System.out.println("Enter your choice: ");
			choice = utility.inputInteger();
			switch(choice)
			{
			case 1:
				Utility.addPerson();
				break;
			case 2:
				Utility.editDetails();
				break;
			case 3:
				Utility.deleteDetails();
				break;
			case 4:
				Utility.sortByName();
				break;
			case 5:
				Utility.sortByZip();
				break;
			case 6:
				Utility.displayAddressBook();
				break;
			case 7:
				System.out.println("*****Thanks*****");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
					
			}
			
		}while(choice > 0);
	}
}
