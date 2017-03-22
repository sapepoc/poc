package org.sapient.trade.grouper;

import org.sapient.trade.model.TradeType;

public class SellBuyGrouperRule implements GrouperRule
{
	public boolean isValidPair(TradeType type1, TradeType type2)
	{
		boolean isValidPair = false;
		if(type1.equals(TradeType.BUY) && type2.equals(TradeType.SELL))
		{
			isValidPair = true;
		}
		else if(type2.equals(TradeType.BUY) && type1.equals(TradeType.SELL))
		{
			isValidPair = true;
		}
			
		return isValidPair;
	}
}
