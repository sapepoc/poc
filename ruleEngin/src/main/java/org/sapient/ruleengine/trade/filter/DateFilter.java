package org.sapient.ruleengine.trade.filter;

import org.sapient.entites.trade.Trades.Trade;

public class DateFilter implements TradeFilter<Long>
{
	@Override
	public Long getValue(Trade trade) 
	{
		return trade.getTime();
	}
}
