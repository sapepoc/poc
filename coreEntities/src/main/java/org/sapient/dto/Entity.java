package org.sapient.dto;

import java.io.Serializable;

/**
 * 
 * @author OM SINGH
 */
public class Entity<V extends Serializable> implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private V value;
	
	public Entity() 
	{}
	
	public Entity(String id, String name, V value) 
	{
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public V getValue() 
	{
		return value;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
}
