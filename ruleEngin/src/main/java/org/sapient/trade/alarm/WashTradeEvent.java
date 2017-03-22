package org.sapient.trade.alarm;

import java.util.List;

import org.sapient.alarm.core.AlarmEvent;
import org.sapient.alarm.core.Topic;
import org.sapient.trade.WashTrade;

public final class WashTradeEvent implements AlarmEvent
{
	private List<WashTrade> washTrades;

	public WashTradeEvent(List<WashTrade> washTrades) 
	{
		this.washTrades = washTrades;
	}

	public List<WashTrade> getWashTrade() 
	{
		return washTrades;
	}

	@Override
	public Topic getType() 
	{
		return Topic.WASH_TRADE_EVENT;
	}

	@Override
	public String toString() {
		return "WashTradeEvent [washTrades=" + washTrades + "]";
	}
	
}
