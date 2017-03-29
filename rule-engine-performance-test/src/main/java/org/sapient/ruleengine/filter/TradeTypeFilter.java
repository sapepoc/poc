package org.sapient.ruleengine.filter;

import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.trade.model.TradeType;
import org.springframework.stereotype.Component;

@Component
public class TradeTypeFilter implements TradeFilter<TradeType>
{
	@Override
	public TradeType getValue(TradeData trade) 
	{
		return trade.getTradeType();
	}

}
