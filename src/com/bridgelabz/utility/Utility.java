package com.bridgelabz.utility;
/*************************************************************************
 * @purpose Object oriented programs Utility class
 * @author  Madhuri Chaudhari
 * @version 1.0
 * @since 14/03/2018
 *************************************************************************/
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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.datastructure.LinkedList1;

import com.bridgelabz.program.Queue;
import com.bridgelabz.program.Stack;
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
				return scanner.nextLong();
			}
			catch(Exception e)
			{
				e.printStackTrace();
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
				String lName;
				double lWeight,lPrice;
				//input for rice
				System.out.println("Enter the name of rice: ");
				lName = scanner.next();
				System.out.println("Enter the weight of rice: ");
				lWeight = scanner.nextDouble();
				System.out.println("Enter the price of rice: ");
				lPrice = scanner.nextDouble();
				object1.put("name", lName);
				object1.put("weight", lWeight);
				object1.put("price", lPrice);
				//System.out.println(object1);
				
				//input for pulses
				System.out.println("Enter the name of pulse: ");
				lName = scanner.next();
				System.out.println("Enter the weight of pulse: ");
				lWeight =scanner.nextDouble();
				System.out.println("Enter the price of pulse: ");
				lPrice =scanner.nextDouble();
				object2.put("name", lName);
				object2.put("weight", lWeight);
				object2.put("price", lPrice);
				//System.out.println(object2);
				
				//input for wheats
				System.out.println("Enter the name of wheats: ");
				lName = scanner.next();
				System.out.println("Enter the weight of wheats: ");
				lWeight = scanner.nextDouble();
				System.out.println("Enter the price of wheats: ");
				lPrice =scanner.nextDouble();
				object3.put("name", lName);
				object3.put("weight", lWeight);
				object3.put("price", lPrice);
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
				JSONObject object =Utility.readFromJsonFile("inventory.json");
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
					
					}

					System.out.println("Total cost of "+object1.get("name") + " is: "
								+ Double.parseDouble(object1.get("weight").toString())
								* Double.parseDouble(object1.get("price").toString()));
				}
					
		}
		
		static String message="Hello <<Name>>, We have your full name as <<Full Name>> in our system. "
				+ "your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification "
				+ "Thank you BridgeLabz 01/01/2016.";
		static String mFName;
		static String mLName;
		static String mNumber="0";
		static String mDate;

		/**
		 *  set the <<name>> instead of username in the message string
		 */
		public static void setFirstName() 
		{
			System.out.println("Enter The First Name :");
			mFName=scanner.next();

			while(!iscontainNumber(mFName))
			{
				System.out.println("Invalid First Name");
				System.out.println("Please enter name again");
				mFName=scanner.next();
			}

		}

		/**
		 * set the <<full name>> instead of user full name in the message string
		 */
		public static void setLastName()
		{
			System.out.println("Enter The Last Name :");
			mLName=scanner.next();
			
			while(!iscontainNumber(mLName))
			{
				System.out.println("Invalid Last Name");
				System.out.println("Please enter name again");
				mLName=scanner.next();
			}
		}


		/**
		 * set the <<mobile number>> instead of user mobile number in the message string
		 */
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
	

		/**
		 * set the <<date>> instead of current date in the message string
		 */
		public static void setDate() 
		{
			Date date = new Date();
			String d = new SimpleDateFormat().format(date);
			String d1[] = d.split(" ");
			
			message = message.replace("01/01/2016", d1[0]);

		}
		//is ten digits validation for the mobile number
		public static boolean isTenDigit(String number)
		{
			String matcher="\\d{10}";
			if((number.matches(matcher)))
			{
				return true;
				
			}
			return false;
		}

		//validation for the name that name does not number
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

		/**
		 * @return
		 * replace using Regex
		 */
		public static String RegexReplace()
		{
			String firstName="<<Name>>";
			String fullName="<<Full Name>>";
			String mobileno="xxxxxxxxxx" ;
			String Date="12/02/2018";

			//Regex to replace first Name 
			Pattern pattern = Pattern.compile(firstName);
			Matcher matcher = pattern.matcher(message);
			message=matcher.replaceAll(mFName); 
			System.out.println();
			//Regex to replace full Name
			pattern = Pattern.compile(fullName);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(mFName+" "+mLName);

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
		
		/**
		 *  printing the stock report
		 */
		@SuppressWarnings("unchecked")
		public static void stockReport()
		{
			JSONArray jsonArray = new JSONArray();
			
			System.out.println("Enter Number of company");
			int lNumber = utility.inputInteger();
			String[] array = new String[lNumber];
			int share[] = new int[lNumber];
			int amount[] = new int[lNumber];System.out.println();
			int total[] = new int[lNumber];
			System.out.println("Enter company name");
			int totalStock=0;
			for(int i=0; i<lNumber; i++)
			{

				array[i] = utility.inputString();
			}

			for(int i=0; i<lNumber; i++)
			{
				System.out.println("Enter the number of shares for "+array[i]+" and share amount");
				share[i] = utility.inputInteger();
				amount[i] =utility.inputInteger();
			}
			for(int i=0; i<lNumber; i++)
			{
				total[i] = share[i]*amount[i];
			}
			
			System.out.println("\n\n*******************Stock Report**************************");
			
			System.out.println("\n\nCompany Name\tShares\tPrice\ttotal of each");
			try 
			{
				PrintWriter	printWriter = new PrintWriter("StockReport.json");
				for(int i=0; i<lNumber; i++)
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
			for(int i=0; i<lNumber; i++)
			{

				totalStock+= share[i]*amount[i];
			}
			System.out.println("Total stock is: "+totalStock);
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		}
		
		public static void printCardsOfPlayers(ArrayList<String[]> arrayList)
		{
			String[] array = arrayList.get(0);
			System.out.println("*****Player 1*****");
			for(int i = 0; i < 9; i++)
			{
				System.out.println(array[i]);
			}
			System.out.println();
			System.out.println("*****Player 2*****");
			array = arrayList.get(1);
			for(int i = 0; i < 9; i++)
			{
				 System.out.println(array[i]);
			}
			System.out.println();
			System.out.println("*****Player 3*****");
			array = arrayList.get(2);
			for(int i = 0; i < 9; i++)
			{
				System.out.println(array[i]);
			}
			System.out.println();
			System.out.println("*****Player 4*****");
			array = arrayList.get(3);
			for(int i = 0; i < 9; i++)
			{
				System.out.println(array[i]);
			}
		}
		
		/**
		 * @return arraylist haveing four string[] array each storing players of cards
		 */
		public static ArrayList<String[]> deckOfCards()
		{
			String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
			String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
			
			String[] player1 = new String[9];
			String[] player2 = new String[9];
			String[] player3 = new String[9];
			String[] player4 = new String[9];
			
			String[][] doubleCheck = new String[4][9];
			Random random = new Random();
			int lMin = 0;
			int lRow = 0;
			int lColumn = 0;
			int indexOfPlayer = 0;
			boolean player1Chance = true;
			boolean player2Chance = false;
			boolean player3Chance = false;
			boolean player4Chance = false;
			
			while(indexOfPlayer < 9)
			{
				while(player1Chance)
				{
					lRow = lMin + random.nextInt(4);
					lColumn = lMin + random.nextInt(9);
					if(doubleCheck[lRow][lColumn]== null)
					{
						player1[indexOfPlayer]=rank[lColumn] + " of " + suits[lRow];
						doubleCheck[lRow][lColumn] = "present";
						player2Chance = true;
						player1Chance = false;
					}
				}
				while(player2Chance)
				{
					lRow = lMin + random.nextInt(4);
					lColumn = lMin + random.nextInt(9);
					if(doubleCheck[lRow][lColumn] == null)
					{
						player2[indexOfPlayer] = rank[lColumn] + " of " + suits[lRow];
						doubleCheck[lRow][lColumn] = "present";
						player3Chance = true;
						player2Chance = false;
					}
				}
				while(player3Chance)
				{
					lRow = lMin + random.nextInt(4);
					lColumn = lMin + random.nextInt(9);
					if(doubleCheck[lRow][lColumn] == null)
					{
						player3[indexOfPlayer] = rank[lColumn] + " of " + suits[lRow];
						doubleCheck[lRow][lColumn] = "present";
						player4Chance = true;
						player3Chance = false;
					}
				}
				while(player4Chance)
				{
					lRow = lMin + random.nextInt(4);
					lColumn = lMin + random.nextInt(9);
					if(doubleCheck[lRow][lColumn] == null)
					{
						player4[indexOfPlayer++] = rank[lColumn] + " of " + suits[lRow];
						doubleCheck[lRow][lColumn] = "present";
						player1Chance = true;
						player4Chance = false;
					}
				}	
			}
			ArrayList<String[]> arrayList = new ArrayList<>();
			arrayList.add(player1);
			arrayList.add(player2);
			arrayList.add(player3);
			arrayList.add(player4);
			return arrayList;
		 }
		
		/**
		 * @return return the array having cards of four player in sequence
		 */
		public static ArrayList<String[]> cardsInSequence()
		{
			ArrayList<String[]> arrayList = deckOfCards();
			ArrayList<String[]> swapList = new ArrayList<>();
			int[][] cardsIndex = new int[4][13];
			for(int i = 0; i < 4; i++)
			{
				String[] array = arrayList.get(i);
				for(int j = 0; j < 13; j++)
				{
					String cards = array[j];
					String cardRank = cards.substring(0, cards.indexOf(" "));
					if(cardRank.equals("2"))
					{
						cardsIndex[i][j] = 2; 
					}
					else if(cardRank.equals("3"))
					{
						cardsIndex[i][j] = 3;
					}
					else if(cardRank.equals("4"))
					{
						cardsIndex[i][j] = 4;
					}
					else if(cardRank.equals("5"))
					{
						cardsIndex[i][j] = 5;
					}
					else if(cardRank.equals("6"))
					{
						cardsIndex[i][j] = 6;
					}
					else if(cardRank.equals("7"))
					{
						cardsIndex[i][j] = 7;
					}
					else if(cardRank.equals("8"))
					{
						cardsIndex[i][j] = 8;
					}
					else if(cardRank.equals("9"))
					{
						cardsIndex[i][j] = 9;
					}
					else if(cardRank.equals("10"))
					{
						cardsIndex[i][j] = 10;
					}
					else if(cardRank.equals("Jack"))
					{
						cardsIndex[i][j] = 11;
					}
					else if(cardRank.equals("Queen"))
					{
						cardsIndex[i][j] = 12;
					}
					else if(cardRank.equals("King"))
					{
						cardsIndex[i][j] = 13;
					}
					else
					{
						cardsIndex[i][j] = 1;
					}
				}
			}
			for(int k = 0; k< 4; k++)
			{
				String[] cardsOfPlayer = arrayList.get(k);
				for(int i = 0;i<12;i++)
				{
					for(int j = i +1; j < 13; j++)
					{
						if(cardsIndex[k][i]>cardsIndex[k][j])
						{
							int temp = cardsIndex[k][i];
							cardsIndex[k][i] = cardsIndex[k][j];
							cardsIndex[k][j] = temp;
							
							String temp1 = cardsOfPlayer[i];
							cardsOfPlayer[i] = cardsOfPlayer[j];
							cardsOfPlayer[j] = temp1;
						}
					}
				}
				swapList.add(cardsOfPlayer);
			}
		return swapList;	
		}

			/**
			 *  Add person details in address book
			 */
			@SuppressWarnings("unchecked")
			public static void addPerson()
			{
				String lFirstName,lLastName,lAddress,lCity,lState;
				String lContact;
				long lZipcode;
				System.out.println("Enter Firstname: ");
				lFirstName = scanner.next();
				System.out.println("Enter Lastname: ");
				lLastName = scanner.next();
				System.out.println("Enter Contact Number: ");
				lContact = scanner.next();
				while (!isTenDigit(lContact)) 
				{
					System.out.println("Invalid mobile number");
					System.out.println("Please enter number again");
					lContact = scanner.next();
				}
				System.out.println("Enter Address: ");
				lAddress = scanner.next();
				System.out.println("Enter City: ");
				lCity = scanner.next();
				System.out.println("Enter State: ");
				lState =scanner.next();
				System.out.println("Enter Zip Code: ");
				lZipcode = scanner.nextLong();
				
				try 
				{
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					
					JSONObject person = new JSONObject();
					person.put("firstName", lFirstName);
					person.put("lastName", lLastName);
					person.put("city", lCity);
					person.put("state", lState);
					person.put("zip", lZipcode);
					person.put("phoneNumber", lContact);
					person.put("address", lAddress);
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
			

			/**
			 * Edit person details in address book 
			 */
			@SuppressWarnings("unchecked")
			public static void editDetails()
			{
				int lIndex = 0;
				JSONObject person=new JSONObject();
				boolean isPresent = false;
				System.out.println("enter the name of the person");
				String lFirstName = utility.inputString();
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
						if(personFirstName.equals(lFirstName))
						{
							lIndex = i;
							isPresent = true;
							break;
						}
					}
					if(isPresent)
					{						
						int lChoice=0;
						do
						{
							System.out.println("1 Edit lastName");
							System.out.println("2 Edit city");
							System.out.println("3 Edit state");
							System.out.println("4 Edit zip code");
							System.out.println("5 Edit phoneNumber");
							System.out.println("6 Edit address");
							System.out.println("7 Stop editing");
							lChoice = utility.inputInteger();
							
							switch (lChoice) 
							{
							case 1:
								System.out.println("enter the last name");
								String lLastName = utility.inputString();
								person.put("lastName", lLastName);
								break;
							case 2:
								System.out.println("enter the city");
								String lCity = utility.inputString();
								person.put("city", lCity);
								break;
							case 3 :
								System.out.println("enter the state");
								String lState = utility.inputString();
								person.put("state", lState);
								break;
							case 4:
								System.out.println("enter zip");
								String lZipCode = utility.inputString();
								person.put("zip", lZipCode);
								break;
							case 5 :
								System.out.println("enter phoneNumber");
								String lPhoneNumber = utility.inputString();
								while (!isTenDigit(lPhoneNumber)) 
								{
									System.out.println("Invalid mobile number");
									System.out.println("Please enter number again");
									lPhoneNumber = scanner.next();
								}
								person.put("phoneNumber", lPhoneNumber);
								break;
							case 6 : 
								System.out.println("enter address");
								String lAddress = utility.inputStringLine();
								person.put("address", lAddress);
								break;
							case 7:
								break;
							default:
								System.out.println("Invalid choice");
							}
						}
						while(lChoice < 7);
						jsonArray.set(lIndex, person);
						jsonObject.put("address", jsonArray);
						//write into file
						PrintWriter printWriter = new PrintWriter("address.json");
						printWriter.write(jsonObject.toJSONString());
						printWriter.flush();
						printWriter.close();
						System.out.println("Person detail edited successfully");
					}
					else
					{
						System.out.println("Person is not present in address book");
					}
				} catch (FileNotFoundException e) {
			
					e.printStackTrace();
				}
				catch(IOException | ParseException e)
				{
					e.printStackTrace();
				}
		}
		
			public static void address(int lChoice)
			{
				switch(lChoice)
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
			}
			/**
			 * Delete the details of the person from address book 
			 */
			@SuppressWarnings("unchecked")
			public static void deleteDetails()
			{
				System.out.println("enter the name of the person to be deleted");
				Utility utility = new Utility();
				String lFirstName = utility.inputString();
				int lIndex = 0;
				JSONObject person = new JSONObject();
				boolean isPresent = false;
				
				
					try {
						//reading the data from file
						File file = new File("address.json");
						FileReader reader = new FileReader(file);
						JSONParser parser = new JSONParser();
						JSONObject jsonObject =(JSONObject) parser.parse(reader);
						JSONArray jsonArray = (JSONArray) jsonObject.get("address");
						for(int i = 0; i < jsonArray.size();i++)
						{
							 person = (JSONObject) jsonArray.get(i);
							String personFirstName = (String) person.get("firstName");
							if(personFirstName.equals(lFirstName))
							{
								lIndex = i;
								isPresent = true;
								break;
							}
						}
						if(isPresent)
						{
							jsonArray.remove(lIndex);
							jsonObject.put("address", jsonArray);
							//write into file
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
			
			/**
			 * sort the person in alphabetically order by their names
			 */
			@SuppressWarnings("unchecked")
			public static void sortByName() 
			{	
				try {
					//read data from file
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					JSONObject person1 = new JSONObject();
					JSONObject person2 = new JSONObject();
					String lFirstName1;
					String lFfirstName2;
					
					for(int i = 0; i < jsonArray.size()-1;i++)
					{
						for(int j = i+1; j< jsonArray.size();j++)
						{
							person1 = (JSONObject) jsonArray.get(i);
							person2 = (JSONObject) jsonArray.get(j);
							lFirstName1 = (String) person1.get("firstName");
							lFfirstName2 = (String) person2.get("firstName");
							if (lFirstName1.compareToIgnoreCase(lFfirstName2) >0)
							{
								jsonArray.set(i, person2);
								jsonArray.set(j, person1);
							}
						}
					}
					jsonObject.put("address", jsonArray);
					//write data into file
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
			/**
			 * sort the address book by zip code(pincode) 
			 */
			@SuppressWarnings("unchecked")
			public static void sortByZip() 
			{

				try {
					//reading data from file
					File file = new File("address.json");
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject =(JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("address");
					JSONObject person1 = new JSONObject();
					JSONObject person2 = new JSONObject();
					String lZipCode1;
					String lZipCode2;
					long intZipCode1;
					long intZipCode2;
					for(int i = 0; i < jsonArray.size()-1;i++)
					{
						for(int j = i+1; j< jsonArray.size();j++)
						{
							person1 = (JSONObject) jsonArray.get(i);
							person2 = (JSONObject) jsonArray.get(j);
							lZipCode1 = (String) person1.get("zip");
							lZipCode2 = (String) person2.get("zip");
							intZipCode1 = Long.parseLong(lZipCode1);
							intZipCode2 = Long.parseLong(lZipCode2);
							if(intZipCode1 > intZipCode2)
							{
								jsonArray.set(i, person2);
								jsonArray.set(j, person1);
							}
						}
					}
					jsonObject.put("address", jsonArray);
					//writing data in file
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
			
			/**
			 * Displaying the details of address book 
			 */
			public static void displayAddressBook()
			{
				try 
				{
					//reading data from file
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
			public static void writeJsonObjectToFile(String fileName, JSONObject jsonObject) 
			{
				PrintWriter printWriter;
				try {
					printWriter = new PrintWriter(fileName);
					printWriter.write(jsonObject.toJSONString());
					printWriter.flush();
					printWriter.close();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
			}
			/**
			 * add doctor to clinique management system
			 */
			@SuppressWarnings("unchecked")
			public static void addDoctor() 
			{
				Utility utility = new Utility();
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				boolean lIterate = true;
				String lDoctorId = null;
				boolean isIdPresent;				
				while(lIterate)
				{
					isIdPresent = false;
					System.out.println("Enter the id of doctor");
					lDoctorId = utility.inputString();
					for(int i = 0; i < jsonArrayDoctor.size();i++)
					{
						JSONObject doctorObject = (JSONObject) jsonArrayDoctor.get(i);
						String doctorId = (String) doctorObject.get("id");
						if(doctorId.equals(lDoctorId))
						{
							isIdPresent = true;
							System.out.println("This id is use by another doctor use different one");
							break;
						}
					}
					if(!isIdPresent)
					{
						lIterate = false;
					}
				}
				System.out.println("Enter the name of doctor");
				String lDoctorName = utility.inputString();
				
				System.out.println("Enter the specialization of doctor");
				String lDoctorSpecialization = utility.inputString();
				
				System.out.println("Enter availability of doctor");
				System.out.println("You can only enter one choice out of three");
				System.out.println("AM if doctor is present in morning");
				System.out.println("PM if doctor is present in evening");
				System.out.println("Both if doctor is present both the time");
				String availability = utility.inputString();
				
				JSONObject newDoctorObject = new JSONObject();
				
				JSONObject appointment = readFromJsonFile("appoinment.json");
				appointment.put(lDoctorId, new JSONObject());
				newDoctorObject.put("id", lDoctorId);
				newDoctorObject.put("name", lDoctorName);
				newDoctorObject.put("specialization", lDoctorSpecialization);
				newDoctorObject.put("availability", availability);
				jsonArrayDoctor.add(newDoctorObject);
				jsonObjectDoctor.put("doctor", jsonArrayDoctor);
				writeJsonObjectToFile("addDoctor.json", jsonObjectDoctor);
				writeJsonObjectToFile("appoinment.json", appointment);
				System.out.println("Doctor Added");
				
				}
			
			/**
			 *add patient to clinique management system 
			 */
			@SuppressWarnings("unchecked")
			public static void addPatients() 
			{
				Utility utility = new Utility();
				JSONObject jsonObjectPatients = readFromJsonFile("addPatient.json");
				JSONArray jsonArraypatients = (JSONArray) jsonObjectPatients.get("patients");
				boolean iterate = true;
				String lPatientId = null;
				boolean idPresent = false;
				
				while(iterate)
				{
					idPresent = false;
					System.out.println("Enter the id of patients");
					lPatientId = utility.inputString();
					for(int i = 0; i < jsonArraypatients.size();i++)
					{
						JSONObject patientsObject = (JSONObject) jsonArraypatients.get(i);
						String patientsId = (String) patientsObject.get("id");
						if(patientsId.equals(lPatientId))
						{
							idPresent = true;
							System.out.println("This id is use by another patients use diffrent one");
							break;
						}
					}
					if(!idPresent)
					{
						iterate = false;
					}
				}
				System.out.println("Enter the name of patients");
				String lName = utility.inputString();
				System.out.println("Enter the mobil number of patients");
				String lMobileNumber = utility.inputString();
				System.out.println("Enter the age of patients");
				String lAge = utility.inputString();
				JSONObject newpatientsObject = new JSONObject();
				newpatientsObject.put("id", lPatientId);
				newpatientsObject.put("name", lName);
				newpatientsObject.put("mobilNumber", lMobileNumber);
				newpatientsObject.put("age", lAge);
				jsonArraypatients.add(newpatientsObject);
				jsonObjectPatients.put("patients", jsonArraypatients);
				writeJsonObjectToFile("addPatient.json", jsonObjectPatients);
				System.out.println("Patient Added");
			}
			
			/**
			 * @param pateint
			 * search the doctor in doctor list and if dotor is available then take an appoinment
			 */
			public static void serachAndbookdoctor(JSONObject patient) 
			{
				Utility utility = new Utility();
				System.out.println("1 search doctor by name");
				System.out.println("2 search doctor by id");
				System.out.println("3 search doctor by specialization");
				int lChoice = utility.inputInteger();
				switch (lChoice) 
				{
				case 1:
					System.out.println("Enter the name of the doctor");	
					serachDoctorByName(utility.inputString(),patient);
					break;
				case 2:
					System.out.println("Enter the id of doctor");
					serachDoctorById(utility.inputString(), patient);
					break;
				case 3:
					System.out.println("Enter the specilization of doctor");
					serachDoctorBySpecialization(utility.inputString(), patient);
					break;

				default:
					System.out.println("Invalid choice");
				}
			}
			
			/**
			 * @param doctorSpecialization
			 * @param pateint
			 * search doctor in doctor list by their specialization
			 */
			public static void serachDoctorBySpecialization(String doctorSpecialization,JSONObject patient) 
			{
				ArrayList<JSONObject> doctorList = new ArrayList<>();
				Utility utility = new Utility();
				JSONObject doctor = null;
				boolean isDoctorPresent = false;
				JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String specialization = (String) doctor.get("specialization");
					if(specialization.equals(doctorSpecialization))
					{
						isDoctorPresent = true;
						doctorList.add(doctor);
					}	
				}
				if(isDoctorPresent)
				{
					System.out.println("List of doctor for " + doctorSpecialization);
					for(int i = 0; i< doctorList.size();i++)
					{
						System.out.println(doctorList.get(i));
					}
					System.out.println("Enter the id of one doctor from above list");
					String lDoctorId = utility.inputString();
					System.out.println("1 to see doctor is avalable on specific date or not");
					System.out.println("or any thing else to go back");
					int lChoice = utility.inputInteger();
					switch (lChoice) 
					{
					case 1:
						checkavalbilityOfdocterbyId(lDoctorId,patient);
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

			/**
			 * @param doctorId
			 * @param pateint
			 * search doctor by their id in doctor list
			 */
			@SuppressWarnings("unused")
			public static void serachDoctorById(String doctorId,JSONObject patient) 
			{
				Utility utility = new Utility();
				JSONObject doctor = null;
				int lIndex = 0;
				boolean isDoctorPresent = false;
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String id = (String) doctor.get("id");
					if(id.equals(doctorId))
					{
						isDoctorPresent = true;
						lIndex = i;
						break;
					}	
				}
				if(isDoctorPresent)
				{
					System.out.println(doctor);
					System.out.println();
					System.out.println("1 to see doctor is avalable on specific date or not");
					System.out.println("or any thing else to go back");
					int choice = utility.inputInteger();
					switch (choice) 
					{
					case 1:
						checkavalbilityOfdocterbyId(doctorId,patient);
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
			/**
			 * @param doctorName
			 * @param pateint
			 * serach doctor by name in doctor list of clinique management system
			 */
			public static void serachDoctorByName(String doctorName,JSONObject patient) 
			{
				Utility utility = new Utility();
				JSONObject doctor = null;
				
				boolean isDoctorPresent = false;
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String lDoctorname = (String) doctor.get("name");
					if(lDoctorname.equals(doctorName))
					{
						isDoctorPresent = true;
						
						break;
					}	
				}
				if(isDoctorPresent)
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
						checkavalbilityOfdocterbyId(doctorId,patient);
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
			/**
			 * @param id
			 * @param patient
			 * check the doctor is available or not to take appoinment 
			 */
			@SuppressWarnings({ "unchecked", "unused" })
			static void checkavalbilityOfdocterbyId(String id,JSONObject patient) 
			{
				boolean isAvaliable = false;
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
						writeJsonObjectToFile("appoinment.json", jsonObjectappointment);
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
							writeJsonObjectToFile("appointment.json", jsonObjectappointment);
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
			
			/**
			 * search patient by their name, id and contact number 
			 */
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
				int lChoice = utility.inputInteger();
				switch (lChoice) {
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
						System.out.println("patient with mobile number = " + mobilNumber + "not present");
					}
				default:
					System.out.println("Invalid choice");
				}
			}
			/**
			 * Best doctor of clinique by assuming the number of appoinments 
			 */
			@SuppressWarnings("rawtypes")
			public static void bestDoctor() 
			{
				HashMap<String, Integer> doctorsPatientCount = new HashMap<>();
				JSONObject jsonObjectappointment = readFromJsonFile("appoinment.json");
				Set keyOfappointment = jsonObjectappointment.keySet();
				Iterator iterator = keyOfappointment.iterator();
				while(iterator.hasNext())
				{
					int countOfPatient = 0;
					String idOfDoctor = (String) iterator.next();
					JSONObject jsonObjectOfId = (JSONObject) jsonObjectappointment.get(idOfDoctor);
					if(jsonObjectOfId.isEmpty())
					{
						countOfPatient = 0;
					}
					else
					{
						Set keyOfDate = jsonObjectOfId.keySet();
						Iterator iterator1 = keyOfDate.iterator();
						while(iterator1.hasNext())
						{
							String date = (String) iterator1.next();
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
			
			/**
			 * @param doctorId
			 * @return
			 * get the details of doctor by their id
			 */
			public static JSONObject getDocterDetailsById(String doctorId) 
			{
				JSONObject doctor = null;
				JSONObject jsonObjectDoctor = readFromJsonFile("addDoctor.json");
				JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
				for(int i = 0; i < jsonArrayDoctor.size();i++)
				{
				    doctor = (JSONObject) jsonArrayDoctor.get(i);
					String lDoctorId = (String) doctor.get("id");
					if(lDoctorId.equals(doctorId))
					{
						return doctor;
					}	
				}
				return null;
			}
			/**
			 * Doctor and Patient Report
			 */
			@SuppressWarnings("rawtypes")
			public static void doctorPatientList() 
			{
				JSONObject jsonObjectappointment = readFromJsonFile("appoinment.json");
				Set keyOfappointment = jsonObjectappointment.keySet();
				Iterator iterator = keyOfappointment.iterator();
				while(iterator.hasNext())
				{
					String idOfDoctor = (String) iterator.next();
					System.out.println("doctor details");
					System.out.println(getDocterDetailsById(idOfDoctor));
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("patient details");
					JSONObject jsonObjectOfId = (JSONObject) jsonObjectappointment.get(idOfDoctor);
					if(jsonObjectOfId.isEmpty())
					{
						System.out.println("have no patient associated with them");
						
					}
					else
					{
						Set keyOfDate = jsonObjectOfId.keySet();
						Iterator iterator2 = keyOfDate.iterator();
						
						System.out.println("have following patient associated to it");
						while(iterator2.hasNext())
						{
							String date = (String) iterator2.next();
							JSONArray jsonArrayDate = (JSONArray) jsonObjectOfId.get(date);
							for(int i = 0; i < jsonArrayDate.size();i++)
							{
								System.out.println(jsonArrayDate.get(i));
							}
						}
					}
					System.out.println();
					System.out.println();
					System.out.println("*****************************************************************************");
				}
			}
			
			/**
			 * Printing the list of doctors in clinique
			 */
			public static void doctorList()
			{
				File file = new File("addDoctor.json");
				try {
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject = (JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("doctor");
					for(int i=0;i<jsonArray.size();i++)
					{
						System.out.println(jsonArray.get(i));
					}
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} catch (IOException | ParseException e) {
					
					e.printStackTrace();
				} 
			}
			
			/**
			 * Printing the list of Patients in clinique
			 */
			public static void patientList()
			{
				File file = new File("addPatient.json");
				try {
					FileReader reader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONObject jsonObject = (JSONObject) parser.parse(reader);
					JSONArray jsonArray = (JSONArray) jsonObject.get("patients");
					for(int i=0;i<jsonArray.size();i++)
					{
						System.out.println(jsonArray.get(i));
					}
					} 
				 catch (FileNotFoundException e) 
					{
					 e.printStackTrace();
					}
				catch (IOException | ParseException e) 
				{	
					e.printStackTrace();
				}	
			}
		
			@SuppressWarnings("unchecked")
			public static void createUser() 
			{
				JSONObject stockUser = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				 try {
					FileReader	reader = new FileReader("userDetails.json");
				
				String lName;
				int lNumberOfShare, lAmount;

				System.out.println("Enter First Name");
				lName = scanner.next();

				stockUser.put("user_Name", lName);

				System.out.println("Enter Number of Shares");
				lNumberOfShare = scanner.nextInt();
				stockUser.put("number_Share", lNumberOfShare);

				System.out.println("Enter your balance");
				lAmount = scanner.nextInt();
				stockUser.put("amount", lAmount);
				jsonArray.add(stockUser);
				JSONParser jsonParser = new JSONParser();
				JSONArray object1 = (JSONArray) jsonParser.parse(reader);

				boolean found = true;
				Iterator<?> itr1 = (object1).iterator();
				while(itr1.hasNext()) 
				{
					JSONObject jsonDeatils = (JSONObject) itr1.next();
					String userName = (String) jsonDeatils.get("user_Name");
					if (userName.equalsIgnoreCase(lName))
					{
						System.out.println("This "+lName+" user is already created");
						found = false;
					}
				}
				if (found)
				{
					object1.add(stockUser);
					/*((JSONArray) jsonArray).add(stockUser);*/
					FileWriter fileWriter = new FileWriter("userDetails.json");
					fileWriter.write(((JSONAware) object1).toJSONString());
					fileWriter.flush();
					fileWriter.close();

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
			@SuppressWarnings({ "unchecked", "unused" })
			public static void saleShare() 
			{

				File file = new File("userDetails.json");

				File file1 = new File("stockSymbols.json");

				if (file.exists() && file1.exists())
				{
					// reading stock file
					try {
						FileReader fileReader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray stock = (JSONArray) parser.parse(fileReader);

					// reading share file

					FileReader fileReader2 = new FileReader(file1);
					JSONParser parser1 = new JSONParser();
					JSONArray share = (JSONArray) parser1.parse(fileReader2);

					System.out.println("********** @ Sell Shares @ *********");
					System.out.println();

					System.out.println("Enter user name");
					String name =scanner.next();
					Iterator<?> itr = ((List<Integer>) stock).iterator();
					Iterator<?> itr1 = ((List<Integer>) share).iterator();
					boolean flag = false;

					while (itr.hasNext())
					{
						JSONObject jsonObject = (JSONObject) itr.next();
						if (jsonObject.get("user_Name").equals(name))
						{
							System.out.println("Enter the share symbol to sell share:[@,!,#]");
							String symbol =scanner.next();

							while (itr1.hasNext())
							{
								JSONObject jsonObject2 = (JSONObject) itr1.next();
								if (jsonObject2.get("stock_Symbol").equals(symbol))
								{
									System.out.println("Enter the amount to sell the shares");
									int ammount = scanner.nextInt();

									int balalnce = Integer.parseInt(jsonObject.get("amount").toString());
									int price = Integer.parseInt(jsonObject2.get("amount").toString());
									int numberShare = Integer.parseInt(jsonObject.get("number_Share").toString());
									int stockShare = Integer.parseInt(jsonObject2.get("count").toString());

									int numofshare = ammount / price;
									int newbalalnce = balalnce - ammount;
									int sharecountcus = numberShare - numofshare;
									int sharecountstock = stockShare - numofshare;

									jsonObject.remove("amount");
									jsonObject.remove("number_Share");
									jsonObject.remove("count");

									jsonObject.put("amount", newbalalnce);
									jsonObject.put("number_Share", sharecountcus);
									jsonObject2.put("count", sharecountstock);

									flag = true;
									break;
								}
							}
							System.out.println();
							System.out.println("You sell share sucessfully...Thanks");
						}
						FileWriter fileWriter = new FileWriter(file);
						fileWriter.write(JSONValue.toJSONString(stock));
						fileWriter.flush();
						fileWriter.close();
					}

					Queue queue = new Queue();
					Stack stack1 = new Stack();
					long time = System.currentTimeMillis();
					java.util.Date date = new java.util.Date(time);
					queue.insert(date);
					queue.display();
					System.out.println();

					System.out.println("----------------------------------");
					if (flag == false)
					{
						System.out.println("User name is not exits");
					}
					FileWriter fw = new FileWriter(file1);
					fw.write(JSONValue.toJSONString(share));
					fw.flush();
					fw.close();
				}
				catch (FileNotFoundException e) 
					{
							e.printStackTrace();
					}
					catch (IOException | ParseException e)
					{
						e.printStackTrace();
					}
				}
				else 
				{
					System.out.println("File does not exits");
				}
			}


			/**
			 * This method is used to sell the shares.
			 * @throws IOException
			 * @throws ParseException
			 */
			@SuppressWarnings("unchecked")
			public static void buyshare() 
			{

				File file = new File("userDetails.json");

				File file1 = new File("stockSymbols.json");
				if (file.exists() && file1.exists()) 
				{
					 
					try {
						FileReader reader = new FileReader(file);
					
					JSONParser parser = new JSONParser();
					JSONArray stock = (JSONArray) parser.parse(reader);

					FileReader reader1 = new FileReader(file1);
					JSONParser parser1 = new JSONParser();
					JSONArray share = (JSONArray) parser1.parse(reader1);

					System.out.println();
					System.out.println("**** @ Buy Shares @ ****");
					System.out.println();
					System.out.println("Enter the user name");
					String lName =scanner.next();
					Iterator<?> iterator = ((List<Integer>) stock).iterator();
					Iterator<?> iterator2 = ((List<Integer>) share).iterator();
					boolean flag = false;
					while (iterator.hasNext())
					{
						JSONObject obj = (JSONObject) iterator.next();
						if (obj.get("user_Name").equals(lName)) 
						{
							System.out.println("Enter the share symbol to buy share:[@,#,!]");
							String lSymbol = scanner.next();

							while (iterator2.hasNext())
							{
								JSONObject obj1 = (JSONObject) iterator2.next();
								if (obj1.get("stock_Symbol").equals(lSymbol))
								{
									System.out.println("Enter the amount");
									int lAmount =scanner.nextInt();

									int lBalance = Integer.parseInt(obj.get("amount").toString());
									int lPrice = Integer.parseInt(obj1.get("amount").toString());
									int lNoShare = Integer.parseInt(obj.get("number_Share").toString());
									int lStockShare = Integer.parseInt(obj1.get("count").toString());

									int lNumofshare = lAmount / lPrice;
									int lNewbal = lBalance + lAmount;
									int lShareCount = lNoShare + lNumofshare;
									int lShareCountStock = lStockShare + lNumofshare;

									obj.remove("amount");
									obj.remove("number_Share");
									obj1.remove("count");
									obj.put("amount", lNewbal);
									obj.put("number_Share", lShareCount);
									obj1.put("count", lShareCountStock);

									flag = true;
									break;
								}
							}

							System.out.println();
							System.out.println("Your shares buy successfully on...");

							Queue queue = new Queue();
							Stack stack1 = new Stack();
							long time = System.currentTimeMillis();
							java.util.Date date = new java.util.Date(time);
							queue.insert(date);
							queue.display();
							stack1.push(lSymbol);
							System.out.println();
							System.out.println("Shares symbol is: ");
							stack1.display();
							System.out.println();
							System.out.println("---------------------------------------");
							System.out.println();
						}
						FileWriter fileWriter = new FileWriter(file);
						fileWriter.write(JSONValue.toJSONString(stock));
						fileWriter.flush();
						fileWriter.close();
					}
					if (flag == false) {
						System.out.println("User name not fond");
					}
					FileWriter fw = new FileWriter(file1);
					fw.write(JSONValue.toJSONString(share));
					fw.flush();
					fw.close();		
				} 
				 catch (FileNotFoundException e) 
					{
					e.printStackTrace();
					}
					catch(IOException | ParseException e)
					{
						e.printStackTrace();
					}
				}else
				{
					System.out.println("File does not exits");
				}
			}

			/** This method is used to display shares records.
			 * @throws IOException
			 * @throws ParseException
			 */
			public static void printReport() 
			{
				try
				{
					FileReader reader1 = new FileReader("userDetails.json");
				JSONParser jsonParser1 = new JSONParser();
				JSONArray jsonArrays_StackDtails = (JSONArray) jsonParser1.parse(reader1);

				System.out.println("**** @ User Details @ ****");
				for (Object o1 : jsonArrays_StackDtails) 
				{
					JSONObject jsonDetails2 = (JSONObject) o1;
					String name = (String) jsonDetails2.get("user_Name");
					System.out.println("User Name: " + name);

					Object share = jsonDetails2.get("number_Share");
					System.out.println("Number of share: " + share);

					Object amount = jsonDetails2.get("amount");
					System.out.println("Amount: " + amount);

					System.out.println("-----------------------------------------");
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

			/**
			 * This method is to add Shares
			 */
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public static void addShare() 
			{
				Map list = (Map) new LinkedList1<String>();

				try {
					File file = new File("companyShare.json");
					if (file.exists())
						if (file.canRead() && file.canWrite()) {
							FileReader fileReader = new FileReader(file);
							JSONParser parser = new JSONParser();
							JSONArray array = (JSONArray) parser.parse(fileReader);
							Iterator iterator = ((List) array).iterator();

							while (iterator.hasNext()) {
								JSONObject json = (JSONObject) iterator.next();
								System.out.println("Enter your share you want to add:");
								String share = scanner.next();
								((ArrayList) list).add(share);
								json.putAll(list);
								array.add(json);
							}
							FileWriter fileWriter = new FileWriter(file);
							fileWriter.write(JSONArray.toJSONString(array));
							fileWriter.flush();
							fileWriter.close();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public static void removeShare() {
				Map list = (Map) new LinkedList1<String>();

				try {
					File file = new File("companyShare.json");
					if (file.exists())
						if (file.canRead() && file.canWrite()) {
							FileReader fileReader = new FileReader(file);
							JSONParser parser = new JSONParser();
							JSONArray array = (JSONArray) parser.parse(fileReader);
							Iterator iterator = ((List) array).iterator();

							while (iterator.hasNext()) {
								JSONObject json = (JSONObject) iterator.next();
								System.out.println("Enter index of share you want to Remove:");
								int position =scanner.nextInt();
								((ArrayList) list).remove(position);
								json.putAll(list);
								array.add(json);
							}
							FileWriter fileWriter = new FileWriter(file);
							fileWriter.write(JSONArray.toJSONString(array));
							fileWriter.flush();
							fileWriter.close();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

}