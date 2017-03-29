package org.sapient.ruleengine.filter;

import org.sapient.ruleengine.trade.model.TradeData;

public class DateFilter implements TradeFilter<Long>
{
	@Override
	public Long getValue(TradeData trade) 
	{
		return trade.getDateTime();
	}
}
