package org.sapient;

import java.util.List;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.WashTradeRuleEngin;
import org.sapient.ruleengin.utils.MockTradeDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ImportResource({ "classpath:application-context.xml" })
public class AppClient
{
	public static void fireRules(WashTradeRuleEngin washTradeRuleEngin, List<Trade> trades)
	{
		washTradeRuleEngin.fireRulesWithStatelessSession(trades);
	}
	
	/*private static void tradeFilterTest(FactProcessor<WashTrade> factProcessor)
	{
		new TradeRuleEngin().fireRulesWithStatelessSession(factProcessor, "ksession-rules-trade-wash", 
				getFacts());
	}*/

	public static List<Trade> getFacts() {
		return MockTradeDataProvider.createDummyTrades();
	}

	public static void main(String[] args)
	{
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		ConfigurableApplicationContext context = SpringApplication.run(AppClient.class, args);
//		tradeFilterTest(context.getBean(WashTradeProcessor.class));
		WashTradeRuleEngin washTradeRuleEngin = context.getBean(WashTradeRuleEngin.class);
		fireRules(washTradeRuleEngin, getFacts());
	}
}
