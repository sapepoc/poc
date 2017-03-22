package org.sapient.trade.grouper;

import java.util.List;

import org.sapient.trade.model.Trade;

public class TradeGrouper
{
	public TradeGroupResult group(List<Trade> transactions, List<GrouperRule> pairRules)
	{
		TradeGroupResult transactionGroupResult = new TradeGroupResult();
		
		for (int i = 0; i < transactions.size(); i++) 
		{
			boolean pairAdded = false;
			for (int j = i + 1; j < transactions.size(); j++) 
			{
				for(GrouperRule pairRule: pairRules)
				{
					if(pairRule.isValidPair(transactions.get(i).getTradeType(), transactions.get(j).getTradeType()))
					{
						if(!transactionGroupResult.getPairs().contains(transactions.get(i))
								&& !transactionGroupResult.getPairs().contains(transactions.get(j)))
						{
							transactionGroupResult.addPair(transactions.get(i), transactions.get(j));
							pairAdded = true;
							break;
						}
					}
				}
				if(pairAdded)
					break;
			}
			if(!pairAdded && !transactionGroupResult.getPairs().contains(transactions.get(i)))
				transactionGroupResult.addUnique(transactions.get(i));
		}
		
		return transactionGroupResult;
	}
}
