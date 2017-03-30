package org.sapient.service;

import java.util.Collection;

import org.sapient.model.Fact;
import org.sapient.rule.RuleGroup;
import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;


public interface RuleEngineService {

	public void runRules(Collection<? extends Fact> facts, Collection<RuleGroup> ruleGroup);
	
	public void registerEventListener(AlarmEventObserver<? extends AlarmEvent> eventListner);
	
}
