package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;

public abstract class AbstractRuleEngin implements RuleEngin
{
	protected AlarmEventProcessor alarmEventProcessor;

	public AbstractRuleEngin(AlarmEventProcessor alarmEventProcessor)
	{
		this.alarmEventProcessor = alarmEventProcessor;
	}
	
	protected abstract RuleEnginType ruleEnginType();
	
	@Override
	public void registerEventListener(AlarmEventObserver<AlarmEvent> observer)
	{
		alarmEventProcessor.register(observer);
	}
	
	@Override
	public <T> void fireRules(List<T> entities, List<RuleData> ruleDatas)
	{
		fireRules0(entities, ruleDatas);
	}
	
	protected abstract <T> int fireRules0(List<T> entities, List<RuleData> ruleDatas);
}
