package com.sapient.api.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.trade.alarm.WashTradeEvent;

import com.sapient.api.stepdefinitions.helpers.WashTradeRuleApplierHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author aagr31
 */
public class WashTradeFeatureStepDefinition extends WashTradeRuleApplierHelper 
{
	private List<Trade> facts = new ArrayList<>();
	
	@Given("^set of trades$")
	public void setOfTrades() throws Throwable {
	    facts = getFacts();
	    assertNotNull("given list of facts", facts);
	}

	@When("^Wash Trade rule is applied$")
	public void washTradeRuleIsApplied() throws Throwable {
		fireRules(facts);
		Thread.sleep(1000);
		System.out.println("______________");
		
	}

	@Then("^following response is given$")
	public void followingResponseIsGiven(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<AlarmEvent> events = getAlarmEvents();
		assertEquals(3, events.size());
		Predicate<? super AlarmEvent> p1 = ae -> "Sapient1".equals(((WashTradeEvent)ae).getWashTrade().getBuy().getSecurity()) 
					&& "Airtel".equals(((WashTradeEvent)ae).getWashTrade().getBuy().getCompany())
					&& ((WashTradeEvent)ae).getWashTrade().getBuy().getQuantity() == 60;
		Predicate<? super AlarmEvent> p2 = ae -> "Siemens".equals(((WashTradeEvent)ae).getWashTrade().getBuy().getSecurity()) 
				&& "Idea".equals(((WashTradeEvent)ae).getWashTrade().getBuy().getCompany())
				&& ((WashTradeEvent)ae).getWashTrade().getBuy().getQuantity() == 52;
		Predicate<? super AlarmEvent> p3 = ae -> "HCL".equals(((WashTradeEvent)ae).getWashTrade().getBuy().getSecurity()) 
				&& "Airtel".equals(((WashTradeEvent)ae).getWashTrade().getBuy().getCompany())
				&& ((WashTradeEvent)ae).getWashTrade().getBuy().getQuantity() == 50;
		assertTrue(events.parallelStream().anyMatch(p1));
		assertTrue(events.parallelStream().anyMatch(p2));
		assertTrue(events.parallelStream().anyMatch(p3));
	}

	@Then("^Wash trade event is generated$")
	public void washTradeEventIsGenerated() throws Throwable {
		assertTrue("Wash Trade Event found", (getAlarmEvents().get(0) instanceof WashTradeEvent));
	}
}
