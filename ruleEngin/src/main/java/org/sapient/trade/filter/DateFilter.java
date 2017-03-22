package org.sapient.trade.filter;

import org.sapient.trade.model.Trade;

public class DateFilter implements TradeFilter<Long>
{
	@Override
	public Long getValue(Trade trade) 
	{
		return trade.getTime();
	}
}
