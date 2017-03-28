package org.sapient.ruleengine.events;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.Topic;
import org.sapient.ruleengine.facts.FxTrade;

public class FxTradeEvent implements AlarmEvent
{
	public String source;
	
	private FxTrade fxTrade;
	
	public FxTradeEvent(String source, FxTrade fxTrade)
	{
		this.source = source;
		this.fxTrade = fxTrade;
	}
	
	@Override
	public Topic getType() 
	{
		return Topic.FX_TRADE_EVENT;
	}

	public String getSource() 
	{
		return source;
	}

	public FxTrade getFxTrade() 
	{
		return fxTrade;
	}

	@Override
	public String toString()
	{
		return "TradeEvent [source=" + source + ", fxTrade=" + fxTrade + "]";
	}

}
