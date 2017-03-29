package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;
import org.sapient.ruleengine.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractRuleEngin implements RuleEngin
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRuleEngin.class);
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

		System.gc();
		Runtime runtime = Runtime.getRuntime();
		long beforeUsedMemory = runtime.totalMemory() - runtime.freeMemory();
		long startTime = System.currentTimeMillis();
		
		int fireRules = fireRules0(entities, ruleDatas);
		
		long timeTakenInMillis = (System.currentTimeMillis() - startTime);
		long afterUsedMemory =  Runtime.getRuntime().totalMemory() -  Runtime.getRuntime().freeMemory();
		long memoryUsedInKB = afterUsedMemory - beforeUsedMemory;
		
		
		PerformanceReport performanceReport =  
				new PerformanceReport(fireRules, timeTakenInMillis, CommonUtils.bytesToMegabytes(memoryUsedInKB));
		
		LOGGER.info("Performance Details:: used rule engine:{} ,{}", ruleEnginType(), performanceReport);
	}
	
	protected abstract <T> int fireRules0(List<T> entities, List<RuleData> ruleDatas);
	
}
