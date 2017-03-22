package org.sapient.trade.filter;

import org.sapient.trade.model.Trade;
import org.sapient.trade.model.TradeType;
import org.springframework.stereotype.Component;

@Component
public class TradeTypeFilter implements TradeFilter<TradeType>
{
	@Override
	public TradeType getValue(Trade trade) 
	{
		return trade.getTradeType();
	}

}
