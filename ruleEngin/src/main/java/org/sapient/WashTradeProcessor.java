package org.sapient;

import java.util.HashSet;
import java.util.Set;

import org.sapient.ruleengin.alarm.core.AlarmEventListener;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.trade.alarm.WashTradeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WashTradeProcessor implements FactProcessor<WashTrade>
{
	private AlarmEventListener alarmEventListener;
	private Set<Integer> washTradeHolder;
	
	@Autowired
	public WashTradeProcessor(AlarmEventListener alarmEventListener)
	{
		this.alarmEventListener = alarmEventListener;
		washTradeHolder = new HashSet<>();
	}
	
	@Override
	public void process(WashTrade washTrade) 
	{
		//if(!washTradeHolder.contains(washTrade.getBuy().getId()) && !washTradeHolder.contains(washTrade.getSell().getId())){
			washTradeHolder.add(washTrade.getBuy().getId());
			washTradeHolder.add(washTrade.getSell().getId());
			WashTradeEvent washTradeEvent = new WashTradeEvent();
			washTradeEvent.addWashTrade(washTrade);
			alarmEventListener.addEvent(washTradeEvent);
		//}
	}
}
