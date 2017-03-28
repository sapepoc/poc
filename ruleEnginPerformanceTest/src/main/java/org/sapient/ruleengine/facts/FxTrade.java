package org.sapient.ruleengine.facts;

import org.sapient.ruleengine.trade.model.TradeData;

public final class FxTrade
{
	private final TradeData buy;
	private final TradeData sell;
	
	public FxTrade(TradeData buy, TradeData sell)
	{
		this.buy = buy;
		this.sell = sell;
	}

	public TradeData getBuy() 
	{
		return buy;
	}

	public TradeData getSell() 
	{
		return sell;
	}

	@Override
	public String toString() 
	{
		return "WashTrade [buy=" + buy + ", sell=" + sell + "]";
	}
}
