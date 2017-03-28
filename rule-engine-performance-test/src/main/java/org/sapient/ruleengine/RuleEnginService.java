package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;

public interface RuleEnginService 
{
	<T> void applyRule(List<T> entities);
	
	void register(AlarmEventObserver<AlarmEvent> alarmEventObserver);
}
