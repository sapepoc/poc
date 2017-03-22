package com.sample.model;

import java.math.BigDecimal;

public class Purchase
{
	private BigDecimal total;
	private double discount;

	public Purchase(BigDecimal total) 
	{
		this.total = total;
		this.discount = 0;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Purchase [total=" + total + ", discount=" + discount + "]";
	}
}