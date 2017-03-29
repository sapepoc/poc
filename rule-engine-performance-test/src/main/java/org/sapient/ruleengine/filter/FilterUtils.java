package org.sapient.ruleengine.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sapient.ruleengine.trade.model.TradeData;



/**
 * Responsibility to filter the trade on the provided filter bases.
 */
public class FilterUtils
{
	public static <T> Map<T,  List<TradeData>> filter(TradeFilter<T> transactionFilter, List<TradeData> transactions)
	{
		Map<T,  List<TradeData>> map = new HashMap<T,  List<TradeData>>();
		
		for (TradeData trade : transactions) 
		{
			T key = transactionFilter.getValue(trade);
			List<TradeData> trans = map.get(key);
			if(trans == null)
			{
				trans = new ArrayList<TradeData>();
				map.put(key,trans);
			}
			trans.add(trade);
		}
		
		return map;
	}
	
	public static <T> List<List<TradeData>> filter0(TradeFilter<T> transactionFilter, List<TradeData> transactions)
	{
		List<List<TradeData>> lists = new ArrayList<List<TradeData>>();
		Map<T,  List<TradeData>> map = filter(transactionFilter,transactions);
		for (List<TradeData> list : map.values())
		{
			lists.add(list);
		}
		
		return lists;
	}
	
	public static <T> List<List<TradeData>> filter(List<TradeData> transactions, 
			List<TradeFilter<?>> transactionFilters)
	{
		List<List<TradeData>> lists = new ArrayList<List<TradeData>>();
		lists.add(transactions);
		for (TradeFilter<?> transactionFilter : transactionFilters) 
		{
			List<List<TradeData>> currentLists = new ArrayList<List<TradeData>>();
			currentLists.addAll(lists);
			lists.clear();
			for (List<TradeData> list : currentLists)
			{
				List<List<TradeData>> filterLists = filter0(transactionFilter, list);
				lists.addAll(filterLists);
			}
		}
		
		return lists;
	}
}
