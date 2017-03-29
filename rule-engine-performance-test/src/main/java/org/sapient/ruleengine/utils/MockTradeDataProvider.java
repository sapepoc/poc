package org.sapient.ruleengine.utils;

import java.util.ArrayList;
import java.util.List;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengine.trade.model.TradeType;

public class MockTradeDataProvider 
{
	private MockTradeDataProvider(){}
	
	private static Trade createTrade(int tradeId, String type, String security, String company, int quantity, double amount, long time)
	{
		Trade trade  = new Trade();
		trade.setId(tradeId);
		trade.setTradeType(type);
		trade.setSecurity(security);
		trade.setCompany(company);
		trade.setQuantity(quantity);
		trade.setAmount(amount);
		trade.setTime(time);
		return trade;
	}
	
	public static List<Trade> createDummyTrades(int noOfTrades)
	{
		List<Trade> trades  = new ArrayList<Trade>();
		int buyQuantity = 10;
		int sellQuantity = 500;
		int buyAmount = 1000;
		int sellAmount = 5000;
		long currentTimeMillis = System.currentTimeMillis();
		for(int i = 1 ; i < noOfTrades; i++)
		{
			trades.add(createTrade(i, TradeType.BUY.toString(), "Security_"+i, "Company_"+i, 
					buyQuantity+i, buyAmount+i, currentTimeMillis));
			++i;
			trades.add(createTrade(i, TradeType.SELL.toString(), "Security_"+i, "Company_"+i, 
					sellQuantity+i, sellAmount+i, currentTimeMillis));
		}
		return trades;
	}
	
	public static List<Trade> createTwoDummyTrades()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		long currentTimeMillis = System.currentTimeMillis();
		trades.add(createTrade(1, TradeType.BUY.toString(), "Sapient", "Airtel", 5200, 5000, currentTimeMillis));
		trades.add(createTrade(2, TradeType.SELL.toString(), "Sapient", "Airtel", 2500, 10000, currentTimeMillis));
		return trades;
	}
	
	public static List<Trade> createDummyTradeDataWithoutAnyWashTrade()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		long currentTimeMillis = System.currentTimeMillis();
		trades.add(createTrade(8, TradeType.BUY.toString(), "Sapient", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(9, TradeType.BUY.toString(), "Sapient", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(3, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		trades.add(createTrade(13, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		trades.add(createTrade(4, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		trades.add(createTrade(5, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		return trades;
	}
	
	public static List<Trade> createDummyTradeDataWithOneWashTrade()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		long currentTimeMillis = System.currentTimeMillis();
		trades.add(createTrade(8, TradeType.BUY.toString(), "Sapient", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(9, TradeType.BUY.toString(), "Sapient", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(3, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		trades.add(createTrade(13, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		trades.add(createTrade(4, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		trades.add(createTrade(5, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		trades.add(createTrade(6, TradeType.SELL.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		
		return trades;
	}
	
	public static List<Trade> createDummyTrades()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		long currentTimeMillis = System.currentTimeMillis();
		trades.add(createTrade(7, TradeType.SELL.toString(), "Sapient1", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(8, TradeType.BUY.toString(), "Sapient1", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(9, TradeType.BUY.toString(), "Sapient1", "Airtel", 60, 10, currentTimeMillis));
		trades.add(createTrade(3, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		trades.add(createTrade(13, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		trades.add(createTrade(4, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		trades.add(createTrade(5, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		trades.add(createTrade(6, TradeType.SELL.toString(), "HCL", "Airtel", 50, 6, currentTimeMillis));
		trades.add(createTrade(12, TradeType.SELL.toString(), "Siemens", "Idea", 52, 8, currentTimeMillis));
		
		return trades;
	}
}
