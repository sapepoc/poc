package org.sapient.trade;

import org.sapient.trade.model.Trade;
import org.sapient.trade.model.TradeType;

public class WashTrade 
{
	private Trade tradeBuy;
	private Trade tardeSell;
	
	public Trade getTradeBuy() 
	{
		return tradeBuy;
	}
	
	public void addTrade(Trade trade) 
	{
		if(TradeType.BUY.equals(trade.getTradeType()))
		{
			tradeBuy=trade;
			return;
		}

		this.tardeSell = trade;
	}
	
	public Trade getTardeSell() 
	{
		return tardeSell;
	}
	
	@Override
	public String toString() 
	{
		return "WashTrade [tradeBuy=" + tradeBuy + ", tardeSell=" + tardeSell + "]";
	}
}
