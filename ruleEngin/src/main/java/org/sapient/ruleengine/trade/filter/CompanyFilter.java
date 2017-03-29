package org.sapient.ruleengine.trade.filter;

import org.sapient.entites.trade.Trades.Trade;

public class CompanyFilter implements TradeFilter<String> 
{
	@Override
	public String getValue(Trade trade) 
	{
		return trade.getCompany();
	}
}
