package org.sapient.trade;

public class WashTradeIdentifier extends TradeIdentifier
{
	private int quantity;
	
	public WashTradeIdentifier(String security, String company, String date, int quantity) 
	{
		super(security, company, date);
		this.quantity = quantity;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WashTradeIdentifier other = (WashTradeIdentifier) obj;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
