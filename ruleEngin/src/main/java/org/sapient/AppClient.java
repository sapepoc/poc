package org.sapient;

import org.sapient.ruleengin.TradeRuleEngin;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.utils.MockTradeDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({ "classpath:application-context.xml" })
public class AppClient
{

	private static void tradeFilterTest(FactProcessor<WashTrade> factProcessor)
	{
		new TradeRuleEngin().fireRulesWithStatelessSession(factProcessor, "ksession-rules-trade-wash", 
				MockTradeDataProvider.createDummyTrades());
	}

	public static void main(String[] args)
	{
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		ConfigurableApplicationContext context = SpringApplication.run(AppClient.class, args);
		tradeFilterTest(context.getBean(WashTradeProcessor.class));
	}
}
