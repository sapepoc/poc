package org.sapient.ruleengin.trade;

import org.sapient.Fact;
import org.sapient.entites.trade.Trades.Trade;

public final class WashTrade implements Fact
{
	private final Trade buy;
	private final Trade sell;
	
	public WashTrade(Trade buy, Trade sell)
	{
		this.buy = buy;
		this.sell = sell;
	}

	public Trade getBuy() 
	{
		return buy;
	}

	public Trade getSell() 
	{
		return sell;
	}

	@Override
	public String toString() 
	{
		return "WashTrade [buy=" + buy + ", sell=" + sell + "]";
	}
}
