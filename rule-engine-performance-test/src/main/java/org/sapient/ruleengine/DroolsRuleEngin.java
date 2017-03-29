package org.sapient.ruleengine;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;
import org.sapient.ruleengine.utils.KieContainerProvider;
import org.sapient.ruleengine.utils.KieSessionHelper;

public class DroolsRuleEngin extends AbstractRuleEngin
{
	private KieContainer kieContainer;
	
	public DroolsRuleEngin(AlarmEventProcessor alarmEventProcessor)
	{
		super(alarmEventProcessor);
		kieContainer = KieContainerProvider.createKieContainer();
	}

	@Override
	protected <T> int fireRules0(List<T> entities, List<RuleData> ruleDatas) 
	{
		int fireRules = 0;

		KieSession kieSession = KieSessionHelper.createSession(kieContainer, "baseKSession-rules");
		kieSession.setGlobal("alarmEventListener", alarmEventProcessor);

		for(T entity: entities)
		{
			kieSession.insert(entity);
		}
		fireRules = kieSession.fireAllRules(new AgendaFilter() {

			@Override
			public boolean accept(Match match)
			{
				//TODO: We can filter rule here
				return true;
			}
		});
		kieSession.dispose();
		
		return fireRules;
	}

	@Override
	protected RuleEnginType ruleEnginType()
	{
		return RuleEnginType.DROOLS;
	}
}
