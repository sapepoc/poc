package com.sapient.api.stepdefinitions.helpers;

import java.util.ArrayList;
import java.util.List;

import org.sapient.model.Trade;
import org.sapient.ruleengine.RuleEngin;
import org.sapient.ruleengine.RuleEnginImpl;
import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.facts.RuleType;
import org.springframework.context.ConfigurableApplicationContext;



public class WashTradeRuleApplierHelper 
{
	private ConfigurableApplicationContext context;
	
	public WashTradeRuleApplierHelper()
	{
		startApp();
	}
	
	protected void startApp()
	{
	}
	
	protected List<Trade> getFacts() 
	{return null;
	}
	
	protected void fireRules(RuleEngin ruleEngin, List<Trade> trades)
	{
		List<RuleType> ruleTypes = new ArrayList<>();
		ruleTypes.add(RuleType.WASH_TRADE_RULE);
	}
	
	protected void fireRules(List<Trade> facts)
	{
		RuleEngin engin = context.getBean(RuleEnginImpl.class);
		fireRules(engin, getFacts());
	}
	
	protected List<AlarmEvent> getAlarmEvents() 
	{
		//WashTradeEventObserver observer = context.getBean(WashTradeEventObserver.class);
		return null;//observer.getAlarmEvents();
	}
}
