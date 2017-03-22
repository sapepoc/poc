package org.sapient.trade;

public class TradeIdentifier 
{
	private String security;
	private String company;
	private String date;
	
	public TradeIdentifier(String security, String company, String date) 
	{
		this.security = security;
		this.company = company;
		this.date = date;
	}

	public String getSecurity() 
	{
		return security;
	}
	
	public String getCompany() 
	{
		return company;
	}

	
	public String getDate()
	{
		return date;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((security == null) ? 0 : security.hashCode());
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
		TradeIdentifier other = (TradeIdentifier) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "TradeIdentifier [security=" + security + ", company=" + company + ", date=" + date + "]";
	}
}
