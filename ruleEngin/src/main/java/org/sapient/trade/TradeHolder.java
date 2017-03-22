package org.sapient.trade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sapient.trade.model.Trade;
import org.sapient.trade.model.TradeType;

public class TradeHolder 
{
	private Map<TradeType, Set<Trade>> typeToTrades;
	
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

	public Set<Trade> getTrades(TradeType tradeType)
	{
		return typeToTrades.get(tradeType);
	}
	
	public Set<Trade> getOppositeTrade(TradeType tradeType)
	{
		if(TradeType.BUY.equals(tradeType))
		{
			return typeToTrades.get(TradeType.SELL);
		}
		return typeToTrades.get(TradeType.BUY);
	}
	

	@Override
	public String toString() 
	{
		return "TradeHolder [typeToTrades=" + typeToTrades + "]";
	}
}
