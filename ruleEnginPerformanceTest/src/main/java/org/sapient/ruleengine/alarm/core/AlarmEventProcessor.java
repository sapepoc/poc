package org.sapient.ruleengine.alarm.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AlarmEventProcessor implements AlarmEventProvider, AlarmEventListener
{
	private Map<Topic, List<AlarmEventObserver<AlarmEvent>>> topicToObservers;
	public AlarmEventProcessor()
	{
		topicToObservers = new HashMap<>();
	}

	public void fireEvent(AlarmEvent alarmEvent)
	{
		List<AlarmEventObserver<AlarmEvent>> observers = topicToObservers.get(alarmEvent.getType());
		for (AlarmEventObserver<AlarmEvent> observer : observers) 
		{
			observer.notify(alarmEvent);
		}
	}

	@Override
	public void register(AlarmEventObserver<AlarmEvent> observer)
	{
		List<AlarmEventObserver<AlarmEvent>> observers = topicToObservers.get(observer.getTopic());
		if(observers == null)
		{
			observers = new ArrayList<>();
			topicToObservers.put(observer.getTopic(), observers);
		}
		observers.add(observer);
	}

	@Override
	public void unregister(AlarmEventObserver<AlarmEvent> observer) 
	{
		List<AlarmEventObserver<AlarmEvent>> observers = topicToObservers.get(observer.getTopic());
		if(observers != null)
		{
			observers.remove(observer);
		}
	}
}
