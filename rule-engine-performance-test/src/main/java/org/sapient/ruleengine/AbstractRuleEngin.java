package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;
import org.sapient.ruleengine.utils.CommonUtils;

public abstract class AbstractRuleEngin implements RuleEngin
{
	protected AlarmEventProcessor alarmEventProcessor;

	public AbstractRuleEngin(AlarmEventProcessor alarmEventProcessor)
	{
		this.alarmEventProcessor = alarmEventProcessor;
	}
	
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
		
		System.out.println(performanceReport);
	
	}
	
	protected abstract <T> int fireRules0(List<T> entities, List<RuleData> ruleDatas);
	
}
