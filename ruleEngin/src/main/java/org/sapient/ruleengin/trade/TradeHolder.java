package org.sapient.ruleengin.trade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.trade.model.TradeType;

public class TradeHolder 
{
	private Map<String, Set<Trade>> typeToTrades;
	
	public TradeHolder()
	{
		typeToTrades = new HashMap<>();
	}
	
	public void addTrade(Trade trade)
	{
		Set<Trade> trades = typeToTrades.get(trade.getTradeType());
		if(trades == null)
		{
			trades = new HashSet<>();
			typeToTrades.put(trade.getTradeType(), trades);
		}
		trades.add(trade);
	}

	public Set<Trade> getTrades(String tradeType)
	{
		return typeToTrades.get(tradeType);
	}
	
	public Set<Trade> getOppositeTrade(String tradeType)
	{
		if(TradeType.BUY.toString().equals(tradeType))
		{
			return typeToTrades.get(TradeType.SELL.toString());
		}
		return typeToTrades.get(TradeType.BUY.toString());
	}
	

	@Override
	public String toString() 
	{
		return "TradeHolder [typeToTrades=" + typeToTrades + "]";
	}
}
