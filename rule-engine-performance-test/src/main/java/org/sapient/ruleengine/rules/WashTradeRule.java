package org.sapient.ruleengine.rules;

import java.util.List;

import org.sapient.ruleengine.trade.model.TradeData;

public class WashTradeRule implements Rule
{
	public WashTradeRule()
	{

	}
	
	@Override
	public boolean fireRule(List<TradeData> entities) 
	{
		return false;
	}
}
