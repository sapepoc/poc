package org.sapient.ruleengin.alarm.core;

public interface AlarmEventObserver<E extends AlarmEvent>
{
	Topic getTopic();
	void notify(E alarmEvent);
}
