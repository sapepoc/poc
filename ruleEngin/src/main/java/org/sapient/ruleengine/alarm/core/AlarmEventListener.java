package org.sapient.ruleengine.alarm.core;

public interface AlarmEventListener
{
	void fireEvent(AlarmEvent alarmEvent);
}
