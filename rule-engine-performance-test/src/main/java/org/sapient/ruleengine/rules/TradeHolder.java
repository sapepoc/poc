package org.sapient.ruleengine.rules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.trade.model.TradeType;

public class TradeHolder 
{
	private Map<TradeType, Set<TradeData>> typeToTrades;
	
	public TradeHolder()
	{
		typeToTrades = new HashMap<>();
	}
	
	public void addTrade(TradeData trade)
	{
		Set<TradeData> trades = typeToTrades.get(trade.getTradeType());
		if(trades == null)
		{
			trades = new HashSet<>();
			typeToTrades.put(trade.getTradeType(), trades);
		}
		trades.add(trade);
	}

	public Set<TradeData> getTrades(TradeType tradeType)
	{
		return typeToTrades.get(tradeType);
	}
	
	public Set<TradeData> getOppositeTrade(TradeType tradeType)
	{
		if(TradeType.BUY.equals(tradeType))
		{
			return typeToTrades.get(TradeType.SELL);
		}
		return typeToTrades.get(TradeType.BUY);
	}
	
	
	public void clear()
	{
		typeToTrades.clear();
	}

	@Override
	public String toString() 
	{
		return "TradeHolder [typeToTrades=" + typeToTrades + "]";
	}
}
