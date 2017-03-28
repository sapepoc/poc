package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;

public interface RuleEngin 
{
	<T> void fireRules(List<T> entities, List<RuleData> ruleDatas);
	
	void registerEventListener(AlarmEventObserver<AlarmEvent> observer);
}
