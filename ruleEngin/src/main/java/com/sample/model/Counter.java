package com.sample.model;

public final class Counter 
{
	public String name;
	public int count;

	public Counter(int cnt, String name) 
	{
		this.count = cnt;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}