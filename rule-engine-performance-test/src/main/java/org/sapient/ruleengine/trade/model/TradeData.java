package org.sapient.ruleengine.trade.model;

public class TradeData extends Entity
{
	private TradeType tradeType;
	private String security;
	private String company;
	private int quantity;
	private double amount;
	private long dateTime;

	public TradeData(long id, TradeType tradeType, String security, String company,
			int quantity, double amount, long dateTime)
	{
		super(id);
		this.tradeType = tradeType;
		this.security = security;
		this.company = company;
		this.quantity = quantity;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public String getSecurity() {
		return security;
	}

	public String getCompany() {
		return company;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getAmount() {
		return amount;
	}

	public long getDateTime() {
		return dateTime;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + (int) (dateTime ^ (dateTime >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((security == null) ? 0 : security.hashCode());
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeData other = (TradeData) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (dateTime != other.dateTime)
			return false;
		if (quantity != other.quantity)
			return false;
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		if (tradeType != other.tradeType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TradeData [id=" + id + ", tradeType=" + tradeType + ", security=" + security + ", company=" + company + ", quantity="
				+ quantity + ", amount=" + amount + ", dateTime=" + dateTime + "]";
	}
	
	
}
