package org.sapient.trade;

import java.util.HashMap;
import java.util.Map;

import org.sapient.trade.model.Trade;

public class WashTradeMap 
{
	private static final String DAY = "2016-01-01";
	private Map<TradeIdentifier,TradeHolder> tradeHolders;
	
	public WashTradeMap()
	{
		tradeHolders = new HashMap<>();
	}
	
	public TradeHolder getTradeHolder(TradeIdentifier tradeIdentifier)
	{
		return tradeHolders.get(tradeIdentifier);
	}
	
	public void putTrades(Trade trade)
	{
		TradeIdentifier identifier = new WashTradeIdentifier(trade.getSecurity(),
				trade.getCompany(), DAY, trade.getQuantity());
		
		TradeHolder tradeHolder = tradeHolders.get(identifier);
		if(tradeHolder == null)
		{
			tradeHolder = new TradeHolder();
			tradeHolders.put(identifier, tradeHolder);
		}
		tradeHolder.addTrade(trade);
	}

	@Override
	public String toString() 
	{
		return "WashTradeMap [tradeHolders=" + tradeHolders + "]";
	}
}
