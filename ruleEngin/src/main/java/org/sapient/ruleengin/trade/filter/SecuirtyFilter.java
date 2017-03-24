package org.sapient.ruleengin.trade.filter;

import org.sapient.entites.trade.Trades.Trade;

public class SecuirtyFilter implements TradeFilter<String> 
{
	@Override
	public String getValue(Trade trade) 
	{
		return trade.getSecurity();
	}
}

