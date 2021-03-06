package org.sapient.ruleengine.alarm.core;

public interface AlarmEventObserver<E extends AlarmEvent>
{
	Topic getTopic();
	void notify(E alarmEvent);
}
