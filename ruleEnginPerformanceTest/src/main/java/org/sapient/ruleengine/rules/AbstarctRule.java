package org.sapient.ruleengine.rules;

import org.sapient.ruleengine.alarm.core.AlarmEventListener;
import org.sapient.ruleengine.events.FxTradeEvent;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstarctRule implements Rule
{
	@Autowired
	protected AlarmEventListener alarmEventListener;
	
	protected void fireAlarmEvent(FxTradeEvent fxTradeEvent)
	{
		alarmEventListener.fireEvent(fxTradeEvent);
	}
}
