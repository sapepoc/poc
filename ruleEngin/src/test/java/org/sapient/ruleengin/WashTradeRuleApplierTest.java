package org.sapient.ruleengin;

import static org.hamcrest.core.Is.is;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.sapient.ruleengin.utils.EntityTransformer;
import org.sapient.ruleengin.utils.MockTradeDataProvider;

public class WashTradeRuleApplierTest extends AbstarctTest
{
	private String sessionName = "ksession-rules-trade-wash";
	private RuleApplier ruleApplier;
	
	@Test
	public void whenTradeDataHaveNoeAnyWashTrade_applyRule_washTradeEventShouldNotBeGenerated()
	{
		Set<String> washTradeRules = createWashTradeRules("Wash trade rule");
		DummyFactProcessor dummyFactProcessor = new DummyFactProcessor();
		ruleApplier = new WashTradeRuleApplier(dummyFactProcessor, sessionName, washTradeRules);
		ruleApplier.applyRule(
				EntityTransformer.externalTradeToInternalTradeData(MockTradeDataProvider.createDummyTradeDataWithoutAnyWashTrade()));
		int noOfWashTrades = 0;
		Assert.assertThat(noOfWashTrades, is(dummyFactProcessor.getAllEvents().size()));
	}
	
	@Test
	public void whenTradeDataHaveOneWashTrade_applyRule_washTradeEventShouldBeGenerated()
	{
		Set<String> washTradeRules = createWashTradeRules("Wash trade rule");
		DummyFactProcessor dummyFactProcessor = new DummyFactProcessor();
		ruleApplier = new WashTradeRuleApplier(dummyFactProcessor, sessionName, washTradeRules);
		ruleApplier.applyRule(
				EntityTransformer.externalTradeToInternalTradeData(MockTradeDataProvider.createDummyTradeDataWithOneWashTrade()));
		int noOfWashTrades = 1;
		Assert.assertThat(noOfWashTrades, is(dummyFactProcessor.getAllEvents().size()));
	}
	
	@Test
	public void whenTradeDataHaveThreeWashTrade_applyRule_washTradeEventShouldBeGenerated()
	{
		Set<String> washTradeRules = createWashTradeRules("Wash trade rule");
		
		DummyFactProcessor dummyFactProcessor = new DummyFactProcessor();
		ruleApplier = new WashTradeRuleApplier(dummyFactProcessor, sessionName, washTradeRules);
		ruleApplier.applyRule(
				EntityTransformer.externalTradeToInternalTradeData(MockTradeDataProvider.createDummyTrades()));
		int noOfWashTrades = 3;
		Assert.assertThat(noOfWashTrades, is(dummyFactProcessor.getAllEvents().size()));
	}
}
