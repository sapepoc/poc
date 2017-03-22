package org.sapient.trade.model;


public class Trade
{
	private TradeType tradeType;
	private String company;
	private String security;
	private double amount;
	private int quantity;
	private long time;

	public Trade(TradeType tradeType, String company, String security, double amount, int quantity, long time)
	{
		this.tradeType = tradeType;
		this.company = company;
		this.security = security;
		this.amount = amount;
		this.quantity = quantity;
		this.time = time;
	}
	
	public TradeType getTradeType()
	{
		return tradeType;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	public String getSecurity() 
	{
		return security;
	}
	
	public double getAmount() 
	{
		return amount;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public long getTime()
	{
		return time;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((security == null) ? 0 : security.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (quantity != other.quantity)
			return false;
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		if (time != other.time)
			return false;
		if (tradeType != other.tradeType)
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Trade [tradeType=" + tradeType + ", company=" + company + ", security=" + security + ", amount="
				+ amount + ", quantity=" + quantity + ", time=" + time + "]";
	}
}
