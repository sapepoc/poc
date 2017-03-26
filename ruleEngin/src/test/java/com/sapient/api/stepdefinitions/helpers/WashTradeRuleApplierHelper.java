package com.sapient.api.stepdefinitions.helpers;

import java.util.ArrayList;
import java.util.List;

import org.sapient.RuleEngineAppRunner;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.RuleEngin;
import org.sapient.ruleengin.RuleEnginImpl;
import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.facts.RuleType;
import org.sapient.ruleengin.trade.alarm.WashTradeEventObserver;
import org.sapient.ruleengin.utils.EntityTransformer;
import org.sapient.ruleengin.utils.MockTradeDataProvider;
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
		context = RuleEngineAppRunner.startRuleEngin();
	}
	
	protected List<Trade> getFacts() 
	{
		return MockTradeDataProvider.createDummyTrades();
	}
	
	protected void fireRules(RuleEngin ruleEngin, List<Trade> trades)
	{
		List<RuleType> ruleTypes = new ArrayList<>();
		ruleTypes.add(RuleType.WASH_TRADE_RULE);
		ruleEngin.fireRule(ruleTypes, EntityTransformer.externalTradeToInternalTradeData(trades));
	}
	
	protected void fireRules(List<Trade> facts)
	{
		RuleEngin engin = context.getBean(RuleEnginImpl.class);
		fireRules(engin, getFacts());
	}
	
	protected List<AlarmEvent> getAlarmEvents() 
	{
		WashTradeEventObserver observer = context.getBean(WashTradeEventObserver.class);
		return observer.getAlarmEvents();
	}
}
