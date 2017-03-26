package org.sapient.ruleengin.trade.alarm;

import java.util.ArrayList;
import java.util.List;

import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.alarm.core.AlarmEventObserver;
import org.sapient.ruleengin.alarm.core.AlarmEventProvider;
import org.sapient.ruleengin.alarm.core.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WashTradeEventObserver implements AlarmEventObserver<AlarmEvent>
{
	@SuppressWarnings("unused")
	private AlarmEventProvider alarmEventProvider;
	private List<AlarmEvent> events = new ArrayList<>(); 
	
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
		System.out.println("WashTradeEvent event received<<<<"+alarmEvent);
		events.add(alarmEvent);
	}
	
	public List<AlarmEvent> getAlarmEvents() 
	{
		return events;
	}
}
