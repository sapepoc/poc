package org.sapient.alarm.core;

public interface AlarmEventProvider
{
	void register(AlarmEventObserver<AlarmEvent> observer);
	void unregister(AlarmEventObserver<AlarmEvent> observer);
}