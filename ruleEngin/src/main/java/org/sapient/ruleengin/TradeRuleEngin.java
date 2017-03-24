package org.sapient.ruleengin;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.sapient.FactProcessor;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.utils.KieContainerProvider;
import org.sapient.ruleengin.utils.KieSessionHelper;

public class TradeRuleEngin
{
	public void fireRulesWithStatelessSession(FactProcessor<WashTrade> factProcessor, 
			String sessionName, List<Trade> trades)
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		StatelessKieSession statelessKieSession = KieSessionHelper.createStatelessSession(kieContainer, sessionName);
		statelessKieSession.setGlobal("factProcessor", factProcessor);
		statelessKieSession.execute(trades);
	}
}
