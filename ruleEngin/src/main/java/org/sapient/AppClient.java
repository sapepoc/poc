package org.sapient;

import java.util.ArrayList;
import java.util.List;

import org.drools.core.command.runtime.BatchExecutionCommandImpl;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.alarm.core.AlarmEventListener;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.trade.filter.TradeFiltersHolder;
import org.sapient.ruleengin.trade.model.TradeType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.sample.api.KieContainerProvider;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({ "classpath:application-context.xml" })
public class AppClient
{
	private static Trade createTrade(int tradeId, String type, String security, String company, int quantity, double amount, long time)
	{
		Trade trade  = new Trade();
		trade.setId(tradeId);
		trade.setTradeType(type);
		trade.setSecurity(security);
		trade.setCompany(company);
		trade.setQuantity(quantity);
		trade.setAmount(amount);
		trade.setTime(time);
		return trade;
	}
	
	public static List<Trade> createDummyTrades()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		trades.add(createTrade(1, TradeType.BUY.toString(), "Sapient", "Airtel", 40, 10, System.currentTimeMillis()));
		trades.add(createTrade(2, TradeType.SELL.toString(), "Sapient", "Airtel", 40, 10, System.currentTimeMillis()));
		trades.add(createTrade(3, TradeType.BUY.toString(), "Siemens", "Idea", 52, 8, System.currentTimeMillis()));
		trades.add(createTrade(4, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		trades.add(createTrade(5, TradeType.BUY.toString(), "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		trades.add(createTrade(6, TradeType.SELL.toString(), "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		
		return trades;
	}
	
	private static void tradeFilterTest(FactProcessor<WashTrade> factProcessor, TradeFiltersHolder tradeFiltersHolder)
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("ksession-rules-trade-wash");
		statelessKieSession.setGlobal("factProcessor", factProcessor);
		//registerDefultAgendaEventListener(alarmEventListener, statelessKieSession);
		
		//List<List<Trade>> filter = FilterUtils.filter(createDummyTrades(), tradeFiltersHolder.getTradeFilters());
		statelessKieSession.execute(createDummyTrades());
//		for (List<Trade> trades : filter) 
//		{
//			statelessKieSession.execute(trades);
//		}	
		
	}

	private static void registerDefultAgendaEventListener(AlarmEventListener alarmEventListener,
			StatelessKieSession statelessKieSession) 
	{
		statelessKieSession.addEventListener(new DefaultAgendaEventListener(){
			@Override
			public void matchCreated(MatchCreatedEvent event)
			{
				super.matchCreated(event);
				List<Object> objects = event.getMatch().getObjects();
				for (Object object : objects)
				{
					if(object instanceof List)
					{
						List<WashTrade> washTrades = (List<WashTrade>)object;
						//alarmEventListener.addEvent( new WashTradeEvent(washTrades));
					}
				}
			}
		});
	}
	
	public static void main(String[] args)
	{
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		
		ConfigurableApplicationContext context = SpringApplication.run(AppClient.class, args);
		FactProcessor<WashTrade> factProcessor = context.getBean(WashTradeProcessor.class);
		TradeFiltersHolder tradeFiltersHolder = context.getBean(TradeFiltersHolder.class);
		
		tradeFilterTest(factProcessor, tradeFiltersHolder);
	}
}
