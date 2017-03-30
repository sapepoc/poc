package org.sapient.ruleengine.utils;

import java.util.ArrayList;
import java.util.List;

import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.trade.model.TradeType;

public class MockTradeDataProvider 
{
	private MockTradeDataProvider(){}
	
	public static List<TradeData> createAllDummyWashTrades(int noOfTrades)
	{
		List<TradeData> trades  = new ArrayList<TradeData>();
		int buyQuantity = 10;
		int buyAmount = 1000;
		long currentTimeMillis = System.currentTimeMillis();
		
		TradeType tradeType = TradeType.BUY;
		for(int i = 1 ; i <= noOfTrades; i++)
		{
			trades.add(new TradeData(i, tradeType, "Security_"+1, "Company_"+1, 
					buyQuantity, buyAmount, currentTimeMillis));
			tradeType = tradeType == TradeType.BUY ? TradeType.SELL : TradeType.BUY;
		}
		
		return trades;
	}
	
	public static List<TradeData> createDummyTrades(int noOfTrades)
	{
		List<TradeData> trades  = new ArrayList<TradeData>();
		int buyQuantity = 10;
		int sellQuantity = 10;
		int buyAmount = 1000;
		int sellAmount = 1000;
		long currentTimeMillis = System.currentTimeMillis();
		
		TradeType tradeType = TradeType.BUY;
		for(int i = 1 ; i < noOfTrades; i++)
		{
			trades.add(new TradeData(i, tradeType, "Security_"+i, "Company_"+i, 
					buyQuantity, buyAmount, currentTimeMillis));
			
			tradeType = tradeType == TradeType.BUY ? TradeType.SELL : TradeType.BUY;
		}
		
		trades.add(new TradeData(noOfTrades+1, TradeType.BUY, "Security", "Company", 
				buyQuantity, buyAmount, currentTimeMillis));
		
		trades.add(new TradeData(noOfTrades+2, TradeType.SELL, "Security", "Company", 
				buyQuantity, buyAmount, currentTimeMillis));
		
		return trades;
	}
	
	
}
