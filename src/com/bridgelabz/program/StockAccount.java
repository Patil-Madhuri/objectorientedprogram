package com.bridgelabz.program;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;

import com.bridgelabz.utility.Utility;

public class StockAccount 
{
	String mCustomerPath = "stockCustomer.json";
	String mStockPath = "StockAccount.json";

	Map<String, String> transaction = new HashMap<String, String>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("hh-mm-ss dd/MM/YYYY");
	Date date = new Date();
	int count = 1;

	public StockAccount() 
	{	}

	/**
	 * StockAccount constructor used to initialize the customer object
	 * @param customer
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public StockAccount(Customer customer)
	{
		// System.out.println(customer);
		JSONObject name = new JSONObject();
		JSONObject jsonObject = Utility.readFromJsonFile(mCustomerPath);
		JSONObject jsonObject1 = new JSONObject();

		name.put("Money", customer.getMoney());
		name.put("TotalShare", customer.getTotal_share());
		jsonObject.put(customer.getName(), name);
		Utility.writeJsonObjectToFile(mCustomerPath, jsonObject);
	}

	/**
	 * buy the share
	 * @param symbol
	 * @param no_of_shares
	 * @param name
	 */
	@SuppressWarnings("unchecked")
	public void buyShare(String symbol, long no_of_shares, String name) 
	{
		JSONObject jsonStock = Utility.readFromJsonFile(mStockPath);
		JSONObject stockSymbol = (JSONObject) jsonStock.get(symbol);
		long price = (long) stockSymbol.get("Price");
		stockSymbol.put("NumberOfShare", (long) stockSymbol.get("NumberOfShare") - no_of_shares);
		jsonStock.put(symbol, stockSymbol);
		Utility.writeJsonObjectToFile(mStockPath, jsonStock);
		boolean flag = false;
		JSONObject jsonObject = Utility.readFromJsonFile(mCustomerPath);
		JSONObject customer = (JSONObject) jsonObject.get(name);
		JSONObject share_value = null;
		if (customer.get("Shares") == null)
		{
			share_value = new JSONObject();
			flag = true;
		} else 
		{
			share_value = (JSONObject) customer.get("Shares");
			flag = false;
		}
		if (flag == true) 
		{
			share_value.put(symbol, no_of_shares);
		} 
		else 
		{
			if (share_value.get(symbol) == null) 
			{
				share_value.put(symbol, no_of_shares);
			} else 
			{
				share_value.put(symbol, (long) share_value.get(symbol) + no_of_shares);
			}
		}
		customer.put("Money", (long) customer.get("Money") - (no_of_shares * price));
		customer.put("TotalShare", (long) customer.get("TotalShare") + no_of_shares);
		customer.put("Shares", share_value);
		jsonObject.put(name, customer);
		Utility.writeJsonObjectToFile(mCustomerPath, jsonObject);
		transaction.put((count++) + " " + symbol,
				name + " bought " + no_of_shares + " Share at time " + dateFormat.format(date));

	}

	/**
	 * sell the share
	 * @param symbol
	 * @param no_of_shares
	 * @param name
	 */
	@SuppressWarnings("unchecked")
	public void sellShare(String symbol, long no_of_shares, String name)
	{
		JSONObject customerJson = Utility.readFromJsonFile(mCustomerPath);
		JSONObject stockJson = Utility.readFromJsonFile(mStockPath);

		JSONObject symbolJson = (JSONObject) stockJson.get(symbol);
		long price = (long) symbolJson.get("Price");
		symbolJson.put("NumberOfShare", (long) symbolJson.get("NumberOfShare") + no_of_shares);
		stockJson.put(symbol, symbolJson);
		Utility.writeJsonObjectToFile(mStockPath, stockJson);

		JSONObject nameJson = (JSONObject) customerJson.get(name);
		nameJson.put("Money", (long) nameJson.get("Money") + (price * no_of_shares));
		customerJson.put(name, nameJson);

		nameJson.put("TotalShare", (long) nameJson.get("TotalShare") - no_of_shares);
		customerJson.put(name, nameJson);

		JSONObject share = (JSONObject) nameJson.get("Shares");
		share.put(symbol, (long) share.get(symbol) - no_of_shares);

		nameJson.put("Shares", share);
		customerJson.put(name, nameJson);

		Utility.writeJsonObjectToFile(mCustomerPath, customerJson);

		transaction.put((count++) + " " + symbol,
				name + " sold " + no_of_shares + " Share at time " + dateFormat.format(date));
	}

	/**
	 * add new company
	 * @param symbol
	 * @param noOfShares
	 * @param priceOfEachShare
	 */
	@SuppressWarnings("unchecked")
	public void addNewSymbol(String symbol, long noOfShares, long priceOfEachShare) 
	{
		JSONObject jsonObject = Utility.readFromJsonFile(mStockPath);
		JSONObject jsonSymbol = new JSONObject();
		jsonSymbol.put("NumberOfShare", noOfShares);
		jsonSymbol.put("Price", priceOfEachShare);
		jsonObject.put(symbol, jsonSymbol);
		Utility.writeJsonObjectToFile(mStockPath, jsonObject);
	}

	/**remove the company
	 * @param symbol
	 */
	public void removeSymbol(String symbol) 
	{
		JSONObject jsonObject = Utility.readFromJsonFile(mStockPath);
		jsonObject.remove(symbol);
		Utility.writeJsonObjectToFile(mStockPath, jsonObject);
	}

	/**
	 * display transactions details
	 */
	public void displayTransactionDetails() 
	{
		Iterator<Map.Entry<String, String>> iterator = transaction.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "    " + entry.getValue());
		}
	}

	/**
	 * print the report 
	 */
	public void displayReport() 
	{
		JSONObject jsonStock = Utility.readFromJsonFile(mStockPath);
		System.out.println(jsonStock.toJSONString());
		JSONObject jsonCustomer = Utility.readFromJsonFile(mCustomerPath);
		System.out.println(jsonCustomer.toJSONString());
	}
}
