package org.sapient.ruleengine.filter;

import org.sapient.ruleengine.trade.model.TradeData;
import org.springframework.stereotype.Component;

@Component
public class QuantityFilter implements TradeFilter<Integer> 
{
	@Override
	public Integer getValue(TradeData trade) 
	{
		return trade.getQuantity();
	}
}