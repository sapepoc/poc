package org.sapient.ruleengin.facts;

import org.sapient.ruleengin.alarm.core.AlarmEventListener;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.trade.alarm.WashTradeEvent;
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
