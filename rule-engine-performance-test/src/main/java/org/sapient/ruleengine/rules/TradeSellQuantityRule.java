package org.sapient.ruleengine.rules;

import java.util.List;

import org.sapient.ruleengine.events.FxTradeEvent;
import org.sapient.ruleengine.facts.FxTrade;
import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.trade.model.TradeType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TradeSellQuantityRule extends AbstarctRule
{
	@Value("${trade.sell.quantity.rule}")
	private int quantity;
	
	@Override
	public boolean fireRule(List<TradeData> tradeDatas) 
	{
		boolean ruleFire = false;
		for (TradeData tradeData : tradeDatas)
		{
			if(tradeData.getTradeType().equals(TradeType.SELL)
					&& tradeData.getQuantity() > quantity)
			{
				fireAlarmEvent(new FxTradeEvent("TradeBuyQuantityRule violation!", new FxTrade(tradeData, null)));
				ruleFire = true;
			}
		}
		
		return ruleFire;
	}
}
