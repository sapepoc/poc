package com.sapient.api.stepdefinitions.helpers;

import java.util.ArrayList;
import java.util.List;

import org.sapient.AppClient;
import org.sapient.FactProcessor;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.WashTradeRuleEngin;
import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.trade.alarm.WashTradeEvent;
import org.sapient.ruleengin.utils.MockTradeDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class WashTradeHelper {
	protected final List<AlarmEvent> events;	
	private ConfigurableApplicationContext context;
	
	public WashTradeHelper() {
		events = new ArrayList<>();
	}
	protected List<Trade> getFacts() {
		return MockTradeDataProvider.createDummyTrades();
	}
	
	protected void fireRules(List<Trade> facts) {
		context = SpringApplication.run(AppClient.class);
		//WashTradeRuleEngin washTradeRuleEngin = context.getBean(WashTradeRuleEngin.class);
		WashTradeRuleEngin washTradeRuleEngin = new WashTradeRuleEngin(new FactProcessor<WashTrade>() {
			
			@Override
			public void process(WashTrade washTrade) {
				System.out.println("WashTradeReceived event received="+washTrade);
				System.out.println("Caught--->>>>>>>>" + washTrade.getBuy());
				events.add(new WashTradeEvent(washTrade));
			}
		});
		AppClient.fireRules(washTradeRuleEngin, facts);
		
		System.out.println("I am done");
	}
	
	protected List<AlarmEvent> getAlarmEvents() {
		/*WashTradeEventObserver observer = context.getBean(WashTradeEventObserver.class);
		events.addAll(observer.getAlarmEvents());*/
		return events;
	}
}
