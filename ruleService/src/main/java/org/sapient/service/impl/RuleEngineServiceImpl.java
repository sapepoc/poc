package org.sapient.service.impl;

import java.util.Collection;

import org.sapient.model.Fact;
import org.sapient.rule.RuleGroup;
import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ruleEngineService")
public class RuleEngineServiceImpl implements RuleEngineService {

	@Override
	public void runRules(Collection<? extends Fact> facts, Collection<RuleGroup> ruleGroup) {
		// TODO Auto-generated method stub
		System.out.println("I am running rules");
	}

	@Override
	public void registerEventListener(AlarmEventObserver<? extends AlarmEvent> eventListner) {
		// TODO Auto-generated method stub
		System.out.println("Registering events"+eventListner);
	}

}
