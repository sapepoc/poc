package org.sapient.ruleengine.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.sapient.ruleengine.events.FxTradeEvent;
import org.sapient.ruleengine.facts.FxTrade;
import org.sapient.ruleengine.filter.CompanyFilter;
import org.sapient.ruleengine.filter.DateFilter;
import org.sapient.ruleengine.filter.FilterUtils;
import org.sapient.ruleengine.filter.QuantityFilter;
import org.sapient.ruleengine.filter.SecuirtyFilter;
import org.sapient.ruleengine.filter.TradeFilter;
import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.trade.model.TradeType;
import org.springframework.stereotype.Component;

@Component
public class WashTradeRule  extends AbstarctRule
{
	private List<TradeFilter<?>> tradeFilters = null;
	public WashTradeRule()
	{
		tradeFilters = new ArrayList<TradeFilter<?>>();
		tradeFilters.add(new CompanyFilter());
		tradeFilters.add(new SecuirtyFilter());
		tradeFilters.add(new QuantityFilter());
		tradeFilters.add(new DateFilter());
	}
	
	@Override
	public boolean fireRule(List<TradeData> entities) 
	{
		boolean ruleFire = false;
		
		List<List<TradeData>> filter = FilterUtils.filter(entities , tradeFilters);
		int noOfFire = 0;
		TradeHolder tradeHolder = new TradeHolder();
		for (List<TradeData> tradeDatas : filter) 
		{
			tradeHolder.clear();
			for( TradeData tradeData : tradeDatas)
			{
				Set<TradeData> oppositeTrades = tradeHolder.getOppositeTrade(tradeData.getTradeType());
				if(oppositeTrades == null || oppositeTrades.isEmpty())
    			{
    				tradeHolder.addTrade(tradeData);
    			}
    			else
    			{
    				TradeData oppositeTrade = null;
    				if(tradeData.getTradeType().equals(TradeType.SELL))
    				{
    					oppositeTrade = getTradeDataByType(oppositeTrades, TradeType.BUY);
    				}
    				else
    				{
    					oppositeTrade = getTradeDataByType(oppositeTrades, TradeType.SELL);
    				}
    				
    				if(oppositeTrade != null)
    				{
    					tradeHolder.addTrade(oppositeTrade);
    					fireAlarmEvent(new FxTradeEvent("WashTradeRule - violation!", new FxTrade(tradeData, oppositeTrade)));
    					ruleFire = true;
    					noOfFire++;
    				}
    				else
    				{
    					tradeHolder.addTrade(tradeData);
    				}
    			}
			}
		}
		
		System.out.println("WashTradeRule- total number of trades found as wash trade="+ noOfFire);
		return ruleFire;
	}
	
	
	private TradeData getTradeDataByType(Set<TradeData> tradeDates, TradeType tradeType)
	{
		for (TradeData tradeDate : tradeDates) 
		{
			if( tradeDate.getTradeType().equals(tradeType))
			{

				return tradeDate;
			}
		}
		
		return null;
	}
}
