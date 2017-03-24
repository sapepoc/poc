package org.sapient.ruleengin.utils;

import java.util.ArrayList;
import java.util.List;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.trade.model.TradeType;

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
	
	public static List<Trade> createDummyTrades()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		trades.add(createTrade(1, TradeType.BUY.toString(), "Sapient", "Airtel", 40, 10, System.currentTimeMillis()));
		trades.add(createTrade(2, TradeType.SELL.toString(), "Sapient", "Airtel", 40, 10, System.currentTimeMillis()));
		trades.add(createTrade(3, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, System.currentTimeMillis()));
		trades.add(createTrade(4, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		trades.add(createTrade(5, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		trades.add(createTrade(6, TradeType.SELL.toString(), "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		
		return trades;
	}
}
