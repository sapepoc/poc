package org.sapient.ruleengine.trade.alarm;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.Topic;
import org.sapient.ruleengine.trade.WashTrade;

public final class WashTradeEvent implements AlarmEvent
{
	private WashTrade washTrade;
	public WashTradeEvent(WashTrade washTrade) 
	{
		this.washTrade = washTrade;
	}

	public WashTrade getWashTrade() 
	{
		return washTrade;
	}
	
	@Override
	public Topic getType() 
	{
		return Topic.WASH_TRADE_EVENT;
	}

	@Override
	public String toString() {
		return "WashTradeEvent [washTrade=" + washTrade + "]";
	}
	
}
