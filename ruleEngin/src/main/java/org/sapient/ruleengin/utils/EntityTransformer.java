package org.sapient.ruleengin.utils;

import java.util.ArrayList;
import java.util.List;

import org.sapient.entites.trade.Trades.Trade;
import org.sapient.ruleengin.trade.model.TradeData;
import org.sapient.ruleengin.trade.model.TradeType;

public class EntityTransformer
{
	private EntityTransformer(){}
	
	public static List<TradeData> externalTradeToInternalTradeData(List<Trade> trades)
	{
		List<TradeData> tradeDatas = new ArrayList<>();
		for(Trade trade : trades)
		{
			TradeData tradeData = 
					new TradeData(trade.getId(),
							TradeType.getTradeType(trade.getTradeType()), trade.getSecurity(), trade.getCompany(), 
							trade.getQuantity(), 
							trade.getAmount(), 
							trade.getTime());
			
			tradeDatas.add(tradeData);
		}
		
		return tradeDatas;
	}
}
