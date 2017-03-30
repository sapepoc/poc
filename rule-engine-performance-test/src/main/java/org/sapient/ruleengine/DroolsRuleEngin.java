package org.sapient.ruleengine;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;
import org.sapient.ruleengine.drools.DroolsManager;
import org.sapient.ruleengine.report.PerformanceMonitor;
import org.sapient.ruleengine.report.PerformanceReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroolsRuleEngin extends AbstractRuleEngin
{
	private static Logger LOGGER = LoggerFactory.getLogger(DroolsRuleEngin.class);
	private DroolsManager droolsManager;
	
	public DroolsRuleEngin(AlarmEventProcessor alarmEventProcessor)
	{
		super(alarmEventProcessor);
		droolsManager = new DroolsManager();
	}

	@Override
	protected <T> int fireRules0(List<T> entities, List<RuleData> ruleDatas) 
	{
		int fireRules = 0;
		
		PerformanceMonitor monitor = new PerformanceMonitor();
		monitor.startMonitoring();
		KieSession kieSession = droolsManager.createSession("baseKSession-rules");
		kieSession.setGlobal("alarmEventListener", alarmEventProcessor);
		PerformanceReport performanceReport = monitor.stopMonitoring();
		System.out.println("*******************session creation:::performanceReport="+ performanceReport);
		
		LOGGER.info("Facts insertion started. total facts={}", entities.size());
		for(T entity: entities)
		{
			droolsManager.insertFacts(kieSession, entity);
		}
		
		fireRules = droolsManager.fireAllRules(kieSession, new AgendaFilter() 
		{
			@Override
			public boolean accept(Match match)
			{
				//TODO: We can filter rule here
				return true;
			}
		});

		droolsManager.disposeSession(kieSession);

		return fireRules;
	}

	@Override
	protected RuleEnginType ruleEnginType()
	{
		return RuleEnginType.DROOLS;
	}
}
