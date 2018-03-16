package com.bridgelabz.program;
/***************************************************************************
 * @purpose : Company share using stack and queue
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 15/03/2018
 ***************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import com.bridgelabz.program.Stack;
import com.bridgelabz.program.Queue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class CompanyShare 
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Utility utility=new Utility();
		//scan = new Scanner(System.in);
		Stack stack = new Stack();
		Queue queue = new Queue();
		File file = new File("companyShare.json");
		 
		try {
			FileReader	fr = new FileReader(file);
		
		JSONParser parser = new JSONParser();
		 
	
		 JSONArray array = (JSONArray) parser.parse(fr);
		
		
		Iterator itr = array.iterator();
		@SuppressWarnings("unused")
		LinkedList ll = new LinkedList();
		System.out.println("Enter the share symbol");
		String symbol = utility.inputString();
		while(itr.hasNext())
		{
			JSONObject obj = (JSONObject) itr.next();
			//ll.add(obj.get(symbol));
			//System.out.println(ll);
			if(obj.containsKey(symbol))
			{
				System.out.println("Share symbol already their in list");
				System.out.println("To add share press 1 and To remove share press 2");
				int choice = utility.inputInteger();
				switch(choice)
				{
				case 1 : 
							System.out.println("Enter the number of share want to buy");
							int num_share = utility.inputInteger();
							JSONObject object = (JSONObject) obj.get(symbol);
							int key = Integer.parseInt(object.get("NumOfShare").toString());
							int new_shares_count = key + num_share;
							object.remove("NumOfShare");
							object.put("NumOfShare", new_shares_count);
							FileWriter fw = new FileWriter(file);
							fw.write(JSONValue.toJSONString(array));
							fw.flush();
							fw.close();
						
					break;
				case 2 : 	System.out.println("Enter the amount of share to sale");
							int amt = utility.inputInteger();
							JSONObject object1 = (JSONObject) obj.get(symbol);
							int share_amt = Integer.parseInt(object1.get("ShareAmt").toString());
							int num_share1 = Integer.parseInt(object1.get("NumOfShare").toString());
							int new_shares_count1 = num_share1 - (amt/share_amt);
							object1.remove("NumOfShare");
							object1.put("NumOfShare", new_shares_count1);
							FileWriter fw1 = new FileWriter(file);
							fw1.write(JSONValue.toJSONString(array));
							fw1.flush();
							fw1.close();
					break;
				}
				
			}
			else
			{
				JSONObject object = new JSONObject();
				System.out.println("Enter number of share");
				int num = utility.inputInteger();
				System.out.println("Enter share amount");
				int amt = utility.inputInteger();
				object.put("NumOfShare",num );
				object.put("ShareAmt",amt);
				obj.put(symbol,object);
				System.out.println("Added succesfull");
				stack.push(symbol);
				stack.display();
				queue.insert(symbol);
				queue.display();
				FileWriter writer = new FileWriter(file);
				writer.write(JSONValue.toJSONString(array));
				writer.flush();
				writer.close();
			}
		}
		}
		catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException | ParseException e) {
			
			e.printStackTrace();
		}
		
		
	
}
	
}
