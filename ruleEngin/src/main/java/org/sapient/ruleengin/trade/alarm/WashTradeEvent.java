package org.sapient.ruleengin.trade.alarm;

import java.util.ArrayList;
import java.util.List;

import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.alarm.core.Topic;
import org.sapient.ruleengin.trade.WashTrade;

public final class WashTradeEvent implements AlarmEvent
{
	private List<WashTrade> washTrades;

	public WashTradeEvent() 
	{
		this.washTrades = new ArrayList<WashTrade>();
	}

	public void addWashTrade(WashTrade washTrade) 
	{
		this.washTrades.add(washTrade);
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
