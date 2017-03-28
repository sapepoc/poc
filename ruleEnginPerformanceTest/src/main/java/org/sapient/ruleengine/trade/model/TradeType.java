package org.sapient.ruleengine.trade.model;

public enum TradeType 
{
	SELL,
	BUY;
	
	public static TradeType getTradeType(String type)
	{
		for (TradeType tradeType : TradeType.values()) 
		{
			if(tradeType.name().equalsIgnoreCase(type))
			{
				return tradeType;
			}
		}

		throw new RuntimeException("TradeType not found, for type="+ type);
	}
}
