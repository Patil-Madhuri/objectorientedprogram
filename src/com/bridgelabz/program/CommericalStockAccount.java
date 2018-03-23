package com.bridgelabz.program;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class CommericalStockAccount 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		Scanner scanner = new Scanner(System.in);
		StockAccount account=new StockAccount();
		StockAccount stockAccount=new StockAccount();
		String name,symbol;
		long money,noOfShares=0,priceOfEachShare=0;
		long total_share;
		int choice=0;
		do
		{
			System.out.println("1. Create Account");
			System.out.println("2. Buy Shares");
			System.out.println("3. Sell Shares");
			System.out.println("4. Add Company");
			System.out.println("5. Remove Company");
			System.out.println("6. Display Transaction Details");
			System.out.println("7. Display Report");
			System.out.println("8. Exit");
			System.out.println("Enter your choice=");
			choice=utility.inputInteger();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter your Name: ");
				name=utility.inputString(); 
				System.out.println("Enter Initial Money:");
				money=utility.inputLong();
				System.out.println("Enter the Shares: ");
				total_share=utility.inputLong();
				Customer customer = new Customer(name, money, total_share);
				//System.out.println(customer);
				account=new StockAccount(customer);
				System.out.println("Account created");
				break;
			case 2:
				System.out.println("Enter your Name=");
				name=utility.inputString();
				System.out.println("Enter the Symbol of company to buy Shares=");
				symbol=utility.inputString();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.inputLong();
				stockAccount.buy(symbol, noOfShares, name);
				System.out.println("Share buy Successfully");
				break;
			case 3:
				System.out.println("Enter your Name=");
				name=utility.inputString();
				System.out.println("Enter the Symbol of company to buy Shares=");
				symbol=utility.inputString();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.inputLong();
				stockAccount.sell(symbol, noOfShares, name);
				break;
			case 4:
				System.out.println("Enter the Symbol of Company to Add in File=");
				symbol=utility.inputString();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.inputLong();
				System.out.println("Enter Price of Shares");
				priceOfEachShare=utility.inputLong();
				stockAccount.addNewSymbol(symbol, noOfShares, priceOfEachShare);
				break;
			case 5:
				System.out.println("Enter the Symbol of Company to Add in File=");
				symbol=utility.inputString();
				account.removeSymbol(symbol);
				break;
			case 6:
				stockAccount.displayTransactionDetails();
				break;
			case 7:
				stockAccount.displayReport();
				break;
			case 8:
				System.exit(0);
			}
		}
		while(choice > 0);
	}
	
}
