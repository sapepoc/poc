package org.sapient.ruleengin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sapient.ruleengin.facts.FactProcessor;
import org.sapient.ruleengin.trade.WashTrade;

public abstract class AbstarctTest 
{
	protected class DummyFactProcessor implements FactProcessor<WashTrade>
	{
		List<WashTrade> washTrades;
		public DummyFactProcessor() 
		{
			this.washTrades = new ArrayList<>();
		}
		
		@Override
		public void process(WashTrade fact) 
		{
			washTrades.add(fact);
		}
		
		List<WashTrade> getAllEvents()
		{
			return washTrades;
		}
	}
	
	protected Set<String> createWashTradeRules(String... rules) 
	{
		Set<String> washTradeRules = new HashSet<>();
		for(String rule : rules)
		{
			washTradeRules.add(rule);
		}
		return washTradeRules;
	}
	
}
