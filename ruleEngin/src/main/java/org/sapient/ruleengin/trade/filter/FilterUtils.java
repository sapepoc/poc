package org.sapient.ruleengin.trade.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sapient.entites.trade.Trades.Trade;



/**
 * Responsibility to filter the trade on the provided filter bases.
 */
public class FilterUtils
{
	public static <T> Map<T,  List<Trade>> filter(TradeFilter<T> transactionFilter, List<Trade> transactions)
	{
		Map<T,  List<Trade>> map = new HashMap<T,  List<Trade>>();
		
		for (Trade trade : transactions) 
		{
			T key = transactionFilter.getValue(trade);
			List<Trade> trans = map.get(key);
			if(trans == null)
			{
				trans = new ArrayList<Trade>();
				map.put(key,trans);
			}
			trans.add(trade);
		}
		
		return map;
	}
	
	public static <T> List<List<Trade>> filter0(TradeFilter<T> transactionFilter, List<Trade> transactions)
	{
		List<List<Trade>> lists = new ArrayList<List<Trade>>();
		Map<T,  List<Trade>> map = filter(transactionFilter,transactions);
		for (List<Trade> list : map.values())
		{
			lists.add(list);
		}
		
		return lists;
	}
	
	public static <T> List<List<Trade>> filter(List<Trade> transactions, 
			List<TradeFilter<?>> transactionFilters)
	{
		List<List<Trade>> lists = new ArrayList<List<Trade>>();
		lists.add(transactions);
		for (TradeFilter<?> transactionFilter : transactionFilters) 
		{
			List<List<Trade>> currentLists = new ArrayList<List<Trade>>();
			currentLists.addAll(lists);
			lists.clear();
			for (List<Trade> list : currentLists)
			{
				List<List<Trade>> filterLists = filter0(transactionFilter, list);
				lists.addAll(filterLists);
			}
		}
		
		return lists;
	}
}
