package org.sapient.trade.filter;

import org.sapient.trade.model.Trade;

public class SecuirtyFilter implements TradeFilter<String> 
{
	@Override
	public String getValue(Trade trade) 
	{
		return trade.getSecurity();
	}
}

