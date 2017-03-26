package org.sapient.ruleengin.trade.model;

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
	public String toString() {
		return "TradeData [id=" + id + ", tradeType=" + tradeType + ", security=" + security + ", company=" + company + ", quantity="
				+ quantity + ", amount=" + amount + ", dateTime=" + dateTime + "]";
	}
	
	
}
