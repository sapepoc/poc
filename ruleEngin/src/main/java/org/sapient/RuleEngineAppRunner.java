package org.sapient;

import java.util.ArrayList;
import java.util.List;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.RuleEngin;
import org.sapient.ruleengin.RuleEnginImpl;
import org.sapient.ruleengin.facts.RuleType;
import org.sapient.ruleengin.utils.EntityTransformer;
import org.sapient.ruleengin.utils.MockTradeDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:application-context.xml" })
public class RuleEngineAppRunner 
{
	public static ConfigurableApplicationContext startApplication(String[] args)
	{
		return SpringApplication.run(RuleEngineAppRunner.class, args);
	}
	
	public static ConfigurableApplicationContext startApplication()
	{
		return SpringApplication.run(RuleEngineAppRunner.class);
	}
	
	public static void fireRules(RuleEngin ruleEngin, List<Trade> trades)
	{
		List<RuleType> ruleTypes = new ArrayList<>();
		ruleTypes.add(RuleType.WASH_TRADE_RULE);
		ruleEngin.fireRule(ruleTypes, EntityTransformer.externalTradeToInternalTradeData(trades));
	}
	
	private static List<Trade> getFacts()
	{
		return MockTradeDataProvider.createDummyTrades();
	}
	
	public static ConfigurableApplicationContext startRuleEngin()
	{
		return SpringApplication.run(RuleEngineAppRunner.class);
	}
	
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = startApplication(args);
		RuleEngin engin = context.getBean(RuleEnginImpl.class);
		fireRules(engin, getFacts());
	}
}
