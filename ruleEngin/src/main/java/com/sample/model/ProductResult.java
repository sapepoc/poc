package com.sample.model;

public class ProductResult 
{
	private Product product;
	private double totalPrice;
	public ProductResult()
	{
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ProductResult [product=" + product + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
