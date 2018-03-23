package com.bridgelabz.program;

import com.bridgelabz.utility.Utility;

public class CommericalData 
{
	public static void main(String[] args) {
		Utility utility = new Utility();
		int choice;
		System.out.println();
		System.out.println("***************** @ Share Market @ ************** ");
		System.out.println();
		do {
			System.out.println("Enter 1.Create Account");
			System.out.println("Enter 2.Buy share");
			System.out.println("Enter 3.Sell share");
			System.out.println("Enter 4.Print Report");
			System.out.println("Enter 5.Exit");
			choice = utility.inputInteger();
			
			switch (choice) {
			case 1:
				System.out.println(" ***** Fill User Informatoion *****");
				Utility.createUser();
				break;

			case 2:
				Utility.buyshare();
				break;

			case 3:
				Utility.saleShare();
				break;

			case 4:
				Utility.printReport();
				break;
			case 5:
				System.exit(0);
				break;

			}
		} while (choice >0);

	}

	
}
