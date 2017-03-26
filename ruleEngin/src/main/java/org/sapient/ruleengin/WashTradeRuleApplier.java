package org.sapient.ruleengin;

import java.util.Set;

import org.kie.api.runtime.KieSession;
import org.sapient.ruleengin.facts.FactProcessor;
import org.sapient.ruleengin.trade.WashTrade;

public class WashTradeRuleApplier extends AbstractRuleApplier
{
	private static final String DEFAUT_WASH_TRADE_KSESSION = "ksession-rules-trade-wash";
	private FactProcessor<WashTrade> factProcessor;
	
	public WashTradeRuleApplier(FactProcessor<WashTrade> factProcessor, 
			String sessionName, Set<String> washTradeRules)
	{
		super((sessionName == null || sessionName.trim().isEmpty()  ?
				DEFAUT_WASH_TRADE_KSESSION : sessionName), washTradeRules);
		
		this.factProcessor = factProcessor;
	}

	@Override
	protected void addFactProcessor(KieSession kieSession)
	{
		kieSession.setGlobal("factProcessor", factProcessor);
	}
}
