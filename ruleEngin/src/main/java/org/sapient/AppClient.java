package org.sapient;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.sapient.alarm.core.AlarmEventListener;
import org.sapient.alarm.core.AlarmEventProcessor;
import org.sapient.trade.WashTrade;
import org.sapient.trade.alarm.WashTradeEvent;
import org.sapient.trade.filter.FilterUtils;
import org.sapient.trade.filter.TradeFiltersHolder;
import org.sapient.trade.model.Trade;
import org.sapient.trade.model.TradeType;
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
	public static List<Trade> createDummyTrades()
	{
		List<Trade> trades  = new ArrayList<Trade>();
		trades.add(new Trade(TradeType.BUY, "Sapient", "Airtel", 40, 10, System.currentTimeMillis()));
		trades.add(new Trade(TradeType.SELL, "Sapient", "Airtel", 40, 10, System.currentTimeMillis()));
		trades.add(new Trade(TradeType.BUY, "Siemens", "Idea", 52, 8, System.currentTimeMillis()));
		trades.add(new Trade(TradeType.BUY, "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		trades.add(new Trade(TradeType.BUY, "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		trades.add(new Trade(TradeType.SELL, "HCL", "Airtel", 50, 6, System.currentTimeMillis()));
		
		return trades;
	}
	
	private static void tradeFilterTest(AlarmEventListener alarmEventListener, TradeFiltersHolder tradeFiltersHolder)
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("ksession-rules-trade");
		statelessKieSession.setGlobal("alarmEventListener", alarmEventListener);
		
		//registerDefultAgendaEventListener(alarmEventListener, statelessKieSession);
		
		List<List<Trade>> filter = FilterUtils.filter(createDummyTrades(), tradeFiltersHolder.getTradeFilters());
		System.out.println(filter.size());
		for (List<Trade> trades : filter) 
		{
			statelessKieSession.execute(trades);
		}	
		
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
						alarmEventListener.addEvent( new WashTradeEvent(washTrades));
					}
				}
			}
		});
	}
	
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(AppClient.class, args);
		AlarmEventListener alarmEventListener = context.getBean(AlarmEventProcessor.class);
		TradeFiltersHolder tradeFiltersHolder = context.getBean(TradeFiltersHolder.class);
		
		tradeFilterTest(alarmEventListener, tradeFiltersHolder);
	}
}
