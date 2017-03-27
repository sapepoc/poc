package org.sapient.ruleengine.trade.filter;

import org.sapient.entites.trade.Trades.Trade;
import org.springframework.stereotype.Component;

@Component
public class QuantityFilter implements TradeFilter<Integer> 
{
	@Override
	public Integer getValue(Trade trade) 
	{
		return trade.getQuantity();
	}
}