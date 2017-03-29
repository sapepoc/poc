package org.sapient.ruleengine.filter;

import org.sapient.ruleengine.trade.model.TradeData;

public interface TradeFilter<T> 
{
	T getValue(TradeData trade);
}
