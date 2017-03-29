package org.sapient.ruleengine.trade.model;

public class Entity 
{
	protected long id;
	
	protected Entity(long id)
	{
		this.id = id;
	}
	
	protected long getId() 
	{
		return id;
	}
}
