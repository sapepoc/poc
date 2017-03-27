package org.sapient.ruleengine.facts;

import org.sapient.ruleengine.alarm.core.AlarmEventListener;
import org.sapient.ruleengine.trade.WashTrade;
import org.sapient.ruleengine.trade.alarm.WashTradeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WashTradeProcessor implements FactProcessor<WashTrade>
{
	private AlarmEventListener alarmEventListener;

	@Autowired
	public WashTradeProcessor(AlarmEventListener alarmEventListener)
	{
		this.alarmEventListener = alarmEventListener;
	}

	@Override
	public void process(WashTrade washTrade) 
	{
		WashTradeEvent washTradeEvent = new WashTradeEvent(washTrade);
		alarmEventListener.fireEvent(washTradeEvent);
	}
}
