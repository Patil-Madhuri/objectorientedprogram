package com.bridgelabz.utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.program.CardQueue;

public class Utility 
{
		static Scanner scanner;
		static Utility utility = new Utility();
		public Utility() 
		{
			scanner = new Scanner(System.in);
		}
	
		/**
		 * @input string
		 */
		public String inputString()
		{
			try
			{
			return scanner.next();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return "";
		}
		
		/**
		 * @input integer
		 */
		public int inputInteger()
		{
			try
			{
				return scanner.nextInt();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return 0;
		}
		
		/**
		 * input double
		 */
		public double inputDouble()
		{
			try
			{
				return scanner.nextDouble();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return 0.0;
		}
		
		/**
		 * input long
		 */
		public long inputLong()
		{
			try
			{
				scanner.nextLong();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return 0;
		}
		
		/**
		 * write data in json file
		 */
		@SuppressWarnings("unchecked")
		public static void writeData()
		{
			File file = new File("inventory.json");
			try {
				FileWriter writer = new FileWriter(file);
				JSONObject object1 = new JSONObject();
				JSONObject object2 = new JSONObject();
				JSONObject object3 = new JSONObject();
				String name;
				double weight,price;
				//input for rice
				System.out.println("Enter the name of rice: ");
				name = scanner.next();
				System.out.println("Enter the weight of rice: ");
				weight = scanner.nextDouble();
				System.out.println("Enter the price of rice: ");
				price = scanner.nextDouble();
				object1.put("name", name);
				object1.put("weight", weight);
				object1.put("price", price);
				//System.out.println(object1);
				
				//input for pulses
				System.out.println("Enter the name of pulse: ");
				name = scanner.next();
				System.out.println("Enter the weight of pulse: ");
				weight =scanner.nextDouble();
				System.out.println("Enter the price of pulse: ");
				price =scanner.nextDouble();
				object2.put("name", name);
				object2.put("weight", weight);
				object2.put("price", price);
				//System.out.println(object2);
				
				//input for wheats
				System.out.println("Enter the name of wheats: ");
				name = scanner.next();
				System.out.println("Enter the weight of wheats: ");
				weight = scanner.nextDouble();
				System.out.println("Enter the price of wheats: ");
				price =scanner.nextDouble();
				object3.put("name", name);
				object3.put("weight", weight);
				object3.put("price", price);
				//System.out.println(object3);
				JSONObject items = new JSONObject();
				items.put("rice", object1);
				items.put("pulse", object2);
				items.put("wheat", object3);
				
				writer.write(JSONValue.toJSONString(items));
				
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/** Read data from json file
		 * 
		 */
		public static void readData()
		{
			File file = new File("inventory.json");
			try {
				FileReader reader = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONObject object =(JSONObject) parser.parse(reader);
				Iterator iterator = object.keySet().iterator();
				while(iterator.hasNext())
				{
					String key = (String)iterator.next();
					JSONObject object1 = (JSONObject) object.get(key);
					Iterator iterator1 = object.keySet().iterator();
					while(iterator1.hasNext())
					{
						String key1 = (String)iterator1.next();
					
					}System.out.println();
					System.out.println("Total cost of "+object1.get("name") + " is: "
								+ Double.parseDouble(object1.get("weight").toString())
								* Double.parseDouble(object1.get("price").toString()));
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		static String message="Hello <<Name>>, We have your full name as <<Full Name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		static String fName;
		static String lName;
		static String mNumber="0";
		static String date;

		public static void setFirstName() 
		{
			System.out.println("Enter The First Name :");
			fName=scanner.next();

			while(!iscontainNumber(fName))
			{
				System.out.println("Invalid First Name");
				System.out.println("Please enter name again");
				fName=scanner.next();
			}

		}

		public static void setLastName()
		{
			System.out.println("Enter The Last Name :");
			lName=scanner.next();
			
			while(!iscontainNumber(lName))
			{
				System.out.println("Invalid Last Name");
				System.out.println("Please enter name again");
				lName=scanner.next();
			}
		}


		public static void setMobileNumber() 
		{
			System.out.println("Enter The Mobile Number :");
			mNumber=scanner.next();
			while (!isTenDigit(mNumber)) 
			{
				System.out.println("Invalid mobile number");
				System.out.println("Please enter number again");
				mNumber = scanner.next();
			}
		}
	

		public static void setDate() 
		{
			Date date = new Date(0);
			String d = new SimpleDateFormat().format(date);
			String d1[] = d.split(" ");
			
			message = message.replace("01/01/2016", d1[0]);

		}
		//is ten digits validation System.out.println();
		public static boolean isTenDigit(String number)
		{
			String matcher="^[0-9]+$";
			if((number.matches(matcher))){
				return true;
				
			}
			return false;
		}

		public static boolean iscontainNumber(String name) 
		{
			if(name.matches("[a-zA-Z]+\\.?"))
			{
				return true ;
			}
			else
			{
				return false;
			}
			
		}

		public static String RegexReplace()
		{System.out.println();
			String firstName="<<Name>>";
			String fullName="<<Full Name>>";
			String mobileno="xxxxxxxxxx" ;
			String Date="12/02/2018";

			//Regex to replace first Name 
			Pattern pattern = Pattern.compile(firstName);
			Matcher matcher = pattern.matcher(message);
			message=matcher.replaceAll(fName); 
			System.out.println();
			//Regex to replace full Name
			pattern = Pattern.compile(fullName);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(fName+" "+lName);

			//Regex to replace mobile number
			pattern = Pattern.compile(mobileno);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(mNumber);	
			System.out.println();
			Date date = new Date(0);
			String temp = date.toString();
			//Regex to replace Date
			pattern = Pattern.compile(Date);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(temp);
			return message;
		}
		
		@SuppressWarnings("unchecked")
		public static void stockReport()
		{
			JSONArray jsonArray = new JSONArray();
			
			System.out.println("Enter Number of company");
			int number = utility.inputInteger();
			String[] array = new String[number];
			int share[] = new int[number];
			int amount[] = new int[number];System.out.println();
			int total[] = new int[number];
			System.out.println("Enter company name");
			int totalStock=0;
			for(int i=0; i<number; i++)
			{

				array[i] = utility.inputString();
			}


			for(int i=0; i<number; i++)
			{
				System.out.println("Enter the number of shares for "+array[i]+" and share amount");
				share[i] = utility.inputInteger();
				amount[i] =utility.inputInteger();
			}
			for(int i=0; i<number; i++){
				total[i] = share[i]*amount[i];
			}System.out.println();
			System.out.println();
			System.out.println("*******************Stock Report**************************");
			System.out.println();
			System.out.println("Company Name\tShares\tPrice\ttotal of each");
			System.out.println();
			PrintWriter printWriter =null;
			try {
				printWriter = new PrintWriter("StockReport.json");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i=0; i<number; i++)
			{
				System.out.println("\t"+array[i]+"\t"+share[i]+"\t"+amount[i]+"\t"+total[i]+"/-");	
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("Company Name",array[i]);
				jsonObject.put("Shares",share[i]);
				jsonObject.put("Price",amount[i]);
				jsonObject.put("total",total[i]);
				jsonArray.add(jsonObject);
				
				
			}	
			
			printWriter.write(jsonArray.toJSONString());
			printWriter.flush();
			printWriter.close();
			System.out.println();
			for(int i=0; i<number; i++){

				totalStock+= share[i]*amount[i];
			}
			System.out.println("Total stock is: "+totalStock);
		}
		
		/** deck of cards
		 * @param suits
		 * @param rank
		 */
		public static void deckOfCards(String suits[],String rank[])
		{
			int lengthOfCards = suits.length * rank.length;
			String deck[] = new String[lengthOfCards];
			int i,j;
			for(i=0;i<rank.length;i++)
			{
				for(j=0;j<suits.length;j++)
				{
					deck[suits.length * i + j]=rank[i]+" of " +suits[j];
					
				}
			}
			
			for(i=0;i<lengthOfCards;i++)
			{
				int r = i + (int) (Math.random() * (lengthOfCards - i));
				String temp = deck[r];
				deck[r] = deck[i];
				deck[i]=temp;
			}
			
			String array[][] = new String[suits.length][9];
			for(i=0;i<suits.length;i++)
			{
				System.out.println("**********Player"+(i+1)+"**********");
				for(j=0;j<9;j++)
				{
					array[i][j] = deck[i+j];
					System.out.println(array[i][j]);
				}
				System.out.println();
			}
		}
		
		/**
		 * deck of cards using queue
		 * @param suits
		 * @param rank
		 */
		public static void deckOfCardsQueue(String suits[], String rank[])
		{
			CardQueue cardqueue = new CardQueue();
			int lengthOfCards = suits.length * rank.length;
			String deck[] = new String[lengthOfCards];
			int i,j;
			for(i=0;i<rank.length;i++)
			{
				for(j=0;j<suits.length;j++)
				{
					deck[suits.length * i + j]=rank[i]+" of " +suits[j];
					
				}
			}
			
			for(i=0;i<lengthOfCards;i++)
			{
				int r = i + (int) (Math.random() * (lengthOfCards - i));
				String temp = deck[r];
				deck[r] = deck[i];
				deck[i]=temp;
			}
			
			String array[][] = new String[suits.length][9];
			for(i=0;i<suits.length;i++)
			{
				System.out.println("**********Player"+(i+1)+"**********");
				for(j=0;j<9;j++)
				{
					array[i][j] = deck[i+j];
					cardqueue.push(array[i][j]);
				}
				System.out.println();
			}
		}
}
