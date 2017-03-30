package org.sapient.model;

import java.util.Date;

import com.sample.model.Fact;

/**
 * 
 * @author hgaur2
 *
 */
public class Trade implements Fact {
	private String user;
	private String security;
	private int amount;
	private Date date;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Trade [user=" + user + ", security=" + security + ", amount=" + amount + ", date=" + date + "]";
	}

}
