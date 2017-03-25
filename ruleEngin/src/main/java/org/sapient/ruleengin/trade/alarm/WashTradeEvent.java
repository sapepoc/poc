package org.sapient.ruleengin.trade.alarm;

import java.util.ArrayList;
import java.util.List;

import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.alarm.core.Topic;
import org.sapient.ruleengin.trade.WashTrade;

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
