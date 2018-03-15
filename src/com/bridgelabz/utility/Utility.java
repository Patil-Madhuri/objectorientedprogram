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
import java.util.List;

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
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
				@SuppressWarnings("rawtypes")
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
			
					}catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException | ParseException e) {
						// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
		}
		
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch(IOException | ParseException e)
					{
						e.printStackTrace();
					}
			}
			
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
				
			}
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
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
					
				}
				
			}

			
}
