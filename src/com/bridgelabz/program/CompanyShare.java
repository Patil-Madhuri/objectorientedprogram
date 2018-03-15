package com.bridgelabz.program;


public class CompanyShare 
{
	private String stockName;
	private String stockSymbol;
	private int noOfShares;
	private String dateTime;
	private long price;
	private String date;
	private  String status;
	public CompanyShare() {
		
	}
	public CompanyShare(String stockName, String stockSymbol, int noOfSellingShares, long price2, String date, String status) {
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.noOfShares = noOfSellingShares;
		this.price = price2;
		this.date=date;
		this.status=status;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
