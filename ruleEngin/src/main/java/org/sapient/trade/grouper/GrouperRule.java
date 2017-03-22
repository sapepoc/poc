package org.sapient.trade.grouper;

import org.sapient.trade.model.TradeType;

public interface GrouperRule 
{
	boolean isValidPair(TradeType type1, TradeType type2);
}
