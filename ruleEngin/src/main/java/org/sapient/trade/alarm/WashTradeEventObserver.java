package org.sapient.trade.alarm;

import org.sapient.alarm.core.AlarmEvent;
import org.sapient.alarm.core.AlarmEventObserver;
import org.sapient.alarm.core.AlarmEventProvider;
import org.sapient.alarm.core.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WashTradeEventObserver implements AlarmEventObserver<AlarmEvent>
{
	private AlarmEventProvider alarmEventProvider;
	
	@Autowired
	public WashTradeEventObserver(AlarmEventProvider alarmEventProvider)
	{
		this.alarmEventProvider = alarmEventProvider;
		alarmEventProvider.register(this);
	}
	
	@Override
	public Topic getTopic() 
	{
		return Topic.WASH_TRADE_EVENT;
	}

	@Override
	public void notify(AlarmEvent alarmEvent) 
	{
		System.out.println("WashTradeEvent event received="+alarmEvent);
	}
}
