package org.sapient;

import java.io.IOException;

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
//		List<TradeData> tradeData = MockTradeDataProvider.createAllDummyWashTrades(50000);
//		
//		RuleEnginService  ruleEnginService = context.getBean(RuleEnginServiceImpl.class);
//		ruleEnginService.register(context.getBean(FxTradeEventObserver.class));
//		CommonUtils.asleep(100);
//		ruleEnginService.applyRule(tradeData);
	}
}
