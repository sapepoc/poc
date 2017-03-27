package org.sapient.ruleengine.trade.grouper;

import java.util.List;

import org.sapient.entites.trade.Trades.Trade;

public class TradeGrouper
{
	public TradeGroupResult group(List<Trade> trades, List<GrouperRule> pairRules)
	{
		TradeGroupResult transactionGroupResult = new TradeGroupResult();
		
		for (int i = 0; i < trades.size(); i++) 
		{
			boolean pairAdded = false;
			for (int j = i + 1; j < trades.size(); j++) 
			{
				for(GrouperRule pairRule: pairRules)
				{
					if(pairRule.isValidPair(trades.get(i).getTradeType(), trades.get(j).getTradeType()))
					{
						if(!transactionGroupResult.getPairs().contains(trades.get(i))
								&& !transactionGroupResult.getPairs().contains(trades.get(j)))
						{
							transactionGroupResult.addPair(trades.get(i), trades.get(j));
							pairAdded = true;
							break;
						}
					}
				}
				if(pairAdded)
					break;
			}
			if(!pairAdded && !transactionGroupResult.getPairs().contains(trades.get(i)))
				transactionGroupResult.addUnique(trades.get(i));
		}
		
		return transactionGroupResult;
	}
}
