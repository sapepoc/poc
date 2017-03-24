package com.sapient.api.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.alarm.core.AlarmEvent;
import org.sapient.ruleengin.trade.WashTrade;
import org.sapient.ruleengin.trade.alarm.WashTradeEvent;
import org.sapient.ruleengin.trade.alarm.WashTradeEventObserver;

import com.sapient.api.stepdefinitions.helpers.WashTradeHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author aagr31
 *
 */
public class WashTradeFeatureStepDefinition extends WashTradeHelper {
	
	private List<Trade> facts = new ArrayList<>();
	private List<AlarmEvent> washTradeEvents;
	
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
		washTradeEvents  = getAlarmEvents();
		//washTradeEvents.get(0);
		System.out.println(washTradeEvents.size());
		if(washTradeEvents.isEmpty()) {
			assertNull(washTradeEvents);
		} else {
			for (AlarmEvent alarmEvent : washTradeEvents) {
				WashTradeEvent washTradeEvent = (WashTradeEvent) alarmEvent;
				List<WashTrade> washTrades = washTradeEvent.getWashTrade();
				washTrades.forEach(washtrade -> { assertEquals("HCL", washtrade.getBuy().getSecurity());
				 									assertEquals("Airtel", washtrade.getBuy().getCompany());
				 									assertEquals((Integer)50, washtrade.getBuy().getQuantity());
				 									assertEquals((Integer)50, washtrade.getSell().getQuantity());
				 									assertEquals("HCL", washtrade.getSell().getSecurity());
				 									assertEquals("Airtel", washtrade.getSell().getCompany());
				 									});
			}
		}
	}

	@Then("^Wash trade event is generated$")
	public void washTradeEventIsGenerated() throws Throwable {
		assertTrue("Wash Trade Event found", (washTradeEvents.get(0) instanceof WashTradeEvent));
	}
}
