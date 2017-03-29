package org.sapient.ruleengine.observers;

import java.util.ArrayList;
import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.ruleengine.alarm.core.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FxTradeEventObserver implements AlarmEventObserver<AlarmEvent>
{
	private List<AlarmEvent> events = new ArrayList<>(); 
	
	@Autowired
	public FxTradeEventObserver()
	{
	}
	
	@Override
	public Topic getTopic() 
	{
		return Topic.FX_TRADE_EVENT;
	}

	@Override
	public void notify(AlarmEvent alarmEvent) 
	{
		System.out.println("FxTradeEvent event received<<<<"+alarmEvent);
		events.add(alarmEvent);
	}
	
	public List<AlarmEvent> getAlarmEvents() 
	{
		return events;
	}
}
