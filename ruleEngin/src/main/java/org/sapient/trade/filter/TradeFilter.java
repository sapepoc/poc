package org.sapient.trade.filter;

import org.sapient.trade.model.Trade;

public interface TradeFilter<T> 
{
	T getValue(Trade trade);
}
