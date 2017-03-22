package org.sapient.trade.grouper;

import java.util.HashSet;
import java.util.Set;

import org.sapient.trade.model.Trade;

public final class TradeGroupResult
{
	private final Set<Trade> unique;
	private final Set<Trade> pairs; 
	
	public TradeGroupResult()
	{
		unique = new HashSet<Trade>();
		pairs = new HashSet<Trade>();
	}

	public Set<Trade> getPairs()
	{
		return pairs;
	}

	public Set<Trade> getUnique() 
	{
		return unique;
	}

	public void addPair(Trade t1, Trade t2)
	{
		pairs.add(t1);
		pairs.add(t2);
	}

	public void addUnique(Trade transaction)
	{
		unique.add(transaction);
	}
}