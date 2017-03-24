package org.sapient.ruleengin;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.sapient.FactProcessor;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.utils.KieContainerProvider;
import org.sapient.ruleengin.utils.KieSessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WashTradeRuleEngin extends TradeRuleEngin
{
	private FactProcessor<WashTrade> factProcessor;
	private String sessionName = "ksession-rules-trade-wash";
	
	@Autowired
	public WashTradeRuleEngin(FactProcessor<WashTrade> factProcessor)
	{
		this.factProcessor = factProcessor;
	}
	
	public void fireRulesWithStatelessSession(List<Trade> trades)
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		StatelessKieSession statelessKieSession = KieSessionHelper.createStatelessSession(kieContainer, sessionName);
		statelessKieSession.setGlobal("factProcessor", factProcessor);
		statelessKieSession.execute(trades);
	}
}
