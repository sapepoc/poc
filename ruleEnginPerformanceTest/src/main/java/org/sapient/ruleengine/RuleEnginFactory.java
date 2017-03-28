package org.sapient.ruleengine;

import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleEnginFactory
{
	@Autowired
	private AlarmEventProcessor alarmEventProcessor;
	@Autowired
	private RuleBuilder builder;
	
	public RuleEngin createRuleEngin(RuleEnginType enginType)
	{
		if(RuleEnginType.DROOLS.equals(enginType))
		{
			return new DroolsRuleEngin(alarmEventProcessor);
		}
		else if(RuleEnginType.JAVA.equals(enginType))
		{
			return new JavaRuleEngin(alarmEventProcessor, builder);
		}
		
		throw new RuntimeException("Provived rule engin is not supported, enginType:"+ enginType);
	}
}
