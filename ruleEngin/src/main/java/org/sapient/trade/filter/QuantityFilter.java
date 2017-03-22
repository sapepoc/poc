package org.sapient.trade.filter;

import org.sapient.trade.model.Trade;
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