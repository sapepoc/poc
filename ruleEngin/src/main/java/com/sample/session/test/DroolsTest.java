package com.sample.session.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.sapient.AppClient;
import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.trade.filter.CompanyFilter;
import org.sapient.ruleengin.trade.filter.DateFilter;
import org.sapient.ruleengin.trade.filter.FilterUtils;
import org.sapient.ruleengin.trade.filter.QuantityFilter;
import org.sapient.ruleengin.trade.filter.SecuirtyFilter;
import org.sapient.ruleengin.trade.filter.TradeFilter;

import com.sample.api.KieContainerProvider;
import com.sample.model.Counter;
import com.sample.model.Product;
import com.sample.model.ProductType;
import com.sample.model.Purchase;

public class DroolsTest 
{
	
	public static List<TradeFilter<?>> createDummyTradeFilter()
	{
		List<TradeFilter<?>> tradeFilters  = new ArrayList<TradeFilter<?>>();
		//tradeFilters.add(new TradeTypeFilter());
		tradeFilters.add(new CompanyFilter());
		tradeFilters.add(new SecuirtyFilter());
		tradeFilters.add(new DateFilter());
		tradeFilters.add(new QuantityFilter());
		return tradeFilters;
	}
	
	private static void tradeFilterTest()
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("ksession-rules-trade");
		
		List<List<Trade>> filter = FilterUtils.filter(AppClient.createDummyTrades(), createDummyTradeFilter());
		System.out.println(filter.size());
		for (List<Trade> trades : filter) 
		{
			statelessKieSession.execute(trades);
		}
	}
	
	private static void accumulateTest()
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
		
		Product product1 = new Product("A", 1, ProductType.FASHION);
		Product product2 = new Product("B", 2, ProductType.FASHION);
		Product product3 = new Product("C", 3, ProductType.GROCERIES);
		kieSession.insert(ProductType.GROCERIES);
		kieSession.insert(product1);
		kieSession.insert(product2);
		kieSession.insert(product3);
		
		kieSession.fireAllRules();
	}
	
	private static void statefullSessionTest()
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
		
		Purchase purchase = new Purchase(new BigDecimal(13));
		kieSession.insert(purchase);
		kieSession.fireAllRules();
		
		purchase.setTotal(new BigDecimal(30));
		kieSession.insert(new Purchase(new BigDecimal(13)));
		kieSession.fireAllRules();
		System.out.println(purchase);
	}

	private static void test()
	{
		KieContainer kieContainer = KieContainerProvider.createKieContainer();
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
		
		Counter counter1 = new Counter(5, "cnt1");
		Counter counter2 = new Counter(7, "cnt2");

		System.out.println("fire rules after inserting counter1");
		kieSession.insert(counter1);
		//fire rules with counter1
		kieSession.fireAllRules();

		counter1.setCount(88);
		
		System.out.println("fire rules after inserting counter2");
		kieSession.insert(counter2);
		//fire rules with already existing counter1 and newly inserted counter2
		kieSession.fireAllRules();
		
		//Dispose the session at the end.
		kieSession.dispose();
	}
	
	public static final void main(String[] args) 
	{
		tradeFilterTest();
	}

}