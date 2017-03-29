package org.sapient.ruleengine.filter;

import org.sapient.ruleengine.trade.model.TradeData;

public class CompanyFilter implements TradeFilter<String> 
{
	@Override
	public String getValue(TradeData trade) 
	{
		return trade.getCompany();
	}
}
