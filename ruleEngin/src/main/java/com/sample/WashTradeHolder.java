package com.sample;

import java.util.HashSet;
import java.util.Set;

public class WashTradeHolder
{
	private Set<Integer> washTrades;

	public WashTradeHolder() 
	{
		this.washTrades = new HashSet<>();
	}

	public Set<Integer> getWashTrades() {
		return washTrades;
	}

	public void setWashTrades(Set<Integer> washTrades) {
		this.washTrades = washTrades;
	}

	@Override
	public String toString() {
		return "WashTradeHolder [washTrades=" + washTrades + "]";
	}
}
