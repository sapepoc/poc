package org.sapient;

import java.io.IOException;
import java.util.List;

import org.sapient.ruleengine.RuleEnginService;
import org.sapient.ruleengine.RuleEnginServiceImpl;
import org.sapient.ruleengine.observers.FxTradeEventObserver;
import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.utils.CommonUtils;
import org.sapient.ruleengine.utils.MockTradeDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RuleEnginPerformanceTest 
{
	public static ConfigurableApplicationContext startApplication(String[] args)
	{
		return SpringApplication.run(RuleEnginPerformanceTest.class, args);
	}
	
	public static void main(String[] args) throws IOException
	{
		//System.setProperty("drools.ruleEngine", "reteoo");
		System.setProperty("Dkie.mbeans", "disabled");
		System.setProperty("Dkie.mbeans", "disable");
		ConfigurableApplicationContext context = startApplication(args);
//		
		List<TradeData> tradeData = MockTradeDataProvider.createAllDummyWashTrades(4);
		RuleEnginService  ruleEnginService = context.getBean(RuleEnginServiceImpl.class);
		CommonUtils.asleep(100);
		ruleEnginService.applyRule(tradeData);
	}
}
