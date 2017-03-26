package org.sapient.ruleengin.trade;

import org.sapient.ruleengin.facts.Fact;
import org.sapient.ruleengin.trade.model.TradeData;

public final class WashTrade implements Fact
{
	private final TradeData buy;
	private final TradeData sell;
	
	public WashTrade(TradeData buy, TradeData sell)
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
