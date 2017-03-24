package org.sapient.ruleengin;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.alarm.core.AlarmEventListener;
import org.sapient.ruleengin.trade.filter.FilterUtils;
import org.sapient.ruleengin.trade.filter.TradeFiltersHolder;
import org.sapient.ruleengin.utils.KieContainerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeEntityManager 
{
	private AlarmEventListener alarmEventListener;
	private TradeFiltersHolder tradeFiltersHolder;

	@Autowired
	public TradeEntityManager(AlarmEventListener alarmEventListener, TradeFiltersHolder tradeFiltersHolder)
	{
		this.alarmEventListener = alarmEventListener;
		this.tradeFiltersHolder = tradeFiltersHolder;
	}
	
	public void process(List<Trade> trades)
	{
		List<List<Trade>> filter = FilterUtils.filter(trades, tradeFiltersHolder.getTradeFilters());
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("ksession-rules-trade");
		statelessKieSession.setGlobal("alarmEventListener", alarmEventListener);

		for (List<Trade> tradeList : filter) 
		{
			statelessKieSession.execute(tradeList);
		}	
		
	}
}
