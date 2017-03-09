package org.sapient.dto;


public final class PriceEntity extends Entity<Double>
{
	private static final long serialVersionUID = 1L;
	public PriceEntity()
	{
	}
	public PriceEntity(String id, String name, double price)
	{
		super(id, name, price);
	}
}