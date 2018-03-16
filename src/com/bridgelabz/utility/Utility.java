package com.bridgelabz.utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

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
		 * @input string
		 */
		public String inputStringLine()
		{
			try
			{
			return scanner.nextLine();
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
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		/** Read data from json file
		 * 
		 */
		@SuppressWarnings("rawtypes")
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
						@SuppressWarnings("unused")
						String key1 = (String)iterator1.next();
					
					}System.out.println();
					System.out.println("Total cost of "+object1.get("name") + " is: "
								+ Double.parseDouble(object1.get("weight").toString())
								* Double.parseDouble(object1.get("price").toString()));
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException | ParseException e) {
				
				e.printStackTrace();
			} 		
		}
		
		static String message="Hello <<Name>>, We have your full name as <<Full Name>> in our system. "
				+ "your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification "
				+ "Thank you BridgeLabz 01/01/2016.";
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
			Date date = new Date();
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
			System.out.println("*****After sort*****");
			   for (String sorted[] : array) 
			   {
			       Arrays.sort(sorted);
			  
			       for (String integer : sorted) 
			       {
			           System.out.println(integer);
			       }
			       System.out.println();
			   }


		}
		
		@SuppressWarnings("unchecked")
		public static void createAccount()  
		{
			File file = new File("UserDetails.json");
			if(file.exists())
			{
				@SuppressWarnings("unused")
				JSONArray arr = new JSONArray();
			
				boolean check= true;
				while (check)
				{	
					System.out.println("Want to add user: y or n");
					char ch = scanner.next().charAt(0); 
					if(ch=='y')
					{	
						try
						{
						FileReader reader = new FileReader(file);
						JSONParser parser = new JSONParser();
						JSONArray array = (JSONArray) parser.parse(reader);
						JSONObject json = new JSONObject();
				        System.out.println("Enter name");
				        String name =scanner.next();
				        System.out.println("Enter balance");
				        int bal = scanner.nextInt();
				        json.put("Name",name);
				        json.put("Balance",bal);
				        json.put("ShareCount", 100);
				    
				        array.add(json);
				      	FileWriter fw = new FileWriter(file);
				        fw.write(JSONArray.toJSONString(array));
				        fw.flush();
				        fw.close();
			
					}catch (FileNotFoundException e) 
						{
						e.printStackTrace();
					} catch (IOException | ParseException e) {
						
						e.printStackTrace();
					} 
					}
					else
					{
						check=false;
					}
				}
				
			}
			else
			{
				System.out.println("File does not exits");
			}
		}
		

		/**
		 * 
		 */
		@SuppressWarnings("unchecked")
		public static void buyShare() 
		{
			File file = new File("UserDetails.json");
			File file1 = new File("StockSymbol.json");
			if (file.exists() && file1.exists()) 
			{
				try 
				{
					FileReader reader1 = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray stock = (JSONArray) parser.parse(reader1);
					// reading share file
	
					FileReader reader = new FileReader(file1);
					JSONParser parser1 = new JSONParser();
					JSONArray share = (JSONArray) parser1.parse(reader);
	
					System.out.println("Enter the user");
					String name = scanner.next();
					Iterator<?> iterator= stock.iterator();
					Iterator<?> iterator2 = share.iterator();
					boolean flag = false;
					while (iterator.hasNext()) {
					JSONObject obj = (JSONObject) iterator.next();
					if (obj.get("Name").equals(name)) 
					{
						System.out.println("Enter the share symbol to buy share:[@,!,#]");
						String symbol =scanner.next();
						
						while (iterator2.hasNext()) 
						{
							JSONObject obj1 = (JSONObject) iterator2.next();
							if (obj1.get("Symbol").equals(symbol)) 
							{
								System.out.println("Enter the amount");
								int amount = scanner.nextInt();
								int balance = Integer.parseInt(obj.get("Balance").toString());
								int price = Integer.parseInt(obj1.get("Price").toString());
								int noShare = Integer.parseInt(obj.get("ShareCount").toString());
								int stockShare = Integer.parseInt(obj1.get("Count").toString());
								int numofshare = amount / price;
								int newbal = balance - amount;
								int sharecountcus = noShare + numofshare;
								int sharecountstock = stockShare - numofshare;
								obj.remove("Balance");
								obj.remove("ShareCount");
								obj1.remove("Count");

								obj.put("Balance", newbal);
								obj.put("ShareCount", sharecountcus);
								obj1.put("Count", sharecountstock);
								Date d = new Date();
								String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
								System.out.println("Date " + date);
								flag = true;
								break;
							}
						}
						
					}
					FileWriter fs = new FileWriter(file);
					fs.write(JSONValue.toJSONString(stock));
					fs.flush();
					fs.close();
				}
				if (flag == false) {
					System.out.println("User name not exits");
				}
				FileWriter fw = new FileWriter(file1);
				fw.write(JSONValue.toJSONString(share));
				fw.flush();
				fw.close();
			}
			 catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException | ParseException e) {
				
				e.printStackTrace();
			} 
			}else {
				System.out.println("File does not exits");
			}
			
		}
		
		
		/**
		 * 
		 */
		@SuppressWarnings("unchecked")
		public static void saleShare() 
		{
			
			File file = new File("UserDetails.json");
			File file1 =new File("StockSymbol.json");
			if(file.exists() && file1.exists())
			{
				// reading stock file
				try {
					FileReader fr = new FileReader(file);
				
				JSONParser parser = new JSONParser();
				JSONArray stock = (JSONArray) parser.parse(fr);
				//reading share file
				
				FileReader reader2 = new FileReader(file1);
				JSONParser parser1 = new JSONParser();
				JSONArray share = (JSONArray) parser1.parse(reader2);
				
				System.out.println("Enter the user");
				String name =scanner.next();
				Iterator<?> itr = stock.iterator();
				Iterator<?> itr1 = share.iterator();
				boolean flag = false;
				while (itr.hasNext())
				{
					JSONObject obj=(JSONObject) itr.next();
					if(obj.get("Name").equals(name))
					{
						System.out.println("Enter the share sysmbol to sale share:[@,!,#]");
						String symbol = scanner.next();
						System.out.println("Enter the number of share to sale");
						int count=scanner.nextInt();
						//obj.put("Share Symbol", sym);
						while(itr1.hasNext())
						{
							JSONObject obj1 = (JSONObject) itr1.next();
							if(obj1.get("Symbol").equals(symbol))
							{	
								int bal =  Integer.parseInt(obj.get("Balance").toString());
								int price = Integer.parseInt(obj1.get("Price").toString());
								int noShare =  Integer.parseInt(obj.get("ShareCount").toString());
								int stockShare = Integer.parseInt(obj1.get("Count").toString());
								int saleprize = count*price;
								int newbal = bal+saleprize;
								int sharecountcus = noShare-count;
								int sharecountstock = stockShare+count;
								obj.remove("Balance");
								obj.remove("ShareCount");
								obj1.remove("Count");
								
								obj.put("Balance",newbal);
								obj.put("ShareCount",sharecountcus);
								obj1.put("Count", sharecountstock);
								Date d = new Date();
								String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
								System.out.println("Date "+date);
								flag = true;
								break;
							}
							
						}
					}

					FileWriter fs = new FileWriter(file);
					fs.write(JSONValue.toJSONString(stock));
					
					fs.flush();
					fs.close();
				}
				if(flag == false)
				{
					System.out.println("User name not exits");
				}
				FileWriter fw = new FileWriter(file1);
				fw.write(JSONValue.toJSONString(share));
				fw.flush();
				fw.close();
			}
			 catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException | ParseException e) {
				
				e.printStackTrace();
			} 
			}
			else
			{
				System.out.println("File Does not exits");
			}
		}
		// Share and Stock report
			/**
			 * @param <E>
			 * @throws IOException
			 * @throws ParseException
			 * display the details
			 */
			@SuppressWarnings("unchecked")
			public static <E> void printReport()  
			{
				File file = new File("UserDetails.json");
				 
				try {
					FileReader reader = new FileReader(file);
				
				JSONParser parser = new JSONParser();
				JSONArray arr1 = (JSONArray) parser.parse(reader);
				Iterator <E>itr = arr1.iterator();
				while (itr.hasNext())
				{
					JSONObject obj = (JSONObject) itr.next();
					System.out.println(obj);
				}
				
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException | ParseException e) {
			
				e.printStackTrace();
			} 
		}
			
			
			@SuppressWarnings("unchecked")
			public static void addPerson()
			{
				String firstname,lastname,address,city,state;
				long contact,zipcode;
				System.out.println("Enter Firstname: ");
				firstname = scanner.next();
				System.out.println("Enter Lastname: ");
				lastname = scanner.next();
				System.out.println("Enter Contact Number: ");
				contact = scanner.nextLong();
				System.out.println("Enter Address: ");
				address = scanner.next();
				System.out.println("Enter City: ");
				city = scanner.next();
				System.out.println("Enter State: ");
				state =scanner.next();
				System.out.println("Enter Zip Code: ");
				zipcode = scanner.nextLong();
				
				try {
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					
					JSONObject person = new JSONObject();
					person.put("firstName", firstname);
					person.put("lastName", lastname);
					person.put("city", city);
					person.put("state", state);
					person.put("zip", zipcode);
					person.put("phoneNumber", contact);
					person.put("address", address);
					//System.out.println(person);
					jsonArray.add(person);
					
					jsonObject.put("address", jsonArray);
					PrintWriter printWriter = new PrintWriter("address.json");
					printWriter.write(jsonObject.toJSONString());
					printWriter.flush();
					printWriter.close();
					System.out.println("person detail added in address book"); 
					
				}
				catch (FileNotFoundException e) 
				{
			
					e.printStackTrace();
				}					
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
			}
			

			@SuppressWarnings("unchecked")
			public static void editDetails()
			{
				int index = 0;
				JSONObject person=new JSONObject();
				boolean present = false;
				System.out.println("enter the name of the person");
				String firstName = utility.inputString();
				
				try 
				{
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					for(int i = 0; i < jsonArray.size();i++)
					{
						 person = (JSONObject) jsonArray.get(i);
						String personFirstName = (String) person.get("firstName");
						if(personFirstName.equals(firstName))
						{
							index = i;
							present = true;
							break;
						}
					}
					if(present)
					{
						
						int choice=0;
						do
						{
							System.out.println("Enter 1 to edit lastName");
							System.out.println("Enter 2 to edit city");
							System.out.println("Enter 3 to edit state");
							System.out.println("Enter 4 to edit zip");
							System.out.println("Enter 5 to edit phoneNumber");
							System.out.println("Enter 6 to edit address");
							System.out.println("Enter 7 to stop editing");
							 choice = utility.inputInteger();
							
							switch (choice) 
							{
							case 1:
								System.out.println("enter the last name");
								String lastName = utility.inputString();
								person.put("lastName", lastName);
								break;
							case 2:
								System.out.println("enter the city");
								String city = utility.inputString();
								person.put("city", city);
								break;
							case 3 :
								System.out.println("enter the state");
								String state = utility.inputString();
								person.put("state", state);
								break;
							case 4:
								System.out.println("enter zip");
								String zip = utility.inputString();
								person.put("zip", zip);
								break;
							case 5 :
								System.out.println("enter phoneNumber");
								String phoneNumber = utility.inputString();
								person.put("phoneNumber", phoneNumber);
								break;
							case 6 : 
								System.out.println("enter address");
								String address = utility.inputStringLine();
								person.put("address", address);
								break;
							default:
								break;
							}
						}
						while(choice > 0);
						jsonArray.set(index, person);
						jsonObject.put("address", jsonArray);
						PrintWriter printWriter = new PrintWriter("address.json");
						printWriter.write(jsonObject.toJSONString());
						printWriter.flush();
						printWriter.close();
						System.out.println("person detail edited");
					}
					else
					{
						System.out.println("person not persent");
					}
				} catch (FileNotFoundException e) {
			
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
		}
		
			@SuppressWarnings("unchecked")
			public static void deleteDetails()
			{
				System.out.println("enter the name of the person to be deleted");
				Utility utility = new Utility();
				String firstName = utility.inputString();
				int index = 0;
				JSONObject person = new JSONObject();
				boolean present = false;
				
				
					try {
						File file = new File("address.json");
						FileReader reader = new FileReader(file);
						JSONParser parser = new JSONParser();
						JSONObject jsonObject =(JSONObject) parser.parse(reader);
						JSONArray jsonArray = (JSONArray) jsonObject.get("address");
						for(int i = 0; i < jsonArray.size();i++)
						{
							 person = (JSONObject) jsonArray.get(i);
							String personFirstName = (String) person.get("firstName");
							if(personFirstName.equals(firstName))
							{
								index = i;
								present = true;
								break;
							}
						}
						if(present)
						{
							jsonArray.remove(index);
							jsonObject.put("address", jsonArray);
							PrintWriter printWriter = new PrintWriter("address.json");
							printWriter.write(jsonObject.toJSONString());
							printWriter.flush();
							printWriter.close();
							System.out.println("person detail deleted");
						}
						else
						{
							System.out.println("person not persent in address book");
						}
					} catch (FileNotFoundException e) 
					{
			
						e.printStackTrace();
					}
					catch(IOException | ParseException e)
					{
						e.printStackTrace();
					}
			}
			
			@SuppressWarnings("unchecked")
			public static void sortByName() 
			{	
				try {
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					JSONObject person1 = new JSONObject();
					JSONObject person2 = new JSONObject();
					String firstName1;
					String firstName2;
					
					for(int i = 0; i < jsonArray.size()-1;i++)
					{
						for(int j = i+1; j< jsonArray.size();j++)
						{
							person1 = (JSONObject) jsonArray.get(i);
							person2 = (JSONObject) jsonArray.get(j);
							firstName1 = (String) person1.get("firstName");
							firstName2 = (String) person2.get("firstName");
							if (firstName1.compareToIgnoreCase(firstName2) >0)
							{
								jsonArray.set(i, person2);
								jsonArray.set(j, person1);
							}
						}
					}
					jsonObject.put("address", jsonArray);
					PrintWriter printWriter = new PrintWriter("address.json");
					printWriter.write(jsonObject.toJSONString());
					printWriter.flush();
					printWriter.close();
					for(int i = 0; i < jsonArray.size(); i++)
					{
						System.out.println(jsonArray.get(i));
					}
				} catch (FileNotFoundException e) {
			
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
				
			}
			@SuppressWarnings("unchecked")
			public static void sortByZip() 
			{

				try {
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					JSONObject person1 = new JSONObject();
					JSONObject person2 = new JSONObject();
					String zip1;
					String zip2;
					long intzip1;
					long intzip2;
					for(int i = 0; i < jsonArray.size()-1;i++)
					{
						for(int j = i+1; j< jsonArray.size();j++)
						{
							person1 = (JSONObject) jsonArray.get(i);
							person2 = (JSONObject) jsonArray.get(j);
							zip1 = (String) person1.get("zip");
							zip2 = (String) person2.get("zip");
							intzip1 = Long.parseLong(zip1);
							intzip2 = Long.parseLong(zip2);
							if(intzip1>intzip2)
							{
								jsonArray.set(i, person2);
								jsonArray.set(j, person1);
							}
						}
					}
					jsonObject.put("address", jsonArray);
					PrintWriter printWriter = new PrintWriter("address.json");
					printWriter.write(jsonObject.toJSONString());
					printWriter.flush();
					printWriter.close();
					for(int i = 0; i < jsonArray.size(); i++)
					{
						System.out.println(jsonArray.get(i));
					}
				} catch (FileNotFoundException e) {
			
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
				
			}
			public static void displayAddressBook()
			{
				try 
				{
				File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					
					for(int i = 0; i < jsonArray.size(); i++)
					{
						System.out.println(jsonArray.get(i));
					}
				} catch (FileNotFoundException e) {
			
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
					
				}
				
			}
			
			
			public static JSONObject readFromJsonFile(String filename)
			{
				Object obj;
				JSONObject jsonObject = null;
				try
				{
					obj = new JSONParser().parse(new FileReader(filename));
					jsonObject = (JSONObject) obj;
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
				
			   
				return jsonObject; 
			}
			public static void printJsonObjectToFile(String fileName, JSONObject jsonObject) 
			{
				PrintWriter printWriter;
				try {
					printWriter = new PrintWriter(fileName);
					printWriter.write(jsonObject.toJSONString());
					printWriter.flush();
					printWriter.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			@SuppressWarnings("unchecked")
			public static void addDoctor() 
			{
				Utility utility = new Utility();
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				boolean itrate = true;
				String id = null;
				boolean idPresent = false;
				
				while(itrate)
				{
					idPresent = false;
					System.out.println("Enter the id of doctor");
				    id = utility.inputString();
					for(int i = 0; i < jsonArrayDoctor.size();i++)
					{
						JSONObject doctorObject = (JSONObject) jsonArrayDoctor.get(i);
						String doctorId = (String) doctorObject.get("id");
						if(doctorId.equals(id))
						{
							idPresent = true;
							System.out.println("This id is use by another doctor use different one");
							break;
						}
					}
					if(!idPresent)
					{
						itrate = false;
					}
				}
				System.out.println("Enter the name of doctor");
				String doctorName = utility.inputString();
				System.out.println("Enter the specialization of doctor");
				String doctorSpecialization = utility.inputString();
				System.out.println("Enter availability of doctor");
				System.out.println("You can only enter one choice out of three");
				System.out.println("AM if doctor is present in morning");
				System.out.println("PM if doctor is present in evening");
				System.out.println("Both if doctor is present both the time");
				String availability = utility.inputString();
				JSONObject newDoctorObject = new JSONObject();
				
				JSONObject appointment = readFromJsonFile("appoinment.json");
				appointment.put(id, new JSONObject());
				newDoctorObject.put("id", id);
				newDoctorObject.put("name", doctorName);
				newDoctorObject.put("specialization", doctorSpecialization);
				newDoctorObject.put("availability", availability);
				jsonArrayDoctor.add(newDoctorObject);
				jsonObjectDoctor.put("doctor", jsonArrayDoctor);
				printJsonObjectToFile("addDoctor.json", jsonObjectDoctor);
				printJsonObjectToFile("appoinment.json", appointment);
				System.out.println("Doctor Added");
				
				}
			@SuppressWarnings("unchecked")
			public static void addPatients() 
			{
				Utility utility = new Utility();
				JSONObject jsonObjectPatients = readFromJsonFile("addPatient.json");
				JSONArray jsonArraypatients = (JSONArray) jsonObjectPatients.get("patients");
				boolean itrate = true;
				String id = null;
				boolean idPresent = false;
				
				while(itrate)
				{
					idPresent = false;
					System.out.println("Enter the id of patients");
				    id = utility.inputString();
					for(int i = 0; i < jsonArraypatients.size();i++)
					{
						JSONObject patientsObject = (JSONObject) jsonArraypatients.get(i);
						String patientsId = (String) patientsObject.get("id");
						if(patientsId.equals(id))
						{
							idPresent = true;
							System.out.println("This id is use by another patients use diffrent one");
							break;
						}
					}
					if(!idPresent)
					{
						itrate = false;
					}
				}
				System.out.println("Enter the name of patients");
				String Name = utility.inputString();
				System.out.println("Enter the mobil number of patients");
				String mobilNumber = utility.inputString();
				System.out.println("Enter the age of patients");
				String age = utility.inputString();
				JSONObject newpatientsObject = new JSONObject();
				newpatientsObject.put("id", id);
				newpatientsObject.put("name", Name);
				newpatientsObject.put("mobilNumber", mobilNumber);
				newpatientsObject.put("age", age);
				jsonArraypatients.add(newpatientsObject);
				jsonObjectPatients.put("patients", jsonArraypatients);
				printJsonObjectToFile("addPatient.json", jsonObjectPatients);
				System.out.println("Patient Added");
			}
			public static void serachAndbookdoctor(JSONObject pateint) 
			{
				Utility utility = new Utility();
				System.out.println("1 search doctor by name");
				System.out.println("2 search doctor by id");
				System.out.println("3 search doctor by specialization");
				int choise = utility.inputInteger();
				switch (choise) 
				{
				case 1:
				System.out.println("Enter the name of the doctor");	
				serachDoctorByName(utility.inputString(),pateint);
					break;
				case 2:
					System.out.println("Enter the id of doctor");
					serachDoctorById(utility.inputString(), pateint);
					break;
				case 3:
					System.out.println("Enter the specilization of doctor");
					serachDoctorBySpecialization(utility.inputString(), pateint);
					break;

				default:
					break;
				}
			}
			public static void serachDoctorBySpecialization(String doctorSpecialization,JSONObject pateint) 
			{
				ArrayList<JSONObject> doctorList = new ArrayList<>();
				Utility utility = new Utility();
				JSONObject doctor = null;
				boolean doctorPresent = false;
				JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String specialization = (String) doctor.get("specialization");
					if(specialization.equals(doctorSpecialization))
					{
						doctorPresent = true;
						doctorList.add(doctor);
					}	
				}
				if(doctorPresent)
				{
					System.out.println("List of doctor for " + doctorSpecialization);
					for(int i = 0; i< doctorList.size();i++)
					{
						System.out.println(doctorList.get(i));
					}
					System.out.println("Enter the id of one doctor from above list");
					String doctorId = utility.inputString();
					System.out.println("1 to see doctor is avalable on specific date or not");
					System.out.println("or any thing else to go back");
					int chosie = utility.inputInteger();
					switch (chosie) 
					{
					case 1:
						checkavalbilityOfdocterbyId(doctorId,pateint);
						break;
					default:
						break;
					}
				}
				else
				{
					System.out.println("The doctor you searched is not avaliable");
				}
			}

			@SuppressWarnings("unused")
			public static void serachDoctorById(String doctorId,JSONObject pateint) 
			{
				Utility utility = new Utility();
				JSONObject doctor = null;
				int index = 0;
				boolean doctorPresent = false;
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String id = (String) doctor.get("id");
					if(id.equals(doctorId))
					{
						doctorPresent = true;
						index = i;
						break;
					}	
				}
				if(doctorPresent)
				{
					System.out.println(doctor);
					System.out.println();
					System.out.println("1 to see doctor is avalable on specific date or not");
					System.out.println("or any thing else to go back");
					int choice = utility.inputInteger();
					switch (choice) 
					{
					case 1:
						checkavalbilityOfdocterbyId(doctorId,pateint);
						break;
					default:
						System.out.println("Invalid choice");
					}
				}
				else
				{
					System.out.println("The doctor you serched is not avaliable");
				}
			}
			@SuppressWarnings("unused")
			public static void serachDoctorByName(String doctorName,JSONObject pateint) 
			{
				Utility utility = new Utility();
				JSONObject doctor = null;
				
				boolean doctorPresent = false;
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String name = (String) doctor.get("name");
					if(name.equals(doctorName))
					{
						doctorPresent = true;
						
						break;
					}	
				}
				if(doctorPresent)
				{
					String doctorId = (String) doctor.get("id");
					System.out.println(doctor);
					System.out.println();
					System.out.println(" 1 to see doctor is avalable on specific date or not");
					System.out.println("or any thing else to go back");
					int choice = utility.inputInteger();
					switch (choice) 
					{
					case 1:
						checkavalbilityOfdocterbyId(doctorId,pateint);
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}
				else
				{
					System.out.println("The doctor you searched is not avaliable");
				}
			}
			@SuppressWarnings({ "unchecked", "unused" })
			static void checkavalbilityOfdocterbyId(String id,JSONObject patient) 
			{
				boolean avaliable = false;
				Utility utility = new Utility();
				System.out.println("enter the date in format of DDMMYYYY");
				String date = utility.inputString();
				JSONObject jsonObjectappointment = readFromJsonFile("appoinment.json");
				JSONObject jsonObjectforId = (JSONObject) jsonObjectappointment.get(id);
				if(jsonObjectforId.get(date) == null)
				{
					System.out.println("Doctor is available enter 1 to book on that date");
					int choice = utility.inputInteger();
					switch (choice) 
					{
					case 1:
						JSONArray patentarray = new JSONArray();
						patentarray.add(patient);
						jsonObjectforId.put(date, patentarray);
						jsonObjectappointment.put(id, jsonObjectforId);
						printJsonObjectToFile("appoinment.json", jsonObjectappointment);
						System.out.println("Your appointment is fixed");
						break;
					default:
						System.out.println("Invalid choice");
						
					}
				}
				else
				{
					JSONArray oldpatientarray = (JSONArray) jsonObjectforId.get(date);
					if(oldpatientarray.size()<5)
					{
						System.out.println("Doctor avaliable on that day enter 1 to book on that day");
						System.out.println("or Enter any other number to go back");
						int choice = utility.inputInteger();
						switch (choice) 
						{
						case 1:
							oldpatientarray.add(patient);
							jsonObjectforId.put(date, oldpatientarray);
							jsonObjectappointment.put(id, jsonObjectforId);
							printJsonObjectToFile("appointment.json", jsonObjectappointment);
							System.out.println("your appointment is fixed");
							break;

						default:
							System.out.println("Invalid choice");
						}
					}
					else
					{
						System.out.println("Doctor is booked on that date try different date");
					}
				}
			}
			public static void searchPatient() 
			{
				ArrayList<JSONObject> arrayListPatient = new ArrayList<>();
				boolean patientPresent = false;
				JSONObject jsonObjectpatient = readFromJsonFile("addPatient.json");
				JSONArray jsonArraypatient = (JSONArray) jsonObjectpatient.get("patients");
				Utility utility = new Utility();
				JSONObject patient = null;
				System.out.println(" 1 to search patient by name");
				System.out.println(" 2 to search patient by id");
				System.out.println(" 3 to search patient by contact number");
				int choise = utility.inputInteger();
				switch (choise) {
				case 1:
					System.out.println("Enter the patient name");
					String name = utility.inputString();
					for(int i = 0; i < jsonArraypatient.size();i++)
					{
						patient = (JSONObject) jsonArraypatient.get(i);
						String patientName = (String) patient.get("name");
						if(name.equals(patientName))
						{
							patientPresent = true;
							arrayListPatient.add(patient);
						}
					}
					if(patientPresent)
					{
						System.out.println("Name of Patient " + name);
						for(int i =0; i < arrayListPatient.size();i++)
						{
							System.out.println(arrayListPatient.get(i));
						}
					}
					else
					{
						System.out.println("Name of patient = "+name+"doesn't exist" );
					}
					break;
				case 2:
					System.out.println("Enter the patient id");
					String id = utility.inputString();
					for(int i = 0; i < jsonArraypatient.size();i++)
					{
						patient = (JSONObject)  jsonArraypatient.get(i);
						String patientid = (String) patient.get("id");
						if(id.equals(patientid))
						{
							patientPresent = true;
							break;
						}
					}
					if(patientPresent)
					{
						System.out.println(patient);
					}
					else
					{
						System.out.println("Patient with id = "+id + "not exist");
					}
					break;
				case 3:
					System.out.println("Enter the patient mobile number");
					String mobilNumber = utility.inputString();
					for(int i = 0;i<jsonArraypatient.size();i++)
					{
						patient = (JSONObject) jsonArraypatient.get(i);
						String patientMobilNumber = (String) patient.get("mobilNumber");
						if(mobilNumber.equals(patientMobilNumber))
						{
							patientPresent = true;
							arrayListPatient.add(patient);
						}
					}
					if(patientPresent)
					{
						for(int i = 0; i < arrayListPatient.size();i++)
						{
							System.out.println(arrayListPatient.get(i));
						}
					}
					else
					{
						System.out.println("patient with mobil number = " + mobilNumber + "not present");
					}
				default:
					break;
				}
			}
			@SuppressWarnings("rawtypes")
			public static void bestDoctor() 
			{
				HashMap<String, Integer> doctorsPatientCount = new HashMap<>();
				JSONObject jsonObjectappointment = readFromJsonFile("appoinment.json");
				Set keyOfappointment = jsonObjectappointment.keySet();
				Iterator iter = keyOfappointment.iterator();
				while(iter.hasNext())
				{
					int countOfPatient = 0;
					String idOfDoctor = (String) iter.next();
					JSONObject jsonObjectOfId = (JSONObject) jsonObjectappointment.get(idOfDoctor);
					if(jsonObjectOfId.isEmpty())
					{
						countOfPatient = 0;
					}
					else
					{
						Set keyOfDate = jsonObjectOfId.keySet();
						Iterator iter1 = keyOfDate.iterator();
						while(iter1.hasNext())
						{
							String date = (String) iter1.next();
							JSONArray jsonArrayDate = (JSONArray) jsonObjectOfId.get(date);
							countOfPatient +=jsonArrayDate.size();
						}
					}
					doctorsPatientCount.put(idOfDoctor, countOfPatient);
				}
				
				String maxKey = "";
				 int maxValueInMap=(Collections.max(doctorsPatientCount.values()));
				 for (Entry<String, Integer> entry : doctorsPatientCount.entrySet()) 
				 {
			         if (entry.getValue()==maxValueInMap) 
			         {
			        	 maxKey = entry.getKey();
			         }
				 }
				 JSONObject bestdoctoerDetails = getDocterDetailsById(maxKey);
				 System.out.println("Best doctor of clinique details");
				 System.out.println(bestdoctoerDetails);
			}
			public static JSONObject getDocterDetailsById(String doctorId) 
			{
				JSONObject doctor = null;
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String id = (String) doctor.get("id");
					if(id.equals(doctorId))
					{
						return doctor;
					}	
				}
				return null;
			}
			@SuppressWarnings("rawtypes")
			public static void doctorPatientList() 
			{
				JSONObject jsonObjectappointment = readFromJsonFile("appoinment.json");
				Set keyOfappointment = jsonObjectappointment.keySet();
				Iterator iter = keyOfappointment.iterator();
				while(iter.hasNext())
				{
					String idOfDoctor = (String) iter.next();
					System.out.println("doctor details");
					System.out.println(getDocterDetailsById(idOfDoctor));
					System.out.println("------------------------------");
					System.out.println("patient details");
					JSONObject jsonObjectOfId = (JSONObject) jsonObjectappointment.get(idOfDoctor);
					if(jsonObjectOfId.isEmpty())
					{
						System.out.println("have no patient associated with them");
						
					}
					else
					{
						Set keyOfDate = jsonObjectOfId.keySet();
						Iterator iter1 = keyOfDate.iterator();
						
						System.out.println("have following patient associated to it");
						while(iter1.hasNext())
						{
							String date = (String) iter1.next();
							JSONArray jsonArrayDate = (JSONArray) jsonObjectOfId.get(date);
							for(int i = 0; i < jsonArrayDate.size();i++)
							{
								System.out.println(jsonArrayDate.get(i));
							}
						}
					}
					System.out.println();
					System.out.println();
					System.out.println("*************************************************");
				}
			}
}