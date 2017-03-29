package org.sapient;

import java.io.IOException;
import java.util.List;

import org.sapient.ruleengine.RuleEnginService;
import org.sapient.ruleengine.RuleEnginServiceImpl;
import org.sapient.ruleengine.observers.FxTradeEventObserver;
import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.utils.CommonUtils;
import org.sapient.ruleengine.utils.EntityTransformer;
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
		ConfigurableApplicationContext context = startApplication(args);
		
		List<TradeData> tradeData = EntityTransformer.externalTradeToInternalTradeData(
				MockTradeDataProvider.createDummyTrades(50000));
		
		RuleEnginService  ruleEnginService = context.getBean(RuleEnginServiceImpl.class);
		ruleEnginService.register(context.getBean(FxTradeEventObserver.class));
		CommonUtils.asleep(10000);
		ruleEnginService.applyRule(tradeData);
	}
}
