package org.sapient.ruleengin.trade.filter;

import org.sapient.entites.trade.Trades.Trade;

public interface TradeFilter<T> 
{
	T getValue(Trade trade);
}
