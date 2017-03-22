package org.sapient.trade.filter;

import java.util.List;

public class TradeFiltersHolder 
{
	private List<TradeFilter<?>> tradeFilters;
	
	public TradeFiltersHolder(List<TradeFilter<?>> tradeFilters)
	{
		this.tradeFilters = tradeFilters;
	}
	
	public List<TradeFilter<?>> getTradeFilters() 
	{
		return tradeFilters;
	}

	@Override
	public String toString()
	{
		return "TradeFiltersHolder [tradeFilters=" + tradeFilters + "]";
	}
}
