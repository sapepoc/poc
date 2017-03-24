package org.sapient.ruleengin.trade.filter;

import org.sapient.entites.trade.Trades.Trade;
import org.springframework.stereotype.Component;

@Component
public class TradeTypeFilter implements TradeFilter<String>
{
	@Override
	public String getValue(Trade trade) 
	{
		return trade.getTradeType();
	}

}
